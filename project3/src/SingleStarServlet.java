import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
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

@WebServlet(name = "SingleStarServlet", urlPatterns = "/star")
public class SingleStarServlet extends HttpServlet {
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
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
       

        // Get the movie ID from the request parameter
        String starId = request.getParameter("id");
        if (starId == null || starId.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", "Movie ID parameter is missing.");
            out.write(jsonObject.toString());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        System.out.println(starId);

        try (Connection conn = dataSource.getConnection()) {
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwoooowowowowowowowowowo");
            Statement statement = conn.createStatement();
            String query = "SELECT " +
                            "s.name AS star_name, " +
                            "COALESCE(s.birthYear, 'N/A') AS birth_year, " +
                            "GROUP_CONCAT(DISTINCT m.title ORDER BY m.year DESC, m.title ASC SEPARATOR ', ') AS movies_acting " +
                            "FROM " +
                            "stars s " +
                            "LEFT JOIN " +
                            "stars_in_movies sim ON s.id = sim.starId " +
                            "LEFT JOIN " +
                            "movies m ON sim.movieId = m.id " +
                            "WHERE " +
                            "s.name = ? " +
                            "GROUP BY " +
                            "s.name, s.birthYear";

            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, starId);
            
            ResultSet rs = preparedStatement.executeQuery();

            JsonArray jsonArray = new JsonArray();
            while (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("star_name", rs.getString("star_name"));
                jsonObject.addProperty("birth_year", rs.getString("birth_year"));
                jsonObject.addProperty("movies_acting", rs.getString("movies_acting"));
                jsonArray.add(jsonObject);  
            }

            
            if (jsonArray.size() == 0) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errorMessage", "Star not found with name: " + starId);
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                jsonArray.add(jsonObject);  
            }
            rs.close();
            statement.close();

            System.out.println("Here-->");
            System.out.println(jsonArray.toString());

            out.write(jsonArray.toString());
            response.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", e.getMessage());
            out.write(jsonObject.toString());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.close();
        }
    }
}
