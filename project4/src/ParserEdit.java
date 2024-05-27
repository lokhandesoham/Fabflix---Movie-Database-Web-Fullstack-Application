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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.BatchUpdateException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import javax.naming.Context;
import java.util.List;



public class ParserEdit {

    public static String generateNextId(String currentMaxId) 
    {
        int numericPart = Integer.parseInt(currentMaxId.substring(2)) + 1;
        String formattedNumericPart = String.format("%07d", numericPart);
        return currentMaxId.substring(0,2) + formattedNumericPart;
    }

    public void dataload() {
        StarXml spe = new StarXml();
        spe.runExample();

        System.out.println("No of Stars '" + spe.getStars().size() + "'.");

        MainXml mx = new MainXml();
        mx.runExample();


        System.out.println("No of Movies '" + mx.getmyMovies().size() + "'.");

        CastXml cx = new CastXml();
        cx.runExample();
        
        System.out.println("No of cast '" + cx.getStars().size() + "'.");

        try 
        {
            String loginUser = "mytestuser";
            String loginPasswd = "My6$Password";
            String loginUrl = "jdbc:mysql://localhost:3306/moviedb";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(loginUrl, loginUser, loginPasswd);

            HashMap<String, String> fid_to_id  = new HashMap<String, String>();

            HashMap<String, String> starname_to_id  = new HashMap<String, String>();


            String id = "";
            Statement stmt = conn.createStatement();
            
            String query = "SELECT IFNULL(CONCAT('nm', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'nm0000001') AS new_id FROM stars";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("new_id");
            }
            

            System.out.println("Id star - > " + id);
            

            String sql = "INSERT INTO stars (id, name, birthYear) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            for (Star star : spe.getStars()) 
            {
                preparedStatement.setString(1, id); // Generate unique ID
                preparedStatement.setString(2, star.getName());
                starname_to_id.put(star.getName(),id);
                if (star.getBirthYear() == -1) {
                    preparedStatement.setNull(3, java.sql.Types.INTEGER);
                } else {
                    preparedStatement.setInt(3, star.getBirthYear());
                }
                preparedStatement.addBatch();
                id =generateNextId(id);
            
            }
        int[] result =preparedStatement.executeBatch();
        
        System.out.println("Result = "+(result.length == spe.getStars().size()));

    //     ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
    //     while (generatedKeys.next()) {
    // // Retrieve the generated key, which is the new ID for the inserted star
    //     String generatedId = generatedKeys.getString(1);



        String mid = "";
        query = "SELECT IFNULL(CONCAT('tt', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'tt0000000') AS movie_id FROM movies";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            mid = rs.getString("movie_id");
        }

        int gid=70;
        query = "SELECT MAX(id) + 1 AS genre_id FROM genres;";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            gid = Integer.parseInt(rs.getString("genre_id"));
        }


        System.out.println("Id movie  - > " + mid);
        System.out.println("Id genre  - > " + gid);

        

        sql = "CALL add_XMLmovie(?, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareCall(sql);

        
      

        for (Movies movie : mx.getmyMovies()) 
            {
                preparedStatement.setString(1, mid); // Generate unique ID
                preparedStatement.setString(2, movie.getTitle());
                preparedStatement.setInt(3, movie.getYear());
                preparedStatement.setString(4, movie.getDirector());

                if (movie.getGenre()=="") {
                    preparedStatement.setNull(5, java.sql.Types.VARCHAR);
                } else {
                    preparedStatement.setString(5, movie.getGenre());
                }
                if (movie.getGenre()=="") {
                    preparedStatement.setNull(6, java.sql.Types.INTEGER);
                } else {
                    preparedStatement.setInt(6, gid);
                    
                }

                preparedStatement.addBatch();
                fid_to_id.put(movie.getId(), mid);
                mid =generateNextId(mid);
                gid+=1;
            
            }
        result =preparedStatement.executeBatch();
        System.out.println("Result = "+(result.length == mx.getmyMovies().size()));



        System.out.println("HashMap using loop size:"+ fid_to_id.size());
        for (Map.Entry<String, String> entry : fid_to_id.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("HashMap using loop size:"+ starname_to_id.size());
        for (Map.Entry<String, String> entry : starname_to_id.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }



        String sid = "";
            stmt = conn.createStatement();
            
            query = "SELECT IFNULL(CONCAT('nm', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'nm0000001') AS new_id FROM stars";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                sid = rs.getString("new_id");
            }

        System.out.println("Id starinmovie - > " + sid);

        //sql= "INSERT INTO stars_in_movies (starId, movieId) VALUES (?, ?);";
        sql = "CALL add_XMLcast(?, ?)";
        preparedStatement = conn.prepareCall(sql);

        for (StarInMovie star : cx.getStars()) 
            {
                try{
                    if(starname_to_id.get(star.getName())!=null && fid_to_id.get(star.getFid()) != null)
                    {
                    System.out.println("starId - > " + starname_to_id.get(star.getName()));
                    System.out.println("movieId - > " + fid_to_id.get(star.getFid()));
                    preparedStatement.setString(1, starname_to_id.get(star.getName()));
                    preparedStatement.setString(2, fid_to_id.get(star.getFid())); // Generate unique ID
                
                

                    preparedStatement.addBatch();
                    }
                }
                catch (BatchUpdateException e) 
                {
                    // Handle batch update exception
                    // int[] updateCounts = e.getUpdateCounts();
                    // for (int i = 0; i < updateCounts.length; i++) {
                    //     if (updateCounts[i] == Statement.EXECUTE_FAILED) {
                    //         // Handle specific failed batch entry here (e.g., log the data causing the failure)
                    //         System.err.println("Batch entry " + i + " failed: " + e.getMessage());
                    //         // Optionally, skip this entry and continue with the next one
                    //     }
                    System.out.println("her in catch");
                    System.err.println("Batch update failed: " + e.getMessage());
                    e.printStackTrace(); // Print the stack trace for detailed error information
                }
                
                 


            }



        // sql = "CALL add_XMLcast(?, ?, ?)";
        // preparedStatement = conn.prepareCall(sql);

        // for (StarInMovie star : cx.getStars()) 
        //     {
        //         preparedStatement.setString(1, fid_to_id.get(star.getFid())); // Generate unique ID
        //         preparedStatement.setString(2, star.getName());
        //         preparedStatement.setString(3, sid);
                

        //         preparedStatement.addBatch();
                
        //         sid =generateNextId(sid);
                
            
        //     }
        result =preparedStatement.executeBatch();
        System.out.println("Result starss = "+result.length);








        preparedStatement.close();
        conn.close();


        } catch (Exception e) {
            System.out.println("Database error" + e);
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        // Create an instance of ParserEdit
        ParserEdit parserEdit = new ParserEdit();

        // Initialize the servlet config
        parserEdit.dataload();
    }
}
