Video url:- https://youtu.be/N4PuicF4jGY

Contributions-
Soham Ravindra Lokhande(46816606) –  Worked on Login page and set up the Filter Servelt and login redirection. Implemented the Main browsing page and on the html formatting. Worked on the Shopping cart page and the Remove movie button in shopping cart. Made Post request for the credit card information and made the sql query for it and sent the query to database..

Swami Sivananda Nanendla(62389275) – Worked on the Movies Page and formulated all the queries required to extract the desired search result. Worked on Single movie and star page and made queries to order them as required. Worked on the Sort by and Pagination and Prev-next button. 
Recorded the video. 


The LIKE statement is used in the WHERE clause of the SQL query to filter movie titles based on a substring represented by the title variable. It's employed with wildcard characters % before and after the title variable, allowing for matches anywhere within the movie titles.
In the search query we have used the like query for instance when user gives only part of the word which is not complete. We can see the example below
•	ABC%': All strings that start with 'ABC'. E.g. 'ABCD' and 'ABCABC'.
•	'%XYZ': All strings that end with 'XYZ'. E.g. 'WXYZ' and 'ZZXYZ'.

Below is one of the  query we have used using “”like””. Let’s say the user only searches partially with the title , director. (in MoviesServlet.java)
  if(title!= null && !title.equals("")) query +="(m.title LIKE '%" + title + "%') AND ";
                
                if(year!= null && !year.equals("")) query +="(m.year = " + year + ") AND ";
                
                if(director!= null && !director.equals("")) query +="(m.director LIKE '%" + director + "%')

