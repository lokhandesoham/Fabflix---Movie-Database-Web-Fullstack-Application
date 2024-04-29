import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.ParseException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This IndexServlet is declared in the web annotation below,
 * which is mapped to the URL pattern /api/index.
 */
@WebServlet(name = "PaymentServlet", urlPatterns = "/process_order")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource;

    public void init(ServletConfig config) {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/moviedb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private String toJsonString(List<SaleData> salesList) {  
        
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (SaleData sale : salesList) {
            jsonBuilder.append("{")
                    .append("\"saleid\":").append(sale.saleId).append(",")
                    .append("\"title\":\"").append(sale.title).append("\",")
                    .append("\"quantity\":").append(sale.quantity).append(",")
                    .append("\"price\":").append(sale.price)
                    .append("},");
        }
        if (jsonBuilder.length() > 1) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove the last comma
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }


    /**
     * handles POST requests to add and show the item list information
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieCountMapString = request.getParameter("movieCountMapString");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String total = request.getParameter("total");

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(creditCardNumber);
        System.out.println(expirationDate);
        System.out.println(movieCountMapString);

        // if (expirationDateString == null || expirationDateString.isEmpty()) {
        //     // Handle the error or return an appropriate response
        //     response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expiration date is required");
        //     return;
        // }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false); // Disable lenient mode to ensure strict parsing

        try {
            dateFormat.parse(expirationDate); // Attempt to parse the input date
             // If parsing succeeds, the format is valid
        } catch (ParseException e) {
            expirationDate = "1111/01/01"; // If parsing fails, the format is invalid
        }


        // movieCountMapString = movieCountMapString.substring(1, movieCountMapString.length() - 1);

        // // Split the string by '],[' to get individual key-value pairs
        // String[] keyValuePairs = movieCountMapString.substring(movieCountMapString.indexOf("[\"") + 2, movieCountMapString.lastIndexOf("\",1]") + 5).split("\\],\\[");

        // System.out.println("keyValuePairs Map: " + Arrays.toString(keyValuePairs));

        // // Create a map to store the parsed key-value pairs
        // Map<String, Integer> movieCountMap = new HashMap<>();

        // // Iterate through each key-value pair
        // for (String pair : keyValuePairs) {
        //     // Split the pair by ',' to separate key and value
        //     String[] keyValue = pair.substring(1,-1).split(",");
        //     System.out.println("keyValuePairs Map: " + Arrays.toString(keyValuePairs));
        //     if (keyValue.length == 2) {
        //         // Trim leading and trailing double quotes from key and parse the value as an integer
        //         String key = keyValue[0].replace("\"", "").trim();
        //         int value = Integer.parseInt(keyValue[1].trim());
        //         // Add the key-value pair to the map
        //         movieCountMap.put(key, value);
        //     }
        // }

        // // Print the parsed map for verification
        // System.out.println("Parsed Map: " + movieCountMap);
     
     





        //List<String> keysList = new ArrayList<>(movieCountMap.keySet());




        HttpSession session = request.getSession();

        
        String sessionId = session.getId();
        long lastAccessTime = session.getLastAccessedTime();

        // String email = (String) request.getSession().getAttribute("user");
        // System.out.println("email" + email);

        //List<SaleData> salesList = new ArrayList<>();
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JsonObject responseJsonObject = new JsonObject();

        if(firstName==null) firstName=""; 
        if(lastName==null) lastName=""; 
        if(creditCardNumber==null) creditCardNumber=""; 
        if(expirationDate==null) expirationDate=""; 
        
        
        try  
        {
                Connection conn = dataSource.getConnection();
                System.out.println("DB connected"); 
                Statement statement = conn.createStatement();

                String query = "SELECT * FROM creditcards WHERE firstName = '" +firstName+"' AND lastName = '"+lastName+"' AND id = '"+creditCardNumber+"' AND expiration = '"+expirationDate+"' ";
                

                ResultSet rs = statement.executeQuery(query);

                

                if(rs.next())
                {
            
                //     for (String movieTitle : keysList) 
                //     {
                //         int movieId = -1;
                //         int custId = -1;
                //         try
                //         {
                //             String q1 = "SELECT id FROM movies WHERE title = '"+movieTitle+"' ";
                //             ResultSet resultSet = statement.executeQuery(q1);
                //             if (resultSet.next()) {
                //                 movieId = resultSet.getInt("id");
                //             }
                //         } 
                //         catch (SQLException e) {
                //             System.out.println(e);
                //         }

                //         try
                //         {
                //             String q2 = "SELECT id FROM customers WHERE email = '"+email+"' ";
                //             ResultSet resultSet = statement.executeQuery(q2);
                //             if (resultSet.next()) {
                //                 custId = resultSet.getInt("id");
                //             }
                //         } 
                //         catch (SQLException e) {
                //             System.out.println(e);
                //         }


                //         if(movieId!=-1 && custId!=1)
                //         {
                //             try 
                //             {   for(int i = 0; i<movieCountMap.get(movieTitle); ++i)
                //                 {

                //                     String q3 = "INSERT INTO sales (customerId, movieId, saleDate) VALUES ( '"+custId+"' , '"+movieId+"' , '"+expirationDate+"' );";
                //                     int saleid=-1;
                //                     int rowsAffected = statement.executeUpdate(q3);
                //                     if (rowsAffected <= 0) {
                //                         System.out.println("Failed to add to sales");
                //                     }
                //                     else
                //                     {
                                        
                //                         String q4 = "SELECT id FROM sales WHERE customerId = '"+custId+"' AND movieId = '"+movieId+"' saleDate = '"+expirationDate+"' ";
                //                         ResultSet resultSet = statement.executeQuery(q4);
                //                         if (resultSet.next()) {
                //                             saleid = resultSet.getInt("id");
                //                         } 
                //                     }
                                    
                //                     SaleData data = new SaleData(saleid, movieTitle, 1, 10);
                //                     salesList.add(data);

                //                 }
                //             }
                //             catch (Exception e) 
                //             {
                //                 JsonObject jsonObject = new JsonObject();
                //                 jsonObject.addProperty("errorMessage", e.getMessage());
                //                 out.write(jsonObject.toString());
                //                 response.setStatus(500);
                //             }


                //         }
                //         else System.out.println("Movieid, Custid"+movieId+" "+custId);

                        
                //    }

                    
                //    String salesJson = toJsonString(salesList);
                //    String encodedJson = URLEncoder.encode(salesJson, "UTF-8");
                //    String redirectUrl = "confirm.html?salesList=" + encodedJson+"&total="+total;
                //    System.out.println("confirmpage-"+redirectUrl);
                //    response.sendRedirect(redirectUrl);

                responseJsonObject.addProperty("status", "success");
                    // Log to localhost log
                request.getServletContext().log("Credentials approved");
                // sample error messages. in practice, it is not a good idea to tell user which one is incorrect/not exist.
                
                responseJsonObject.addProperty("message", "correct card details");
                    
                }
                else
                {
                    responseJsonObject.addProperty("status", "fail");
                    // Log to localhost log
                    request.getServletContext().log("Credentials approved");
                    // sample error messages. in practice, it is not a good idea to tell user which one is incorrect/not exist.
                    
                    responseJsonObject.addProperty("message", "incorrect card details");
                }


                out.write(responseJsonObject.toString());
                response.setStatus(200);
                
                rs.close();
                //resultSet.close();
                statement.close();
                conn.close();

                
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
