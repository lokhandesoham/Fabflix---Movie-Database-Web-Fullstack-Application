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
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet(name = "AutocompleteServlet", urlPatterns = "/hero-suggestion")
public class AutocompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource;


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

		try {

            Connection conn = dataSource.getConnection();
            System.out.println("DB connected"); 
            //Statement statement = conn.createStatement();

            PreparedStatement statement = null;

            //String search = "good u sp"; // Example search string
            String[] keywords = search.split("\\s+");

            // Build the WHERE clause dynamically
            String whereClause = Arrays.stream(keywords)
                    .map(keyword -> " (m.title LIKE ? OR m.title LIKE ?) ")
                    .collect(Collectors.joining(" AND "));

            // Construct the SQL query
            String query = "SELECT " +
                    "m.title " +
                    "FROM " +
                    "movies m " +
                    "LEFT JOIN " +
                    "ratings r ON m.id = r.movieId " +
                    "WHERE " + whereClause + " " +
                    "GROUP BY " +
                    "m.id " +
                    "ORDER BY " +
                    "m.title ASC " +
                    "LIMIT 10 OFFSET 0";

            statement = conn.prepareStatement(query);

            int paramIndex = 1;
            for (String keyword : keywords) {
                statement.setString(paramIndex++, "% " + keyword + "%");
                statement.setString(paramIndex++, keyword + "%");
            }
            System.out.println("Executing query: " + statement.toString());

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
