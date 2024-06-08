import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;

@WebServlet(name = "AddMovieServlet", urlPatterns = "/addmovie")
public class AddMovieServlet extends HttpServlet {

    private DataSource dataSource;

    public void init() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/SlaveDB"); //  the slave resource
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        System.out.println("In addmovie servlet");

        String movieTitle = request.getParameter("movieTitle");
        int movieYear = Integer.parseInt(request.getParameter("movieYear"));
        String movieDirector = request.getParameter("movieDirector");
        String starName = request.getParameter("starName");
        int starBirthYear = Integer.parseInt(request.getParameter("birthYear"));
        String genreName = request.getParameter("genreName");

        System.out.println("movie info=" + movieTitle+"  "+movieYear+"  "+movieDirector+"  "+starName+"  "+starBirthYear+"  "+genreName);

        try (Connection connection = dataSource.getConnection()) {
            // Call the stored procedure add_movie
            String query = "CALL add_movie(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareCall(query)) {
                statement.setString(1, movieTitle);
                statement.setInt(2, movieYear);
                statement.setString(3, movieDirector);
                statement.setString(4, starName);
                statement.setInt(6, starBirthYear);
                statement.setString(5, genreName);

                ResultSet hasResults = statement.executeQuery();
                if (hasResults.next()) {
                    JsonObject responseJsonObject = new JsonObject();
                    responseJsonObject.addProperty("status", "success");
                    responseJsonObject.addProperty("message", hasResults.getString("message"));
                    out.write(responseJsonObject.toString());
                    response.setStatus(HttpServletResponse.SC_OK);
                } else {
                    out.println("Error executing stored procedure.");
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            }
        } catch (SQLException e) {
            JsonObject responseJsonObject = new JsonObject();
            responseJsonObject.addProperty("status", "error");
            responseJsonObject.addProperty("message", "Error adding movie: " + e.getMessage());
            out.write(responseJsonObject.toString());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.close();
        }
    }
}
