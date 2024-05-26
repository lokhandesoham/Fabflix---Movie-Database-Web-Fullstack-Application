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

@WebServlet(name = "SingleMovieServlet", urlPatterns = "/mov")
public class SingleMovieServlet extends HttpServlet {
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
        String movieId = request.getParameter("id");
        if (movieId == null || movieId.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", "Movie ID parameter is missing.");
            out.write(jsonObject.toString());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        System.out.println(movieId);

        try (Connection conn = dataSource.getConnection()) {
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwoooowowowowowowowowowo");
            Statement statement = conn.createStatement();
            // String query = "SELECT m.title, m.year, m.director, " +
            //         "GROUP_CONCAT(DISTINCT g.name ORDER BY g.name ASC SEPARATOR ', ') AS genres, " +
            //         "GROUP_CONCAT(DISTINCT s.name ORDER BY s.name ASC SEPARATOR ', ') AS stars, " +
            //         "r.rating AS rating " +
            //         "FROM movies m " +
            //         "JOIN ratings r ON m.id = r.movieId " +
            //         "LEFT JOIN genres_in_movies gm ON m.id = gm.movieId " +
            //         "LEFT JOIN genres g ON gm.genreId = g.id " +
            //         "LEFT JOIN stars_in_movies sm ON m.id = sm.movieId " +
            //         "LEFT JOIN stars s ON sm.starId = s.id " +
            //         "WHERE m.title = ? " +
            //         "GROUP BY m.id, m.title, m.year, m.director, r.rating";

            String query="SELECT " +
                "m.id, " +
                "m.title, " +
                "m.year, " +
                "m.director, " +
                "( " +
                            "    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC SEPARATOR ', ') " +
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
                            "    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC SEPARATOR ', ') " +
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
                "ROUND(AVG(r.rating), 1) AS rating " +  // Round the average rating to 1 decimal place
                "FROM " +
                "movies m " +
                "LEFT JOIN " +
                "ratings r ON m.id = r.movieId " +
                "LEFT JOIN " +
                "genres_in_movies gm ON m.id = gm.movieId " +
                "LEFT JOIN " +
                "genres g ON gm.genreId = g.id "+
                "WHERE " +
                "m.title = ? " +  // Modify this line to match titles starting with 'A'
                "GROUP BY " +
                "m.id, m.title, m.year, m.director, r.rating ";

            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, movieId);
            
            ResultSet rs = preparedStatement.executeQuery();

            JsonArray jsonArray = new JsonArray();
            if (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("title", rs.getString("title"));
                jsonObject.addProperty("year", rs.getInt("year"));
                jsonObject.addProperty("director", rs.getString("director"));
                jsonObject.addProperty("genres", rs.getString("genres"));
                System.out.println(rs.getString("stars"));
                jsonObject.addProperty("stars", rs.getString("stars"));
                jsonObject.addProperty("rating", rs.getDouble("rating"));
                jsonArray.add(jsonObject);  
            } else {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errorMessage", "Movie not found with ID: " + movieId);
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