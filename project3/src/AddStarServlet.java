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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jasypt.util.password.StrongPasswordEncryptor;

@WebServlet(name = "AddStarServlet", urlPatterns = "/addstar")
public class AddStarServlet extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    private static final long serialVersionUID = 1L;
    private DataSource dataSource;
    private static int num=100000000;


    public String getServletInfo() {
        return "Servlet connects to MySQL database and displays result of a SELECT";
    }

    private static String generateNewId(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            String maxId = resultSet.getString("maxid");
            if (maxId != null && maxId.length() > 1) {
                String prefix = maxId.substring(0,2);
                String numericPart = maxId.substring(2);
                if (numericPart.matches("\\d+")) { // Check if numeric part
                    int numericValue = Integer.parseInt(numericPart);
                    numericValue++;
                    String newNumericPart = String.valueOf(numericValue);
                    while (newNumericPart.length() < numericPart.length()) {
                        newNumericPart = "0" + newNumericPart; // Ensure same length
                    }
                    return prefix + newNumericPart;
                }
            }
        }
        return String.valueOf(num++);
        
    }



    public void init(ServletConfig config) {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/moviedb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("starName");
        String dob = request.getParameter("birthYear");

        

       
        System.out.println("star info=" + name+"  "+dob);

        
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String query;
        PreparedStatement statement;
        try{
            
            Connection connection = dataSource.getConnection();

           
			
            query = "select max(id) as maxid from stars";
            statement = connection.prepareStatement(query);
            ResultSet rrs = statement.executeQuery();

            String newId = generateNewId(rrs);
            System.out.println("new id=" + newId);

            
            if(dob==null || dob=="")
            {
                query = "INSERT INTO stars (id, name) VALUES(?, ?)";
            

                statement = connection.prepareStatement(query);
                statement.setString(1, newId);
                statement.setString(2, name);
            }
            else
            {   
                query = "INSERT INTO stars (id, name,birthYear) VALUES(?, ?, ?)";
            

                statement = connection.prepareStatement(query);
                statement.setString(1, newId);
                statement.setString(2, name);
                statement.setInt(3, Integer.parseInt(dob));
            }
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected <= 0) {
                System.out.println("Failed to add to sales");
            }
            

            System.out.println("added new start successfully" );

            JsonObject responseJsonObject = new JsonObject();
            responseJsonObject.addProperty("status", "success");
             responseJsonObject.addProperty("newid", newId);
            responseJsonObject.addProperty("message", "added new star");
            
            
            
                
            out.write(responseJsonObject.toString());
            response.setStatus(200);
            
            rrs.close();
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
