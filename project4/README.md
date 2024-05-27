# General
    - #### Team#:
    
    - #### Names: Soham Ravindra Lokhande (46816606) and Swami Sivananda Nanendla (62389275)
    
    - #### Project 5 Video Demo Link:https://youtu.be/OCDXsLR7g28

    - #### Instruction of deployment:
    AWS load balancer can be directly accessed at - http://54.176.145.40/project4/

    Master Instance - Public - 13.57.203.17  Private- 172.31.11.15 Tomacat - http://13.57.203.17:8080/manager/html

    Slave Instance - Public - 54.193.4.214  Private- 172.31.14.0 Tomcat - http://54.193.4.214:8080/manager/html

    Once u click on AWS load balancer it automatically redirect traffic on port 80 to the above Master/Slave AWS instances

    - #### Collaborations and Work Distribution:

    Soham Ravindra Lokhande (46816606) Implemented the AJAX-based full-text search, caching suggestion lists for reuse. Enabled connection pooling for all servlets, improving performance and resource management. Completed the AJAX-based full-text search, caching suggestion lists for reuse. MySQL replication for the scaled version, correctly routed read/write queries to Master/Slave databases, and answered the related questions in the README.md. Worked on the Set up AWS instances for load balancing, ensuring accessibility via HTTP on port 8080 configured AWS  load balancers to redirect traffic appropriately and ensured that reCAPTCHA continued to work properly on the website.

    Swami Sivananda Nanendla (62389275) collaborated on implementing the full-text search functionality for movie titles, ensuring correct results are displayed for movie titles, and limiting the suggestion list to 10 items. Added a 300ms delay for Autocomplete and enabled it for input with at least 3 characters. Contributed to answering the questions in the README.md regarding connection pooling. completed the set up MySQL replication for the scaled version


- # Connection Pooling
    - #### Include the filename/path of all code/configuration files in GitHub of using JDBC Connection Pooling.
    AddMovieServlet.java - project3/src/AddMovieServlet.java
    AddStarServlet.java  - project3/src/AddStarServlet.java
    AutocompleteServlet.java - project3/src/AutocompleteServlet.java
    EmpLoginServlet.java - project3/src/EmpLoginServlet.java
    GenreList.java - project3/src/GenreList.java
    LoginServlet.java - project3/src/LoginServlet.java
    MetaDataServlet.java - project3/src/MetaDataServlet.java
    MoviesServlet.java - project3/src/MoviesServlet.java
    PaymentServlet.java - project3/src/PaymentServlet.java
    SingleMovieServlet.java - project3/src/SingleMovieServlet.java
    SingleStarServlet.java - project3/src/SingleStarServlet.java
    
    - #### Explain how Connection Pooling is utilized in the Fabflix code.
    In the Fabflix code provided, connection pooling is utilized through the DataSource object.The context.xml file defines  Resource elements, each configuring a DataSource for connection pooling. These configurations specify parameters such as the maximum number of active connections (maxTotal), the maximum number of idle connections (maxIdle), and the maximum time to wait for a connection (maxWaitMillis), among other settings. The init method initializes the DataSource by looking up the JNDI name java:comp/env/jdbc/moviedb. This JNDI name should match one of the resources defined in context.xml. 
    In the doPost and doGet methods, a connection is obtained from the pool using dataSource.getConnection(). This connection is used for the database operation and is automatically returned to the pool when it's closed or when the try-with-resources block is exited. When a request is made, a connection from this pool is borrowed, used for the transaction using prepared statements, and then returned to the pool. This avoids the overhead of establishing a new connection every time one is needed, as creating a connection is a relatively expensive operation.
    
    - #### Explain how Connection Pooling works with two backend SQL.
    With 2 backend sql, the context.xml file defines two Resource elements, each configuring a DataSource for connection pooling. One is for the slave database (jdbc/SlaveDB) which is connected to localhost database, and the other is for the master database (jdbc/MasterDB) which is connected to the master instance databse through internal IP. For read operations, the connection pool may provide a connection to either the master or the slave database, depending on the configuration and load balancing strategy hence it chooses the (jdbc/SlaveDB) datasource. For write operations, the connection pool should ensure that the connection provided is to the master database, as the slave is typically read-only in a master-slave setup hence it chooses the (jdbc/MasterDB) datasource.
    

- # Master/Slave
    - #### Include the filename/path of all code/configuration files in GitHub of routing queries to Master/Slave SQL.
    AddMovieServlet.java - project3/src/AddMovieServlet.java
    AddStarServlet.java  - project3/src/AddStarServlet.java
    AutocompleteServlet.java - project3/src/AutocompleteServlet.java
    EmpLoginServlet.java - project3/src/EmpLoginServlet.java
    GenreList.java - project3/src/GenreList.java
    LoginServlet.java - project3/src/LoginServlet.java
    MetaDataServlet.java - project3/src/MetaDataServlet.java
    MoviesServlet.java - project3/src/MoviesServlet.java
    PaymentServlet.java - project3/src/PaymentServlet.java
    SingleMovieServlet.java - project3/src/SingleMovieServlet.java
    SingleStarServlet.java - project3/src/SingleStarServlet.java

    - #### How read/write requests were routed to Master/Slave SQL?
    In these above Servlet whenever, there was a write operation was to be done into the database, the (jdbc/MasterDB) datasource will be used to make the SQL connecetion (which is connected to the master instance database through internal IP).In this way all the changes to the databse would be made to the master instance database first and from there it would be automatically replicated by the slave instance. This is not true vice versa hence we cannot make write opeartion in slave datasource first -which is connected to localhost database. Whenever, we want to just make a read operation on the databse, we used the (jdbc/SlaveDB) datasource. This does not affect the replication process between the master and slave instance.
    

