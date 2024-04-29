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


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    private static final long serialVersionUID = 1L;
    private DataSource dataSource;

    public void init(ServletConfig config) {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/moviedb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try{
            
            Connection connection = dataSource.getConnection();
			
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM customers WHERE email = '"+email+"' AND password = '"+password+"' LIMIT 1"; 
            
            ResultSet rs = statement.executeQuery(query);
            
            
            JsonObject responseJsonObject = new JsonObject();
            
            if (rs.next())
            {

                request.getSession().setAttribute("user", new User(rs.getString("email")));

                //request.getSession().setMaxInactiveInterval(-1);
                request.getServletContext().log("Login success!");
                responseJsonObject.addProperty("status", "success");
                responseJsonObject.addProperty("message", "Successfully logged in");
            }
            else {
                // Login fail
                responseJsonObject.addProperty("status", "fail");
                // Log to localhost log
                request.getServletContext().log("Login failed");
                // sample error messages. in practice, it is not a good idea to tell user which one is incorrect/not exist.
                
                responseJsonObject.addProperty("message", "incorrect email or password");
                
            }
                
            out.write(responseJsonObject.toString());
            response.setStatus(200);
            
            rs.close();
            statement.close();
            connection.close();

        }
        catch (Exception e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errorMessage", e.getMessage());
            out.write(jsonObject.toString());
            response.setStatus(500);
        } finally {
            out.close();
        }



        

    }
}
