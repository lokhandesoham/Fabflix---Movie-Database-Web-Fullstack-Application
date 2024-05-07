import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    


    /**
     * handles POST requests to add and show the item list information
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String total = request.getParameter("total");

        String movieTitles = request.getParameter("movieTitles");
        String movieCounts = request.getParameter("movieCounts");

        System.out.println("F-"+firstName);
        System.out.println("L-"+lastName);
        System.out.println("CC-"+creditCardNumber);
        System.out.println("E-"+expirationDate);
        System.out.println("T-"+movieTitles);
        System.out.println("C-"+movieCounts);
        System.out.println("To-"+total);

        String[] m_titles = movieTitles.substring(1, movieTitles.length() - 1).split(",");
        ArrayList<String> movieList = new ArrayList<>();

        // Trim each element and add it to the ArrayList
        for (String movie : m_titles) {
            movieList.add(movie.trim().substring(1, movie.length() - 1));
        }

        // Print the ArrayList to verify
         for (String s : movieList) System.out.print("Movie-"+s);



        String[] m_count = movieCounts.substring(1, movieCounts.length() - 1).split(",");
        ArrayList<Integer> countList = new ArrayList<>();

        // Trim each element and add it to the ArrayList
        for (String c : m_count) {
    
            countList.add(Integer.parseInt(c.trim()));
        }
            
        for (int c : countList) System.out.println("Count-"+c);
        
        

    

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false); // Disable lenient mode to ensure strict parsing

        try {
            dateFormat.parse(expirationDate); // Attempt to parse the input date
             // If parsing succeeds, the format is valid
        } catch (ParseException e) {
            expirationDate = "1111/01/01"; // If parsing fails, the format is invalid
        }






        
        HttpSession session = request.getSession();

        String sessionId = session.getId();
        long lastAccessTime = session.getLastAccessedTime();
        User email = (User)request.getSession().getAttribute("user");
        String emailid = email.username;


        LocalDate currentDate = LocalDate.now();

        // Define the date format using DateTimeFormatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Format the current date using the defined format
        String date = currentDate.format(dateFormatter);

        // Print the formatted date
        System.out.println("Current Date in yyyy/MM/dd format: " + date);
  



        System.out.println("CUURNT TIME -"+date);
        System.out.println("email" + emailid);

        ArrayList<String> salesList = new ArrayList<>();
        String sale ="";
    
        
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
                    System.out.println("Insideii");
                    for (int i = 0; i < movieList.size(); i++) 
                    {
                        String movieId = "";
                        int custId = -1;
                        try
                        {
                            String q1 = "SELECT id FROM movies WHERE title = '"+movieList.get(i)+"' ";
                            ResultSet resultSet = statement.executeQuery(q1);
                            if (resultSet.next()) {
                                movieId = resultSet.getString("id");
                            }
                        } 
                        catch (SQLException e) {
                            System.out.println(e);
                        }

                        try
                        {
                            String q2 = "SELECT id FROM customers WHERE email = '"+emailid+"' ";
                            ResultSet resultSet = statement.executeQuery(q2);
                            if (resultSet.next()) {
                                custId = resultSet.getInt("id");
                            }
                        } 
                        catch (SQLException e) {
                            System.out.println(e);
                        }

                        System.out.println("mid- "+movieId+" cid- "+custId);

                        if(movieId!="" && custId!=-1)
                        {
                            try 
                            {   
                                String q3 = "INSERT INTO sales (customerId, movieId, saleDate, quantity) VALUES ( "+custId+" , '"+movieId+"' , '"+date+"' , "+countList.get(i)+" );";
                                int saleid=-1;
                                int rowsAffected = statement.executeUpdate(q3);
                                if (rowsAffected <= 0) {
                                    System.out.println("Failed to add to sales");
                                }
                                else
                                {
                                    
                                    String q4 = "SELECT id FROM sales WHERE customerId = "+custId+" AND movieId = '"+movieId+"' AND DATE_FORMAT(saleDate, '%Y/%m/%d') = '"+date+"' ";
                                    ResultSet resultSet = statement.executeQuery(q4);
                                    if (resultSet.next()) {
                                        saleid = resultSet.getInt("id");
                                    } 
                                }
                                
                                sale += "SaleID-"+saleid +",,,Movie-" +movieList.get(i)+",,,Quantity-"+countList.get(i)+",,,Price-"+countList.get(i)*10+"||";
                                salesList.add(sale);

                                
                            }
                            catch (Exception e) 
                            {
                                System.out.println("errorrr");
                                System.out.println("Database error: " + e.getMessage());
                                e.printStackTrace();
                            }


                        }
                        else System.out.println("Movieid, Custid"+movieId+" "+custId);

                        
                    }


                    System.out.println(sale);

                    // String salesListParam = "";
                    // for (String sale : salesList) {
                    //     salesListParam += "&salesList=" + URLEncoder.encode(sale, StandardCharsets.UTF_8);
                    // }

                    // String redirectUrl = "confirm.html?" + salesListParam.substring(1) + "&total=" + total;

                    // System.out.println(redirectUrl);
                    // httpResponse.sendRedirect("confirm.html");
                    // System.out.println("donzoo");
                
                    
        
                    // String encodedJson = URLEncoder.encode(salesList, "UTF-8");
                    // String redirectUrl = "confirm.html?salesList=" + encodedJson+"&total="+total;
                    // System.out.println("confirmpage-"+redirectUrl);
                    // response.sendRedirect(redirectUrl);

                    responseJsonObject.addProperty("status", "success");
                    responseJsonObject.addProperty("param", sale.substring(0, sale.length()-2));
                    responseJsonObject.addProperty("total", total);
                        // Log to localhost log
                    request.getServletContext().log("Credentials approved");
                    // sample error messages. in practice, it is not a good idea to tell user which one is incorrect/not exist.
                    
                    //responseJsonObject.addProperty("message", "Confirm Page");
                        
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
