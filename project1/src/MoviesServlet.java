import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

@WebServlet(name = "MoviesServlet", urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {
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

        try (Connection conn = dataSource.getConnection()) {
            Statement statement = conn.createStatement();
            String query = "SELECT m.title, m.year, m.director, " +
                            "GROUP_CONCAT(DISTINCT SUBSTRING_INDEX(gm.name, ',', 3) ORDER BY gm.name ASC SEPARATOR ', ') AS genres, " +
                            "GROUP_CONCAT(DISTINCT SUBSTRING_INDEX(sm.name, ',', 3) ORDER BY sm.name ASC SEPARATOR ', ') AS stars, " +
                            "r.rating AS rating " +
                            "FROM movies m " +
                            "JOIN ratings r ON m.id = r.movieId " +
                            "LEFT JOIN ( " +
                            "SELECT gm.movieId, GROUP_CONCAT(g.name ORDER BY g.id ASC SEPARATOR ', ') AS name " +
                            "FROM genres_in_movies gm " +
                            "JOIN genres g ON gm.genreId = g.id " +
                            "GROUP BY gm.movieId " +
                            ") gm ON m.id = gm.movieId " +
                            "LEFT JOIN ( " +
                            "SELECT sm.movieId, GROUP_CONCAT(s.name ORDER BY s.id ASC SEPARATOR ', ') AS name " +
                            "FROM stars_in_movies sm " +
                            "JOIN stars s ON sm.starId = s.id " +
                            "GROUP BY sm.movieId " +
                            ") sm ON m.id = sm.movieId " +
                            "GROUP BY m.id, m.title, m.year, m.director, r.rating " +
                            "ORDER BY r.rating DESC " +
                            "LIMIT 20";
                            
            ResultSet rs = statement.executeQuery(query);

            JsonArray jsonArray = new JsonArray();
            while (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("title", rs.getString("title"));
                jsonObject.addProperty("year", rs.getInt("year"));
                jsonObject.addProperty("director", rs.getString("director"));
                jsonObject.addProperty("genres", rs.getString("genres"));
                jsonObject.addProperty("stars", rs.getString("stars"));
                jsonObject.addProperty("rating", rs.getDouble("rating"));

                jsonArray.add(jsonObject);
            }
            rs.close();
            statement.close();

            System.out.println(jsonArray.toString());

            request.getServletContext().log("getting " + jsonArray.size() + " results");

            out.write(jsonArray.toString());
            response.setStatus(200);

        } catch (Exception e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", e.getMessage());
            out.write(jsonObject.toString());
            response.setStatus(500);
        } finally {
            out.close();
        }
    }
}

