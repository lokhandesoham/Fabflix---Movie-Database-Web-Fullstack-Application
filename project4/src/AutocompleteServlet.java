import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashMap;

@WebServlet(name = "AutocompleteServlet", urlPatterns = "/hero-suggestion")
public class AutocompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource;

    public static HashMap<Integer, String> superHeroMap = new HashMap<>();
	
	static {
		superHeroMap.put(1, "Blade");
		superHeroMap.put(2, "Ghost Rider");
		superHeroMap.put(3, "Luke Cage");
		superHeroMap.put(4, "Silver Surfer");
		superHeroMap.put(5, "Beast");
		superHeroMap.put(6, "Thing");
		superHeroMap.put(7, "Black Panther");
		superHeroMap.put(8, "Invisible Woman");
		superHeroMap.put(9, "Nick Fury");
		superHeroMap.put(10, "Storm");
		superHeroMap.put(11, "Iron Man");
		superHeroMap.put(12, "Professor X");
		superHeroMap.put(13, "Hulk");
		superHeroMap.put(14, "Cyclops");
		superHeroMap.put(15, "Thor");
		superHeroMap.put(16, "Jean Grey");
		superHeroMap.put(17, "Wolverine");
		superHeroMap.put(18, "Daredevil");
		superHeroMap.put(19, "Captain America");
		superHeroMap.put(20, "Spider-Man");
		superHeroMap.put(101, "Superman");
		superHeroMap.put(102, "Batman");
		superHeroMap.put(103, "Wonder Woman");
		superHeroMap.put(104, "Flash");
		superHeroMap.put(105, "Green Lantern");
		superHeroMap.put(106, "Catwoman");
		superHeroMap.put(107, "Nightwing");
		superHeroMap.put(108, "Captain Marvel");
		superHeroMap.put(109, "Aquaman");
		superHeroMap.put(110, "Green Arrow");
		superHeroMap.put(111, "Martian Manhunter");
		superHeroMap.put(112, "Batgirl");
		superHeroMap.put(113, "Supergirl");
		superHeroMap.put(114, "Black Canary");
		superHeroMap.put(115, "Hawkgirl");
		superHeroMap.put(116, "Cyborg");
		superHeroMap.put(117, "Robin");
	}

    public void init(ServletConfig config) {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/moviedb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    /*
     * 
     * Match the query against superheroes and return a JSON response.
     * 
     * For example, if the query is "super":
     * The JSON response look like this:
     * [
     * 	{ "value": "Superman", "data": { "heroID": 101 } },
     * 	{ "value": "Supergirl", "data": { "heroID": 113 } }
     * ]
     * 
     * The format is like this because it can be directly used by the 
     *   JSON auto complete library this example is using. So that you don't have to convert the format.
     *   
     * The response contains a list of suggestions.
     * In each suggestion object, the "value" is the item string shown in the dropdown list,
     *   the "data" object can contain any additional information.
     * 
     * 
     */
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        request.getServletContext().log("In autocomplete servlet");
        //request.getServletContext().log(request.getRequestURI());

        String search = request.getParameter("query");

        System.out.println("Received query: " + search); 

        String query;
		try {

            Connection conn = dataSource.getConnection();
            System.out.println("DB connected"); 
            //Statement statement = conn.createStatement();

            PreparedStatement statement = null;

            List<String> wordsList = new ArrayList<>();

            query = "SELECT " +
                    "m.id, " +
                    "m.title, " +
                    "m.year, " +
                    "m.director, " +
                    "( " +
                    "    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) " +
                    "    FROM ( " +
                    "        SELECT g.name " +
                    "        FROM genres g " +
                    "        INNER JOIN genres_in_movies gm ON g.id = gm.genreId " +
                    "        WHERE gm.movieId = m.id " +
                    "        ORDER BY g.name ASC " +
                    "        LIMIT 3 " +
                    "    ) g " +
                    ") AS genres, " +
                    "( " +
                    "    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC) " +
                    "    FROM ( " +
                    "        SELECT s.id, s.name, COUNT(sm.movieId) AS total_movies " +
                    "        FROM stars s " +
                    "        INNER JOIN stars_in_movies sm ON s.id = sm.starId " +
                    "        GROUP BY s.id " +
                    "        ORDER BY total_movies DESC, s.name ASC " +
                    "    ) AS star_info " +
                    "    INNER JOIN stars_in_movies sm ON star_info.id = sm.starId " +
                    "    WHERE sm.movieId = m.id " +
                    "    LIMIT 3 " +
                    ") AS stars, " +
                    "ROUND(AVG(r.rating), 1) AS rating " +
                    "FROM " +
                    "movies m " +
                    "LEFT JOIN " +
                    "ratings r ON m.id = r.movieId " +
                    "WHERE " +
                    "m.title LIKE '% s%' " +
                    "AND m.title LIKE '% lov%' " +
                    "GROUP BY " +
                    "m.id " +
                    "ORDER BY m.title ASC LIMIT 10";

            statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();


			// setup the response json arrray
			JsonArray jsonArray = new JsonArray();

            while (rs.next()) {
                jsonArray.add(generateJsonObject(1, rs.getString("title")));
            }
            rs.close();
            statement.close();

            request.getServletContext().log(jsonArray.toString());
            

            request.getServletContext().log("getting " + jsonArray.size() + " results");

            out.write(jsonArray.toString());
            response.setStatus(200);
			
			
			// String query = request.getParameter("query");
			
			
			// if (query == null || query.trim().isEmpty()) {
			// 	response.getWriter().write(jsonArray.toString());
			// 	return;
			// }	
			
			
			// for (Integer id : superHeroMap.keySet()) {
			// 	String heroName = superHeroMap.get(id);
			// 	if (heroName.toLowerCase().contains(query.toLowerCase())) {
			// 		jsonArray.add(generateJsonObject(id, heroName));
			// 	}
			// }
			// response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", e.getMessage());
            out.write(jsonObject.toString());
            response.setStatus(500);
        } finally {
            out.close();
        }
	}
	
	/*
	 * Generate the JSON Object from hero to be like this format:
	 * {
	 *   "value": "Iron Man",
	 *   "data": { "heroID": 11 }
	 * }
	 * 
	 */
	private static JsonObject generateJsonObject(Integer heroID, String heroName) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("value", heroName);
		
		JsonObject additionalDataJsonObject = new JsonObject();
		additionalDataJsonObject.addProperty("heroID", heroID);
		
		jsonObject.add("data", additionalDataJsonObject);
		return jsonObject;
	}


}
