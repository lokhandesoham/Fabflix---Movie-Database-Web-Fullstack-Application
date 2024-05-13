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
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;



public class ParserEdit {

    public static String generateNextId(String currentMaxId) 
    {
        int numericPart = Integer.parseInt(currentMaxId.substring(2)) + 1;
        String formattedNumericPart = String.format("%07d", numericPart);
        return "nm" + formattedNumericPart;
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


            String id = "";
            Statement stmt = conn.createStatement();
            
            String query = "SELECT IFNULL(CONCAT('nm', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'nm0000001') AS new_id FROM stars";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("new_id");
            }
            

            System.out.println("Id star - > " + id);
            

            String sql = "INSERT INTO stars (id, name, birthYear) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            for (Star star : spe.getStars()) 
            {
                preparedStatement.setString(1, id); // Generate unique ID
                preparedStatement.setString(2, star.getName());
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


        // preparedStatement.setString(1, mid); // Generate unique ID
        // preparedStatement.setString(2, "soham");
        // preparedStatement.setInt(3, 2003);
        // preparedStatement.setString(4, "lokhande");
        // preparedStatement.setString(5, "smart");
        // preparedStatement.setInt(6, gid);
        // ResultSet rrs = preparedStatement.executeQuery();

        // if (rrs.next()) {
        //     System.out.println(rrs.getString("message"));
        // }

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



        // System.out.println("HashMap using loop size:"+ fid_to_id.size());
        // for (Map.Entry<String, String> entry : fid_to_id.entrySet()) {
        //     System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        // }


        String sid = "";
            stmt = conn.createStatement();
            
            query = "SELECT IFNULL(CONCAT('nm', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'nm0000001') AS new_id FROM stars";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                sid = rs.getString("new_id");
            }

        System.out.println("Id starinmovie - > " + sid);

        sql = "CALL add_XMLcast(?, ?, ?)";
        preparedStatement = conn.prepareCall(sql);

        for (StarInMovie star : cx.getStars()) 
            {
                preparedStatement.setString(1, fid_to_id.get(star.getFid())); // Generate unique ID
                preparedStatement.setString(2, star.getName());
                preparedStatement.setString(3, sid);
                

                preparedStatement.addBatch();
                
                sid =generateNextId(sid);
                
            
            }
        result =preparedStatement.executeBatch();
        System.out.println("Result = "+(result.length == cx.getStars().size()));








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
