import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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
import java.util.stream.Collectors;

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
        String fulltitle = request.getParameter("fulltitle");

        System.out.println("Received title: " + title); 
        System.out.println("Received year: " + year);
        System.out.println("Received director: " + director); 
        System.out.println("Received star: " + star);
        System.out.println("Received genre: " + genre); 
        System.out.println("Received page: " + page);
        System.out.println("Received sort_by: " + sort_by); 
        System.out.println("Received movies_per_page: " + movies_per_page);// Print the genre string to the console
        System.out.println("Received fulltitle: " + fulltitle);
        
        String query;
        int parameterIndex=1;
        String[] keywords;
        try  {
            Connection conn = dataSource.getConnection();
            System.out.println("DB connected"); 
            //Statement statement = conn.createStatement();

            PreparedStatement statement = null;

            List<String> wordsList = new ArrayList<>();
            

            if(genre!= null && !genre.equals(""))
            {
                System.out.println("In genre query"); 
                query = "SELECT " +
                            "m.id, " +
                            "m.title, " +
                            "m.year, " +
                            "m.director, " +
                             "( " +
                            "    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) " +
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
                            "    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC) " +
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
                            "genres g ON gm.genreId = g.id " +
                            "GROUP BY " +
                            "m.id " +
                            "HAVING " +
                            "FIND_IN_SET((SELECT g.name FROM genres g WHERE g.name = ?), genres) > 0 ";

                // statement = conn.prepareStatement(query);
                // statement.setString(1, genre);
                // parameterIndex = 2;
   
            }
            else if (fulltitle!= null && !fulltitle.equals(""))
            {
                //String search = "good u sp"; // Example search string
                keywords = fulltitle.split("\\s+");

                // Build the WHERE clause dynamically
                String whereClause = Arrays.stream(keywords)
                        .map(keyword -> " (m.title LIKE ? OR m.title LIKE ?) ")
                        .collect(Collectors.joining(" AND "));

                // Print the WHERE clause to see its structure
                System.out.println("WHERE Clause: " + whereClause);

                // Construct the SQL query
                query = "SELECT " +
                        "m.id, " +
                        "m.title, " +
                        "m.year, " +
                        "m.director, " +
                        "( " +
                        "    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) " +
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
                        "    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC) " +
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
                        "ROUND(AVG(r.rating), 1) AS rating " +
                        "FROM " +
                        "movies m " +
                        "LEFT JOIN " +
                        "ratings r ON m.id = r.movieId " +
                        "WHERE " + whereClause + " " +
                        "GROUP BY " +
                        "m.id ";
            }
            else if( (title!= null && !title.equals("")) && (genre== null || genre.equals("")) && (year== null || year.equals("")) && (director== null || director.equals("")) && (star== null || star.equals("")))
            {
                if(title.equals("*"))  title = "_";

                System.out.println("In title query"); 

                query="SELECT " +
                "m.id, " +
                "m.title, " +
                "m.year, " +
                "m.director, " +
                "( " +
                            "    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) " +
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
                            "    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC) " +
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
                "m.title LIKE ? " +  // Modify this line to match titles starting with 'A'
                "GROUP BY " +
                "m.id ";

                // statement = conn.prepareStatement(query);
                // statement.setString(1, "%" + title + "%");
                // parameterIndex = 2;

            }
            else
            {           
                System.out.println("In search query");  
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("SELECT ")
                    .append("m.id, ")
                    .append("m.title, ")
                    .append("m.year, ")
                    .append("m.director, ")
                    .append("( ")
                    .append("    SELECT GROUP_CONCAT(g.name ORDER BY g.name ASC) ")
                    .append("    FROM ( ")
                    .append("        SELECT g.name ")
                    .append("        FROM genres g ")
                    .append("        INNER JOIN genres_in_movies gm ON g.id = gm.genreId ")
                    .append("        WHERE gm.movieId = m.id ")
                    .append("        ORDER BY g.name ASC ")
                    .append("        LIMIT 3 ")
                    .append("    ) g ")
                    .append(") AS genres, ")
                    .append("( ")
                    .append("    SELECT GROUP_CONCAT(star_info.name ORDER BY star_info.total_movies DESC, star_info.name ASC) ")
                    .append("    FROM ( ")
                    .append("        SELECT s.id, s.name, COUNT(sm.movieId) AS total_movies ")
                    .append("        FROM stars s ")
                    .append("        INNER JOIN stars_in_movies sm ON s.id = sm.starId ")
                    .append("        GROUP BY s.id ")
                    .append("        ORDER BY total_movies DESC, s.name ASC ")
                    .append("    ) AS star_info ")
                    .append("    INNER JOIN stars_in_movies sm ON star_info.id = sm.starId ")
                    .append("    WHERE sm.movieId = m.id ")
                    .append("    LIMIT 3 ")
                    .append(") AS stars, ")
                    .append("IFNULL(AVG(r.rating), 'N/A') AS rating ")
                    .append("FROM ")
                    .append("movies m ")
                    .append("LEFT JOIN ")
                    .append("genres_in_movies gm ON m.id = gm.movieId ")
                    .append("LEFT JOIN ")
                    .append("genres g ON gm.genreId = g.id ")
                    .append("LEFT JOIN ")
                    .append("stars_in_movies sm ON m.id = sm.movieId ")
                    .append("LEFT JOIN ")
                    .append("stars s ON sm.starId = s.id ")
                    .append("LEFT JOIN ")
                    .append("ratings r ON m.id = r.movieId ")
                    .append("WHERE ");


                // if(title!= null && !title.equals("")) query +="(m.title LIKE '%" + title + "%') AND ";
                
                // if(year!= null && !year.equals("")) query +="(m.year = " + year + ") AND ";
                
                // if(director!= null && !director.equals("")) query +="(m.director LIKE '%" + director + "%') AND ";
                
                // if(star!= null && !star.equals("")) query +="(s.name LIKE '%" + star + "%') AND ";

                List<String> conditions = new ArrayList<>();

                if (title != null && !title.equals("")) conditions.add("m.title LIKE ?");
                if (year != null && !year.equals("")) conditions.add("m.year = ?");
                if (director != null && !director.equals("")) conditions.add("m.director LIKE ?");
                if (star != null && !star.equals("")) conditions.add("s.name LIKE ?");

                if (!conditions.isEmpty()) {
                    queryBuilder.append(String.join(" AND ", conditions));
                } else {
                    queryBuilder.append("1=1");
                }

        
                //query += "(1=1) ";

                //query +="GROUP BY m.id ";

                queryBuilder.append(" GROUP BY m.id ");
                query = queryBuilder.toString();

                // statement = conn.prepareStatement(query);

                // parameterIndex = 1;
                // if (title != null && !title.equals("")) statement.setString(parameterIndex++, "%" + title + "%");
                // if (year != null && !year.equals("")) statement.setString(parameterIndex++, year);
                // if (director != null && !director.equals("")) statement.setString(parameterIndex++, "%" + director + "%");
                // if (star != null && !star.equals("")) statement.setString(parameterIndex++, "%" + star + "%");
        
                        
                        
                
   
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
             
            //if(movies_per_page!=null) query+= "LIMIT "+movies_per_page+" ";

            if (movies_per_page != null) query += "LIMIT ? ";

            //statement.setInt(parameterIndex++, Integer.parseInt(movies_per_page));

            
            int offs=0;
            if (page != null) {
            int offset = Integer.parseInt(page);
            int ps = Integer.parseInt(movies_per_page);
            offs = offset * ps - ps;
            query+= "OFFSET ? ";
        
            }

            statement = conn.prepareStatement(query);
            if(genre!= null && !genre.equals("")){
                statement.setString(parameterIndex++, genre);
            }
            else if (fulltitle!= null && !fulltitle.equals(""))
            {
                keywords = fulltitle.split("\\s+");
                for (String keyword : keywords) {
                statement.setString(parameterIndex++, "% " + keyword + "%");
                statement.setString(parameterIndex++, keyword + "%");
                }
            }
            else if( (title!= null && !title.equals("")) && (genre== null || genre.equals("")) && (year== null || year.equals("")) && (director== null || director.equals("")) && (star== null || star.equals(""))){
                statement.setString(parameterIndex++, "%" + title + "%");
            }
            else{
                if (title != null && !title.equals("")) statement.setString(parameterIndex++, "%" + title + "%");
                if (year != null && !year.equals("")) statement.setString(parameterIndex++, year);
                if (director != null && !director.equals("")) statement.setString(parameterIndex++, "%" + director + "%");
                if (star != null && !star.equals("")) statement.setString(parameterIndex++, "%" + star + "%");
            }

            if (movies_per_page != null) statement.setInt(parameterIndex++, Integer.parseInt(movies_per_page));

            if (page != null) statement.setInt(parameterIndex++, offs);








            System.out.println("Final query:" + statement.toString()); 
            
            System.out.println("Executing query");          
            ResultSet rs = statement.executeQuery();
            System.out.println("Query executed"); 
            

            JsonArray jsonArray = new JsonArray();
            while (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("title", rs.getString("title"));
                jsonObject.addProperty("year", rs.getString("year"));
                jsonObject.addProperty("director", rs.getString("director"));
                jsonObject.addProperty("genres", rs.getString("genres"));

                String str = rs.getString("stars");
                //System.out.println("starss = " + str); 
                int count = 0;
                int index = -1;
                
                for (int i = 0; i < str.length(); i++) 
                {
                    //System.out.println("charat" + str.charAt(i)); 
                    if (str.charAt(i) == ',') {
                        //System.out.println("charat"+i); 
                        count++;
                        if (count == 3) {
                            index = i;
                            break;
                        }
                    }
                }
            

                //System.out.println("index"+index); 
            
                if(index==-1) jsonObject.addProperty("stars", rs.getString("stars"));
                else jsonObject.addProperty("stars", rs.getString("stars").substring(0,index));

                
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