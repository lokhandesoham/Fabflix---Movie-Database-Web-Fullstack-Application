import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;

/**
 * This IndexServlet is declared in the web annotation below,
 * which is mapped to the URL pattern /api/index.
 */
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    /**
     * handles GET requests to store session information
     */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        long lastAccessTime = session.getLastAccessedTime();

        JsonObject responseJsonObject = new JsonObject();
        responseJsonObject.addProperty("sessionID", sessionId);
        responseJsonObject.addProperty("lastAccessTime", new Date(lastAccessTime).toString());

        ArrayList<String> previous_movies = (ArrayList<String>) session.getAttribute("previous_movies");
        if (previous_movies == null) {
            previous_movies = new ArrayList<String>();
        }
        // Log to localhost log
        request.getServletContext().log("getting " + previous_movies.size() + " movies");
        JsonArray previous_moviesJsonArray = new JsonArray();
        previous_movies.forEach(previous_moviesJsonArray::add);
        responseJsonObject.add("previous_movies", previous_moviesJsonArray);

        // write all the data into the jsonObject
        response.getWriter().write(responseJsonObject.toString());
    }

    /**
     * handles POST requests to add and show the item list information
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String remove = request.getParameter("remove");
        String quantityChange = request.getParameter("quantityChange");
        System.out.println(title);
        System.out.println(remove);
        System.out.println(quantityChange);

        HttpSession session = request.getSession();

        ArrayList<String> previous_movies = (ArrayList<String>) session.getAttribute("previous_movies");
        
        if(remove!=null && remove.equals("yes"))
        {
            
            synchronized (previous_movies) {
                previous_movies.removeIf(str -> str.equals(title));
            }
        }
        else
        { 
            
            if (previous_movies == null) 
            {
                previous_movies = new ArrayList<String>();
                previous_movies.add(title);
                session.setAttribute("previous_movies", previous_movies);
            } 
            else 
            {
                if(quantityChange!=null)
                {
                    if(quantityChange.equals("1"))
                    {
                        synchronized (previous_movies) {
                            previous_movies.add(title);
                        }
                    }
                    else
                    {
                        synchronized (previous_movies) {
                            previous_movies.remove(previous_movies.indexOf(title));
                        }
                    }
                }
                else
                {   
                synchronized (previous_movies) {
                    previous_movies.add(title);
                }
                }
            }
        }

        JsonObject responseJsonObject = new JsonObject();

        JsonArray previous_moviesJsonArray = new JsonArray();
        previous_movies.forEach(previous_moviesJsonArray::add);
        responseJsonObject.add("previous_movies", previous_moviesJsonArray);

        response.getWriter().write(responseJsonObject.toString());
    }
}
