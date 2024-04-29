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

        request.getServletContext().log("In movie servlet");
        //request.getServletContext().log(request.getRequestURI());

        String title = request.getParameter("title");
        String year = request.getParameter("year");
        String director = request.getParameter("director");
        String star = request.getParameter("star");
        String genre = request.getParameter("genre");
        String sort_by = request.getParameter("sort_by");
        String movies_per_page = request.getParameter("movies_per_page");
        String page = request.getParameter("page");

        System.out.println("Received title: " + title); 
        System.out.println("Received year: " + year);
        System.out.println("Received director: " + director); 
        System.out.println("Received star: " + star);
        System.out.println("Received genre: " + genre); 
        System.out.println("Received page: " + page);
        System.out.println("Received sort_by: " + sort_by); 
        System.out.println("Received movies_per_page: " + movies_per_page);// Print the genre string to the console

        
        String query;
        try  {
            Connection conn = dataSource.getConnection();
            System.out.println("DB connected"); 
            Statement statement = conn.createStatement();

            if(genre!= null && !genre.equals(""))
            {
                System.out.println("In genre query"); 
                query = "SELECT " +
                            "m.id, " +
                            "m.title, " +
                            "m.year, " +
                            "m.director, " +
                            "( "+
                            "SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) "+
                            "FROM ( " +
                            "SELECT g.name "+
                            "FROM genres g " +
                            "INNER JOIN genres_in_movies gm ON g.id = gm.genreId "+
                            "WHERE gm.movieId = m.id "+
                            "ORDER BY g.name ASC "+
                            "LIMIT 3 "+
                            ") g " +
                            ") AS genres,"+
                            "( " +
                            "    SELECT GROUP_CONCAT(s.name ORDER BY total_movies DESC, s.name ASC)  " +
                            "    FROM ( " +
                            "        SELECT s.name, COUNT(sm.movieId) AS total_movies " +
                            "        FROM stars s " +
                            "         INNER JOIN stars_in_movies sm ON s.id = sm.starId " +
                            "         WHERE sm.movieId = m.id " +
                            "          GROUP BY s.id "+
                            "        ORDER BY total_movies DESC, s.name ASC " +
                            "        LIMIT 3 " +
                            "    ) s " +
                            ") AS stars, " +
                            "ROUND(AVG(r.rating), 1) AS rating " +  // Round the average rating to 1 decimal place
                            "FROM " +
                            "movies m " +
                            "LEFT JOIN " +
                            "ratings r ON m.id = r.movieId " +
                            "LEFT JOIN " +
                            "genres_in_movies gm ON m.id = gm.movieId " +
                            "LEFT JOIN " +
                            "genres g ON gm.genreId = g.id " +
                            "GROUP BY " +
                            "m.id " +
                            "HAVING " +
                            "FIND_IN_SET((SELECT g.name FROM genres g WHERE g.name = '"+genre+"'), genres) > 0 ";
   
            }
            else if( (title!= null && !title.equals("")) && (genre== null || genre.equals("")) && (year== null || year.equals("")) && (director== null || director.equals("")) && (star== null || star.equals("")))
            {
                if(title.equals("*"))  title = "";

                System.out.println("In title query"); 

                query="SELECT " +
                "m.id, " +
                "m.title, " +
                "m.year, " +
                "m.director, " +
                "( "+
                            "SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) "+
                            "FROM ( " +
                            "SELECT g.name "+
                            "FROM genres g " +
                            "INNER JOIN genres_in_movies gm ON g.id = gm.genreId "+
                            "WHERE gm.movieId = m.id "+
                            "ORDER BY g.name ASC "+
                            "LIMIT 3 "+
                            ") g " +
                            ") AS genres,"+
                            "( " +
                            "    SELECT GROUP_CONCAT(s.name) "+ // ORDER BY total_movies DESC, s.name ASC)  " +
                            "    FROM ( " +
                            "        SELECT s.name, COUNT(sm.movieId) AS total_movies " +
                            "        FROM stars s " +
                            "         INNER JOIN stars_in_movies sm ON s.id = sm.starId " +
                            "         WHERE sm.movieId = m.id " +
                            "          GROUP BY s.id "+
                            "        ORDER BY total_movies DESC, s.name ASC " +
                            "        LIMIT 3 " +
                            "    ) s " +
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
                "m.title LIKE '%" + title + "%' " +  // Modify this line to match titles starting with 'A'
                "GROUP BY " +
                "m.id ";
            }
            else
            {           
                System.out.println("In search query");  
                query = "SELECT " +
                        "m.id, " +
                        "m.title, " +
                        "m.year, " +
                        "m.director, " +
                        "( "+
                            "SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) "+
                            "FROM ( " +
                            "SELECT g.name "+
                            "FROM genres g " +
                            "INNER JOIN genres_in_movies gm ON g.id = gm.genreId "+
                            "WHERE gm.movieId = m.id "+
                            "ORDER BY g.name ASC "+
                            "LIMIT 3 "+
                            ") g " +
                            ") AS genres,"+
                            "( " +
                            "    SELECT GROUP_CONCAT(s.name ORDER BY total_movies DESC, s.name ASC)  " +
                            "    FROM ( " +
                            "        SELECT s.name, COUNT(sm.movieId) AS total_movies " +
                            "        FROM stars s " +
                            "         INNER JOIN stars_in_movies sm ON s.id = sm.starId " +
                            "         WHERE sm.movieId = m.id " +
                            "          GROUP BY s.id "+
                            "        ORDER BY total_movies DESC, s.name ASC " +
                            "        LIMIT 3 " +
                            "    ) s " +
                            ") AS stars, " +
                        "IFNULL(AVG(r.rating), 'N/A') AS rating " +
                        "FROM " +
                        "movies m " +
                        "LEFT JOIN " +
                        "genres_in_movies gm ON m.id = gm.movieId " +
                        "LEFT JOIN " +
                        "genres g ON gm.genreId = g.id " +
                        "LEFT JOIN " +
                        "stars_in_movies sm ON m.id = sm.movieId " +
                        "LEFT JOIN " +
                        "stars s ON sm.starId = s.id " +
                        "LEFT JOIN " +
                        "ratings r ON m.id = r.movieId " +
                        "WHERE ";

                if(title!= null && !title.equals("")) query +="(m.title LIKE '%" + title + "%') AND ";
                
                if(year!= null && !year.equals("")) query +="(m.year = " + year + ") AND ";
                
                if(director!= null && !director.equals("")) query +="(m.director LIKE '%" + director + "%') AND ";
                
                if(star!= null && !star.equals("")) query +="(s.name LIKE '%" + star + "%') AND ";
                

                query += "(1=1) ";


                query +="GROUP BY m.id ";
                        
                        
                
   
            } 
            
            if(sort_by!=null)
            {
                if(sort_by.equals("title_asc,rating_asc")) query+= "ORDER BY m.title ASC, rating ASC ";
                if(sort_by.equals("title_asc,rating_desc")) query+= "ORDER BY m.title ASC, rating DESC ";
                if(sort_by.equals("title_desc,rating_asc")) query+= "ORDER BY m.title DESC, rating ASC ";
                if(sort_by.equals("title_desc,rating_desc")) query+= "ORDER BY m.title DESC, rating DESC ";
                if(sort_by.equals("rating_asc,title_asc")) query+= "ORDER BY rating ASC, m.title ASC ";
                if(sort_by.equals("rating_asc,title_desc")) query+= "ORDER BY rating ASC, m.title DESC ";
                if(sort_by.equals("rating_desc,title_asc")) query+= "ORDER BY rating DESC, m.title ASC ";
                if(sort_by.equals("rating_desc,title_desc")) query+= "ORDER BY rating DESC, m.title DESC ";
            }else query+= "ORDER BY m.title ASC ";
             
            if(movies_per_page!=null) query+= "LIMIT "+movies_per_page+" ";
            
            if(page != null)
            {
                int offset = Integer.parseInt(page);
                int ps = Integer.parseInt(movies_per_page);
                int offs = offset*ps -ps;
                String off = Integer.toString(offs);
                query+= "OFFSET "+off+" ";
                
            } 

            System.out.println("Final query:" + query); 
            
            System.out.println("Executing query");          
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Query executed"); 
            

            JsonArray jsonArray = new JsonArray();
            while (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("title", rs.getString("title"));
                jsonObject.addProperty("year", rs.getString("year"));
                jsonObject.addProperty("director", rs.getString("director"));
                jsonObject.addProperty("genres", rs.getString("genres"));
                jsonObject.addProperty("stars", rs.getString("stars"));
                jsonObject.addProperty("rating", rs.getString("rating"));

                jsonArray.add(jsonObject);
            }
            System.out.println("Heree------");
            rs.close();
            statement.close();

            request.getServletContext().log(jsonArray.toString());
            

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