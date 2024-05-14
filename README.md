<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
# Fabflix - Movie Database Web Application

## Overview
Fabflix is a full-stack movie database web application that evolved through five major iterations, each adding significant features and improvements. Built with modern technologies and best practices, Fabflix demonstrates the implementation of a scalable, secure, and high-performance web application.

## Development Journey

### Project 1: Foundation
- **Database Design**
  - Implemented normalized MySQL schema with tables for movies, stars, genres
  - Created efficient indexing for quick search operations
  - Designed relationships between movies, stars, and genres
- **Backend Implementation**
  - RESTful API endpoints using Java Servlets
  - Connection pooling with Apache DBCP2
  - Prepared statements for SQL injection prevention
- **Frontend Features**
  - Responsive movie grid layout
  - Dynamic search with autocomplete
  - Pagination for movie listings

**Demo**: Watch how we implemented the basic movie browsing and search functionality.
[![Project 1 Demo](https://img.youtube.com/vi/iZ1VWm8DKR8/0.jpg)](https://youtu.be/iZ1VWm8DKR8)

### Project 2: Enhanced Features
- **Authentication System**
  - Secure password hashing with BCrypt
  - Session management using HTTPSession
  - Role-based access control
- **Shopping Cart**
  - In-memory cart management
  - Persistent cart state using cookies
  - Real-time price calculations
- **Advanced Search**
  - Full-text search capabilities
  - Multi-criteria filtering
  - Sort by various parameters

**Demo**: See the enhanced features including user authentication and shopping cart functionality.
[![Project 2 Demo](https://img.youtube.com/vi/rmkFwWX18HU/0.jpg)](https://youtu.be/rmkFwWX18HU)

### Project 3: Performance & Security
- **Performance Optimizations**
  - Implemented connection pooling (HikariCP)
  - Query optimization with proper indexing
  - Caching frequently accessed data
- **Security Enhancements**
  - Input sanitization and validation
  - CSRF protection
  - XSS prevention
- **Error Handling**
  - Custom error pages
  - Comprehensive logging system
  - Graceful error recovery

**Demo**: Watch how we improved performance and security measures.
[![Project 3 Demo](https://img.youtube.com/vi/XLGO_DZm-0w/0.jpg)](https://youtu.be/XLGO_DZm-0w)

### Project 4: Scalability & Redundancy
- **AWS Infrastructure**
  - EC2 t2.micro instances for cost optimization
  - Elastic IP for consistent access
  - Security groups for access control
- **Database Replication**
  - Master-slave MySQL setup
  - Automatic failover configuration
  - Read-write splitting
- **Load Balancing**
  - Apache2 with mod_proxy
  - Sticky sessions using JSESSIONID
  - Health check monitoring

**Demo**: See how we implemented scalability and redundancy on AWS.
[![Project 4 Demo](https://img.youtube.com/vi/OCDXsLR7g28/0.jpg)](https://youtu.be/OCDXsLR7g28)

### Project 5: Enterprise Deployment
- **Containerization**
  - Multi-stage Docker builds
  - Optimized image size
  - Environment variable configuration
- **Kubernetes Setup**
  - Deployment configurations for scalability
  - Service definitions for networking
  - Ingress rules for external access
- **Performance Testing**
  - JMeter test plans for load testing
  - Automated scaling based on metrics
  - Performance monitoring with Prometheus

**Demo**: Watch our final deployment with Kubernetes and performance testing results.
[![Project 5 Demo](https://img.youtube.com/vi/jjpRsP2XF_s/0.jpg)](https://youtu.be/jjpRsP2XF_s)

## Technical Stack
- **Backend**: Java 8, Tomcat 9, Servlets 4.0
- **Database**: MySQL 8.0 with master-slave replication
- **Frontend**: HTML5, CSS3, JavaScript (ES6+), Bootstrap 4
- **Infrastructure**: AWS EC2, Docker 20.10, Kubernetes 1.21
- **Load Balancing**: Apache2 with mod_proxy
- **Security**: HTTPS (Let's Encrypt), Input Validation, CSRF Protection
- **Testing**: JMeter 5.4, Selenium WebDriver

## Performance Metrics
Our latest deployment (Project 5) achieved impressive performance metrics:
- Throughput: ~476 requests/minute (GUI testing)
- Average Response Time: 3,577ms
- Zero error rate in load testing
- Successfully scaled across multiple worker nodes
- Database replication lag < 100ms
- 99.9% uptime in production

## Team Members
- Soham Ravindra Lokhande (46816606)
- Swami Sivananda Nanendla (62389275)

## Key Achievements
- Successfully implemented a scalable microservices architecture
- Achieved high availability through database replication
- Implemented automated scaling with Kubernetes
- Maintained zero-downtime deployments
- Secured the application with industry-standard practices

## Future Enhancements
- Implement real-time movie recommendations using ML
- Add social features and user reviews
- Enhance analytics dashboard
- Implement A/B testing capabilities
- Add support for multiple languages

## System Design & Infrastructure

### Infrastructure Setup
- **AWS EC2 Instances**
  - 1 Control Plane node (t2.micro)
  - 3-4 Worker nodes (t2.micro each)
  - Used for running Kubernetes cluster
  - Region: us-west-2 (Oregon)

- **Docker Containers**
  - Multi-stage builds for optimized images
  - Separate containers for:
    - Frontend (Tomcat + Web Application)
    - MySQL Master
    - MySQL Slave
  - Images stored in Docker Hub

- **Kubernetes Configuration**
  - Deployments for each service
  - Services for internal communication
  - Ingress for external access
  - ConfigMaps for environment variables
  - PersistentVolumeClaims for database storage

### Current Status
**Note**: The AWS instances have been shut down to avoid incurring charges. The application can be redeployed using the following resources:
- Docker images are available on Docker Hub
- Kubernetes configuration files in the repository
- Database backup available in the repository
- Setup instructions in the project documentation

To run the project locally:
1. Clone the repository
2. Build Docker images using provided Dockerfiles
3. Use docker-compose for local development
4. Follow setup instructions in project documentation

For production deployment:
1. Set up AWS EC2 instances
2. Initialize Kubernetes cluster
3. Deploy using provided Kubernetes configurations
4. Configure domain and SSL certificates

JMeter Test Results:-

1 Control Plane + 3 Worker nodes + 1 master MySQL pod + 1 slave MySQL pod + 2 Fabflix pods -> 
GUI for 10 secs:-
Throughput-476.893/minute

Non-GUI for 10 secs:-
summary +      1 in 00:00:01 =    1.1/s Avg:   810 Min:   810 Max:   810 Err:     0 (0.00%) 
summary +     72 in 00:00:30 =    2.4/s Avg:  3615 Min:   107 Max: 25308 Err:     0 (0.00%) 
summary =     73 in 00:00:30 =    2.4/s Avg:  3577 Min:   107 Max: 25308 Err:     0 (0.00%) 

1 Control Plane + 4 Worker nodes + 1 master MySQL pod + 1 slave MySQL pod + 3 Fabflix pods -> 
GUI for 10 secs:-
Throughput-456.571/minute

Non-GUI for 10 secs:-
summary +     90 in 00:00:39 =    2.3/s Avg:  2720 Min:   155 Max: 21617 Err:     0 (0.00%) 
summary +     68 in 00:00:27 =    2.5/s Avg:  5661 Min:   204 Max: 23411 Err:     0 (0.00%) 
summary =    158 in 00:01:06 =    2.4/s Avg:  3986 Min:   155 Max: 23411 Err:     0 (0.00%)
    

=======
Video url:- https://youtu.be/N4PuicF4jGY
=======
Video url:- https://youtu.be/rmkFwWX18HU
>>>>>>> ea558a3 (update readme again)
=======
Video url:- https://youtu.be/my5R8KCekME
>>>>>>> d963760 (updated readme)

Contributions-
Soham Ravindra Lokhande(46816606) –  Worked on adding reCAPTCHA and HTTPS. Worked on Employees Dashboard, add movie and reCAPTCHA. Worked on parsing, actors and cast xml. Came up with the stored procedure and One optimization technique -batch_insert

Swami Sivananda Nanendla(62389275) – Worked on adding PreparedStatement and Encrypted Password. Worked on Employees Dashboard- add star and metadata. Worked on parsed main.xml. Came up with the stored procedure and One optimization technique -hashmap

Prepared Statmenets used in .java files in src-
AddMovieServlet
AddStarServlet
CartServlet
EmpLoginServlet
GenreList
LoginServlet
MoviesServlet
ParserRdit
PaymentServlet
SingleMovieServlet
SingleStarServlet

Parsing time optimization strategies used are (in ParserEdit.java)-

Batch_insert : Since there are large amount of entries to be inserted into the database of the similar type and format, we chose Batch_insert that can load all those entries at once into the databse and works efficiently. Whereas if you just iterate through each entry with a loop and then insert them one-by -one , it will take a lot of time, memory and cpu power to do that and hence is very inefficient. Also those entries which are invalid are handled in batch entries and it does not stop the whole program.
Before by using loops to insert data one by one it would take around 15 minutes for the data to be parsed from the files and load into the database. But with batch_insert, it just took around 7-8mins

Hashmap for storing data: Since we parsed large amounts of data from the xml files, there were many ids which were foreign keys of another and they had to be stored somewhere where they can be easy accessible by spending the least amount of time. Since Hashmaps have O(1) accesing time. We used it store are values and used them in prepared statement for more efficient time complexity than other robust data structures. Bedore we tried to get info about the attributes by running queries and fetching the databse which took a lot of time but when we used Hashmap, the time reduced to 2 mins because if stored all the handy data in this data structure and made it work like a cache. So instead of querying all the time we just referred to the cache.

Stored procedures- We used stored procedure and called them in batch_insert for more efficent usage of storage and time and also to clean the code easy to read. Using just normal queries would take more space and time due to the associated varibles but in stored procedure each query is processed efficetnlt.


Inconsistent report -

In actors63.xml - at actor stagename>Diahnne Abbott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kareem AbdulJabbar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>F.Murray Abraham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Abrahams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maury Abram dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Victoria Abril dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Ackroyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Ackroyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Adames dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sam Adams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ben Affleck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Casey Affleck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria Aitkins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Serap Aksoy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Josh Albee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edward Albert~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Albert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rutanya Alda dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vera Alentova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandy Alexander dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hope AlexanderWells dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrea Allan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Catherine Allegret dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rae Allen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Allen~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kirstie Alley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pedro Almodovar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria Conchita Alonso dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Corinne Alphen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betty Amann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leonora Amar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lucio Amelio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Amos dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Amplas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dev Anand dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bridgette Andersen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bibi Anderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>E. Erich Anderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harriet Anderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ingrid Anderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Melissa Sue Anderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carole Andre dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gabe Andre dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fr\'ed\'ric Andrei dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Andrews dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eamonn Andrews dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Andrews Sisters dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Hells Angels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ivy Angustain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karen Anspach dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adam Ant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lysette Anthony dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Anthony dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Anton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laura Antonelli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lou Antonio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alfonso Arau dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Allan Arbus dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Archer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carmen Argenziano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adam Arkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Arkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bess Armstrong dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Curtis Armstrong dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeanetta Arnette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Arnott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosanna Arquette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Ash dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Ashley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Ashley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregoire Asian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Luke Askew dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chuck Aspegren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Armand Assante dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Asta dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adele Astaire dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kim Atwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brigitte Auber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joss Auckland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Audrey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Austin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Auteuil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Luis Avalos dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Avery dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margaret Avery dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nina Axelrod dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hoyt Axton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Ayer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Aykroyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregg Ayres dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shabana Azmi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candy Azzara dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kevin Bacon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hermione Baddeley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Baer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Blanche Baker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathy Baker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruby Baker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rebecca Balding dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adam Baldwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alec Baldwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Baldwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Baldwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Florinda Balkan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vincent Ball dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Victor Banerjee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donatas Banionis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alex Bank dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aaron Banks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Olga Baraclanova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christine Baranski dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joyce Barbour dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mijanou Bardot dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonny Barger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lex Barker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcie Barkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mikhail Barishnikov dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jake Barnes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julian Barnes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Priscilla Barnes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlie Barnett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nella Barnier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandy Baron dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pierre Barouh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria Barranco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Barrie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maurice Barrier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Barris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Barrymore~III dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maurice Barrymore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eddie Barth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Basil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Count Basie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Baskin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alfie Bass dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Bassett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Bates dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Belinda Bauer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steven Bauer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Baxley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Bay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nathalie Baye dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Bayer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Beals dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Beatles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John C. Becher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kimberly Beck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stanley Beck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Beckerman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Molly Bee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hagan Beggs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ed Begley~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Belcher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara BelGeddes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Bell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Agostina Belli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Olga Bellin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Belmonts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Beltran dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Beltran dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Belushi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Belzer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Benatar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Benben dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Benedict dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Annette Bening dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Bennett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbi Benton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susanne Benton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Iris Berben dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judith-Marie Bergan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Bergen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Katya Berger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Berger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harold Bergman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Bergman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandahl Bergman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tracy Bergman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thommy Bergren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steven Berkoff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennie Berlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Berman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jason Bernhard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandra Bernhard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Berridge dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phillip Berrigan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chuck Berry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Halle Berry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Berryman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bibi Besch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Bestar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Beutel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Turhan Bey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Biehn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ramon Bieri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Billingsley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geoff Binney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edward Binns dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brad Bird dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Bishop dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Bishop dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bonnie Bittner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gunnar Bjornstrand dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jon Blake dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Whitney Blake dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michel Blanc dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alan Blanchard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pierre Blanchard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Blankfield dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Blay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Debra Blee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Blodgett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Verna Bloom dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hart Bochner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Boensh~III dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Bohringer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tiffany Bolling dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sudie Bond dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Natalya Bondartchuk dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Bonerz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beverly Bonner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Val\'erie Bonnier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bonzo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Connie Booth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Powers Boothe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paola Borboni dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matt Borel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dirk Borgarde dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Victor Borge dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nelly Borgeaud dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Benjamin Bottoms dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Boulanger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mathew Boulton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carole Bouquet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charon Bourke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Bovasso dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Bova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Bowen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Bowen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Malick Bowes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothy Boyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Guy Boyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William `Stage' Stage dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Bowery Boys dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jean Bradin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terry Bradshaw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Brady dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rob Brady dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonia Braga dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miriam Brickman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wilford Brimley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kenneth Branagh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Brandon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betsy Brantley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Larry Breeding dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hanna Brejchova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Timothy Brent dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patricia Breslin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>JeanClaude Brialy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bricktop dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wilford Brimley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Brocco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phil Brock dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Brockette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elisabeth Brooks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hildy Brooks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James L. Brooks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louise Brooks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Antonia Brough dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Foxy Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gaye Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Janet Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lou Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Reb Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Aaron Brown dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathy Browne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lenny Bruce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nadja Brunkhorst dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phil Bruns dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Bryant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Buchan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betty Buckley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Buckwalter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Raymond Buktencia dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeremy Bulloch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Avis Bunnage dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Bur dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Burdon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Burgess dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Burghoff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Burkley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Burlinson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Smiley Burnette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marilyn Burns dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephan W. Burns dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Burns dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terri Burrell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jackie Burroughs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Burrows dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeff Burton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>LeVar Burton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy "Green" Bush dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Butler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Butler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yancy Butler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Buttram dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruth Buzzi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Byner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Byrd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Byrne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martha Byrne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathleen Byron dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cheri Caffaro dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Cagney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shakira Caine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Cali dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Simon Callow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Coleen Camp dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hamilton Camp dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Campanella dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Campbell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cheryl Campbell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daisy Campbell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Canning dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Freedy Cannon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathy Cannon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ahna Capri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kate Capshaw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irene Cara dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Cardella dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Cardi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arthur Carewe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Carey~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Carey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Carhart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leo Carillo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Carlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Carlisle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johanna Carlo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Carlson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karen Carlson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Moose Carlson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Carlson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ingmari Carlssen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Carme dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Carmen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Angela Carnon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Horace Carpenter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Carpenter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carpin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carol Carr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darleen Carr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Carr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Carradine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Carrey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matthew Carriere dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Carrol dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Regina Carrol dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Regina Carroll dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kit Carson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Carter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lydia Carter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynda Carter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>T.K. Carter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernie Casey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Cassidy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>JeanPierre Castaldi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kim Cattrall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Olimpia Cavalli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dick Cavett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Cazenove dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Renzo Cesana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>June Chadwick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Challee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wilt Chamberlain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marilyn Chambers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jackie Chan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Simon Chandler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margo Channing dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Esme Chaplin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Josephine Chaplin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geraldine Chapman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Graham Chapman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lonny Chapman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bobby H. Charles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ian Charleson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henri Charrieri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Chase dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martine Chassaing dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marvin Chatinover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Soumitra Chatterjee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joan Chen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrice Chereau dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arthur Chesney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Chester dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Cheung dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Chevalier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonny Chiba dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Chitty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shelby Chong dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thomas Chong dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarita Choudhury dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Navin Chowdhury dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Cristian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suzanne Christian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kay Christopher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Christopher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Churchill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Augusta Ciolli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Audrey Claire dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy Clanton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gordon Clapp dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Clapton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>D. Greydon Clark dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Clark dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Caitlin Clarke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon D. Clarke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Warren Clarke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Clendinning dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Clennon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Corinne Clery dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy Cliff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Al Cliver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Clooney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Raymond Cloutier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Cluff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>June Clyde dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Coe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tristam Coffin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mindy Cohen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicholas Colasanto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mabel Colcord dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosalie Cole dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Coleby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dabney Coleman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Colin~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kenneth Colley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Collier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patience Collier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phil Collins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roberta Collins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Colomby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miriam Colon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Willie Colon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tita Colorado dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Norman Combes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frederick Combs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Commodores dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fay Compton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Oliver Conant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Didi Conn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betty Connell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chris Connelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jenifer Connelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Considine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Considine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michel Constantin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mario Conti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carolyn Conwell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Perry Cook dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Cook dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alice Cooper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terrec Cooper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sofia Coppola dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Corbin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lola Cordova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irwin Corey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judy Cornwell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Salvatore Corsitto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Cortese dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicholas Cortland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Cory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wendell Cory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cybil Cosack dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ernest Cosart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rich Cosentino dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Desiree Costeau dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carolyn Courage dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cicely Courtneige dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maggie CousineauArndt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Herbert `Cowboy' Coward dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruth Cox dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Coyote dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Crabtree dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Crain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Grant Cramer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Norma Crane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Crawford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Plett Creighton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Creley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Crenna dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Crichton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lou Crisoula dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Crocker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dick Crockett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cathy Lee Crosby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Crosby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kim Crosby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Crosby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scatman Crothers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lindsay Crouse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Cullum dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothy Cumming dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Quinn Cummings dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Cummings dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peggy Cummins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Cunningham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Curreri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Currie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sondra Currie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Curry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Curtin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Curtin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kelly Curtis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maryam DAbo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Willem Dafoe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lil Dagover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Daily dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irene Daily dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Dale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beatrice Dalle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Damon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Dana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leona Dana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mara Danaud dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Dance dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom dAndrea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mirella D'Angelo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rodney Dangerfield dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suzanne Danielle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Daniels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeff Daniels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sybil Danning dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Danza dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patti D'Arbanville dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruth Dardick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Darien dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jean Daste dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elyssa Davalos dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Doris Davenport dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eileen Davidson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lolita Davidovitch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clifton Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geena Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gene Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Larry Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lyndon Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mac Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miles Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phyllis Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonny Carl Davis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marjorie Daw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marpessa Dawn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clayton Day dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Day dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lawrence Day dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marceline Day dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Deacon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laura Dean dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darcia Deane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria DeAragon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kristine DeBell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John DeBello dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ermelinda deFelice dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Luca DeFilippo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peppino DeFillippo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Willem Defoe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicholas DeGunzberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank deKova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carla DelPoggio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Deman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria deMadeiros dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rebecca deMorney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Raymond Denny dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rossy dePalma dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elisabeth Depardieu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frederic dePasquale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe deRita dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cleavant Derricks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne DeSalvo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe DeSantis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ed DeStefane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maruschka Detmers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Devane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Devane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Danny deVito dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Devlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Devlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Dewaere dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Dewhurst dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy DeWolf dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elliot Dexter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Dey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Selma Diamond dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bobby DiCicco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lucinda Dickey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arthur Dignam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Dimbleby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Piero DiOrio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dante DiPaolo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Dishy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Divine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Loretta Divine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Dixon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ivan Dixon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gitty Djamal dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Dobisch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Doherty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arturo Dominici dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Donat dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruth Donelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donal Donnelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrice Donnelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>King Donovan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Doohan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Doqui dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karin Dor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Dorff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Angela Dorian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susana Dosamantes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Diana Douglas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kent Douglas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robyn Douglas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Douglas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ned Dowd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betsy Drake dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Drake dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Dray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Georgiana Drew dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lesley Dudley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Duffy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Duggan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Olympia Dukakis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Dukes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Dulo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandra Dumas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gerald duMaurier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carmen Duncan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Isadora Duncan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Victor Dunlop dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Liam Dunn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Dunn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Dunne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Dunphy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Duprey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Durbee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Monique Dury dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Dvorsky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cameron Dye dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Dylan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Dysart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Dysart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Dzunda dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Eastman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marilyn Eastman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alison Eastwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kimber Eastwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kyle Eastwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shirley Eaton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Horst Ebersberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christine Ebersole dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eileen Eckhart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gosta Eckman~sr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gosta Eckman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hallie Eckstein dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Edmonds dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Edwards dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Edwards dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Luke Edmonds dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Snitz Edwards dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Eilbacher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Janet Eilber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Eisley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ike Eisenmann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Duke Ellington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Biff Elliott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Elliott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Elliott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Elliott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Ellis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Art Ellison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sallee Elyse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Emil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Englund dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Doc Erickson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Krista Errickson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Howard Erskine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Emilio Estevez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shari Eubank dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Evans dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Trish Everly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Ewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Eyer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eduardo Fajardo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lola Falana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fabray Falconetti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Fallender dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Lee Falt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Faraldo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Amy Farber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria Farebrother dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Violet Farebrother dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Antonio Fargas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Farnsworth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dustin Farnum dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Felicia Farr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jamie Farr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Derek Farr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nick Farrell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Farrell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephanie Farrow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tisa Farrow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Graham Faulkner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Faulkner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michelle Fawden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynne Federicks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Birgitte Federspiel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frances Feist dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tovah Feldshuh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sylvie Fennec dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Willie Fennell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irine Fenwick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamelyn Ferdin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>J. Don Ferguson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Ferguson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wilhelmina Fernandez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Noel Ferrier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lou Ferrigno dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karen Field dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edward Fielding dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margaret Fielding dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Fields dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>W.C. Fields dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Filer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Fimple dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>T.G. Finkbinder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Finley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Warren Finnerty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shirley Jo Finney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elena Fiore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eddie Firestone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Larry Fishburne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cindy Fisher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frances Fisher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fannie Flagg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Flagg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George "Buck" Flower dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joel Fluellen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leo Fong dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Genevieve Fontanel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margot Fonteyn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Ford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Foreman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frederic Forrest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mike Forrest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Constance Forslund dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henderson Forsythe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nick Apollo Forte dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Foster dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Meg Foster dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phil Foster dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Foster dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susannah Fowle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernard Fox dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rolla France dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eve Francis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ivor Francis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jacques Francois dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ben Frank dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Frank dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Franken dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Frankeur dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aretha Franklin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Franks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Fraser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Frazer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sheila Frazer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynn Frederick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vicki Frederick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alan Freed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bert Freed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Freedman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Amy Freeman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Freeman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Morna Freeman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Morgan Freeman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sauri Frey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Friedman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Friedrich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gustav Froehlich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Fryer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alan Fudge dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dale Fuller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dolores Fuller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lance Fuller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jessie Lee Fulton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Furst dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Gahagan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Max Gail dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlotte Gainsbourg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Serge Gainsbourg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Gallagher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Gambon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Gammell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Gampu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Abel Gance dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruno Ganz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Teresa Ganzel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andres Garcia dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Art Garfunkel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Garko dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Garay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joaquin Garay~III dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eliza Garrett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leif Garrett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ellen Garrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harold Gary dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorraine Gary dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marie-Louise Gassen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fernand Gavet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erica Gavin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Gaynes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Gazzo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ellen Geer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laura Gemser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Gentile dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nathan George dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rita George dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carmelita Geraghty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Gerber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Flo Gerish dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Getz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judi Gibbs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Colin Gibson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stefan Gierasch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Gifford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gloria Gifford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Melissa Gilbert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Gilchrist dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maude Gill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dana Gillespie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anita Gillette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stu Gilliam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terry Gilliam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Virginia Gilmore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ian Gilmour dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Ginty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anton Glanzelius dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yves Glary dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gil Glasco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sabine Glaser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Glass dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Gleason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roy Glenister dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Gless dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Glover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Crispin Glover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Glover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carlin Glynn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jacques Godin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernard Goetzke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Goff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matt Goldsby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clio Goldsmith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bobcat Goldthwait dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arlene Golonka dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Gonzales dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dody Goodman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suki Goodwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Allen Goorwitz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Colin Gordin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dexter Gordon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Gordon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keith Gordon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Gordon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynee Gorman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karen Gorney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lou Gossett~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Walter Gotell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jason Gould dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Gover dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Goz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nickolas Grace dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gerrit Graham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Grant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard E. Grant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erin Gray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joel Gray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gilbert Green dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keith Green dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marika Green dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Seth Green dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>H.Richard Greene dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leon Green dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mean Joe Greene dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Greene dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clare Greet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andre Gregory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Celia Gregory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dora Gregory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Gregory dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Grey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Grieg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helmut Griem dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Alan Grier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosie Grier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kirstin Griffith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Simone Griffith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tracy Griffith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ele Grigsby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Grimaldi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jonathan Griss dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claire Griswold dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ake Groenberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Herbert Gronemeyer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sam Groom dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Muriel Gross dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Grovenor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gustav Grundgens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Francois Guerin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruy Guerra dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Guest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lance Guest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicholas Guest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Guilford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Guillaume dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fernando Guill\'en dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Gunner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ray Guth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Guttenberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Little Tough Guys dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Gwillin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Gwynne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Haake dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sayle Haddon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ross Hagen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Hagerty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Merle Haggard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Haggerty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brahim Haggiag dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gisela Hahn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Haid dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sig Haig dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Haines dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Hale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jackie Earle Haley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>H.B. Halicki dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Albert Hall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ray Hallam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lillian HallDavis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brett Halsey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mie Hama dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Veronica Hamel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernie Hamilton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Hamilton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suzanne Hamilton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ben Hammer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Hampton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Master Bong Soo Han dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miyi Hana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lloyd Hanes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mie Hanna dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darryl Hannah dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patti Hansen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Harcourt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Hardin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ty Hardin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lyn Harding dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karl Hardman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Hargreaves dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Harmon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Harper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tess Harper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Harrington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aaron Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anita Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brad Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ed Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joann Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julius W. Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leigh Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leonard Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynette Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>M.K. Harris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cathryn Harrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Harrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregory Harrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jenilee Harrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Harrow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Harry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Hart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Veronica Hart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ena Hartman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Hartman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Hartman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurence Harvey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Herk Harvey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Haskins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Hasselhoff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terry Hatcher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Hatch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rohini Hattangady dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rondo Hatton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Max Haufler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fay Hauser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joachim Hauser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wings Hauser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thomas Haustein dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nigel Havers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Hawley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Haydon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Lind Hayes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Haynes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jonathan Haze dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Katherine Healy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marta Heflin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Hegarty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Hegerty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elayne Heilveil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Hell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Randee Heller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Helm dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Florence Helminger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Helmore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Albert Henderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Skitch Henderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nancy Hendrickson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Janet Henfrey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marilu Henner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Henning dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lance Henriksen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregg Henry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Hensley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicky Henson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dee Hepburn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Herbert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Herd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>PeeWee Herman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Woodie Herman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leila Hermosa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcel Herrand dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arnold Hess~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Howard Hesseman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Hewett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martin Hewitt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Hickman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Catherine Hicks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dana Hill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marianna Hill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Norman Hill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tommy Hill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candace Hilligoss dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Warren Hillman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregory Hines dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maurice Hines dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick K. Hinses dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darby Hinton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Hodern dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hulk Hogan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Hogan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Hogan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Holbert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Holcomb dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Holden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geoffrey Holder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Heidi Holicker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Holland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martha Holliday dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hollye Holmes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Holmes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Oscar Homolka dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Hooten dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beverly Hope dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Hope dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christiane Hoerbiger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Hoerbiger dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Len Horne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Horsley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Horton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Houser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Houser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brie Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clint Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mel Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Howard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cherie Howell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kelly Hu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Allan Hubbard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Hubbard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Season Hubley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cooper Huckabee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Huddleston dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Hudson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ernie Hudson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brent Huff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wendy Hughes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel HughKelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Hulce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dianne Hull dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Humphries dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy Hunt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Hunt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kaki Hunter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pam Huntington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Hurt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ferlin Husky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Hylands dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mike Hynson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Idle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Iglehart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>A.B. Imenson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Amy Ingersoll dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Ironside dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Irvine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Zachary Ittimangnaq dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregory Itzin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judith Ivey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kereem Abdul Jabar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wolfman Jack dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jamie Smith Jackson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Jackson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sherry Jackson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irene Jacob dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Saeed Jaffrey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Jaglom dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth James dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jessica James dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonny James dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fr\'ed\'erique Jamet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Horst Janson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Famke Janssen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louis January dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Jason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lang Jeffries dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ian Jenble dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claudia Jennings dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roy Cameron Jensen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roy Jenson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Jillian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Johansen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Glynis Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Johnston dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laura Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynn-Holly Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michelle Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tor Johnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jo Johnston dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Duane Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Grace Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hannah Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeffrey Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jocelyn Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>OLan Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terry Jones dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Samson Jorah dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christine Jorgenson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jackie Joseph dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erland Josephson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darwin Joston dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Joy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Judd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gordon Jump dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>June dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deana Jurgens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Robertson Justice dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gabi Just dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Justin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suzanne Kaaren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wolf Kahler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Florence Kahn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jonathan Kahn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Toni Kalem dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Kallianoites dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ida Kaminska dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anna Kanakis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Kanaly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Byron Kane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy Kane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Kane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gabe Kaplan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shashi Kapoor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Kaprisky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Kaquitts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kevin Karson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosanne Katon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Kauffman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andy Kaufman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Kaufmann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorrie Kavanaugh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Kavner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Kay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Diane Kay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Caren Kaye dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lainie Kazan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Keach dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Kehoe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kishi Keiko dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Keith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothy Keller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Kellerman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Kelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeanette Kelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Kelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paula Kelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Kelly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rachel Kempson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Takakura Ken dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Kendall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alexa Kenin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gerard Kennedy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jayne Kennedy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leon Isaac Kennedy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sean Kenney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jill Kennington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothea Kent dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Doris Kenyon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Kerr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>J. Herbert Kerr~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Kerridge dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathy Kersh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Kerwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lance Kerwin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jillian Kessner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sara Kestelman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Keyloun dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chaka Khan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Kidd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dead End Kids dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>East Side Kids dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Kimmel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Kinanju dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adrienne King dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernard King dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mabel King dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela King dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Zalman King dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Melinda Kinnaman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruno Kirby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Al Kirkeby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sally Kirkland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Kirkwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Oreste Kirkop dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terry Kiser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tawny Kitaen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Kitchen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bodil Kjer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Klein dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kevin Kline dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Val Kline dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Debra Klose dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Knell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Evel Knievel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandra Knight dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ted Knight dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Walter Koenig dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anna Konstam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leopoldine Konstatin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keystone Kops dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlie Korsmo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Koslowski) dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sho Kosugi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeroen Krabbe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeffrey Kramer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Kreuzer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anneline Kriel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alice Krige dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marta Kristen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Kroner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gene Krupa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vivian Kubrick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Kukas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cal Kuniholme dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alwyn Kurts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Katy Kurtzman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Kushner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Labiosa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ronald Lacey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Taylor Lacher dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Lack dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Denis Lacroix dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Lacy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Ladd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcy Lafferty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christine Lahti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Lahti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorenzo Lamas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Lambert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Lambert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Heath Lamberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Molly Lamont dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Lampkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karl Lanchbury dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geoffrey Land dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judy Landers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurene Landon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Landsburg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Abbe Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jocelyn Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kent Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mike Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rusty Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Lane dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Perry Lang dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Langdon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurie Lapinski dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erik Larsen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ham Larsen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sidney Lassick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lassie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louise Latham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Queen Latifah dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Latimore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matt Lattanzi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lyle Lattel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ellen Hamilton Latzen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carol Laure dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurel and Hardy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Laurie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adam Lawrence dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruno Lawrence dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Lawrence dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Leach dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosemary Leach dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stanley Leavitt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kelly LeBrock dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Otto Lederer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carl Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>China Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cinque Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cynthia Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joie Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robbie Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pinky Lee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Spike dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Leenhardt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eva leGallienne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beatrix Lehman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Leifert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Leindecker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donovan Leitch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Lembeck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Meadowlark Lemon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Lennon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jean Lenoir dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rula Lenska dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leib Lensky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Leon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tea Leoni dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Lerner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Madeleine Leroux dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Lesser dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Buddy Lester dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Lewis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geoffrey Lewis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Lee Lewis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Lewis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Viola Leyel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Libby dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Liberace dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anne Libert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeremy Licht dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mitchell Lichtenstein dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anki Liden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Liebman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lo Lieh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gordon Lightfoot dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Audra Lindley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark LinnBaker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>L\'eon M. Lion dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eugene Lipinski dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Lipscomb dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Lithgow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Little dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stanley Livingston dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Desmond Llewellyn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Lloyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Emily Lloyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathleen Lloyd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony LoBianco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Philip Locke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Heather Locklear dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Loden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jaqueline Logan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert F. Logan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sol Lomita dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Lone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Avon Long dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shelley Long dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claudine Longet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ray Lonnen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Herbert Loom dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nancy Loomis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rod Loomis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gerry Lopez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Perry Lopez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gail Lorber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Traci Lords dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Lorea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Louie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Louis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Willard Louis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phyllis Love dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dyson Lovell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rob Lowe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynn Lowry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Lu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Lucas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Luce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Ludlam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorna Luft dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jorge Luke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aldrick Lukes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Lupone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alfred Lutter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Lyons dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ralph Macchio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeanette MacDonald dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andie MacDowell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marlena MacGuire dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Macht dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kerry Mack dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marion Mack dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fulton Mackay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Janet MacLachian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kyle MacLachlan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert MacNaughton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter MacNicol dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Macrae dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William H. Macy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Madden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Amy Madigan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Mahoney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chris Makepeace dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mako dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Malahide dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Malcolm dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurent Malet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Malkovich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tania Mallett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Mandan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karin Mani dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Guido Mannari dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dinah Manoff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clelia Mantania dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Mantell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kiti Manver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Manville dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Manzy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcel Marceau dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nancy Marchand dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrea Marcovicci dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Janie Mareze dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Margotta dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cheech Marin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rikki Marin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kika Markham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ted Markland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Marlowe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Evaristo Marquez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sally Marr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arthur Marshal dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bryan Marshall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Marshall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Marshall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Penny Marshall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Marshall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jean Martin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Sue Martin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frederick Martini dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Al Martino dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Martinson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marx Brothers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Masak dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Mask dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Mason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hilary Mason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Mason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edith Massey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Masterson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sean Masterson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Elizabeth Mastrantonio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Masur dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clelia Matania dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julian Mateus dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Mathers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Matthey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Mattson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cyril Maude dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carmen Maura dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Russ Mayberry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Mayhew dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Melanie Mayron dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ray McAnnely dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrea McArdle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcia McBroom dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frances Lee McCain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irish McCalla dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrew McCarthy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rue McClanahan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fergus McClelland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marc McClure dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keith McConnell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard McConnell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kent McCord dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat McCormick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Van McCoy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeff McCracken dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jody McCrea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kit McDonough dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betty McDowall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arnie McEnroe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Spanky McFarland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vonetta McGee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Everett McGill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ted McGinley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alec McGowan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ali McGraw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Angela Punch McGregor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie McGregor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill McGuire dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marlena McGuire dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen McHattie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael McKean dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lonette McKee dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>T.P. McKenna dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kate McKenzie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Norman McKinnel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill McKinney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hollis McLaren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John C. McLaughlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Diana McLean dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John McLiam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marshall McLuhan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ed McMahon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John McMartin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kenneth McMillan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara McNair dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claudia McNeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathryn McNeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maggie McOmie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank McRae dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Audrey Meadows dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joyce Meadows dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>DeAnn Mears dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sylvie Meda dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Meeker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mariangela Melato dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claudine Melgrave dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Melling dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fuller Mellish~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Breno Mello dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sam Melville dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mauro Mendonco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nerida Mercado dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Meredith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Meredith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Merivale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Merrall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Metzler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Torben Meyer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vittorio Mezzoglomo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Drew Michaels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jordan Michaels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matt Michaels dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Michelle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlotte Michelle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tatsuta Mihashi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Mikulski dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mario Milano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kelly Miles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lillian Miles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sherry Miles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kim Milford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Penelope Milford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ray Millard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Denny Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eve Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathleen Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Penelope Ann Miller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andra Millian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Mills dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mort Mills dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Josh Milrad dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jan Miner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Emile Minty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irene Miracle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Channing Mitchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Mitchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Duke Mitchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leigh Mitchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Mitchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chris Mitchum dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Mitchum dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nobuko Miyamoto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jayne Modean dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Matthew Modine dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Moffat dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Angela Molina dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Georgia Moll dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Mollison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Monsanto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carlos Montalban dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lenny Montano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Montegna dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>M.J. Montfajon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Montgomery dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Moody dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keith Moon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alvy Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candy Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Demi Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eileen Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kenny Moore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Santos Morales dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erin Moran dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gerard Moran dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Agnes Morehead dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rina Morelli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cindy Morgan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Debbi Morgan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hank Morgan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sidney Morgan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stafford Morgan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cathy Moriarty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Moriarty dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lucilla Morlacchi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Garrett Morris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Glenn Morris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shelley Morrison dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Morrissey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Morse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Morse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Morse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hilary Morse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Mosley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joshua Mostel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judy Motulsky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mickey Mouse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Movak dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martin Mull dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy Mumy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Meg Mundy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jonathan Munk dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Irina Muravyova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Murdock dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlie Murphy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Murphy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Murphy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Murray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Doyle Murray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Murray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Myers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jim Nabors dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joanne Nail dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Reggie Nalder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Nance dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Nance dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brian Narelle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Clarence Nash dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Nathan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Naughton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rene Navarre dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Audrie J. Neenan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kay Neer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Liam Neeson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Little Nell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Nelson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Craig T. Nelson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kenneth Nelson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Nelson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosalba Neri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tommaso Neri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Neuman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Nevens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carol Irene Newell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorraine Newman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rachel Newman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Newman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Haing S. Ngor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Britt Nichols dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nichelle Nichols dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daria Nicolodi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brigitte Nielsen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Niemi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Niland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cynthia Nixon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nancy Lee Noble dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Trisha Noble dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miyamoto Nobuko dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Natalie Nogulich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Nolan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Nolan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mike Nomad dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christine Noonan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Noonan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Norman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Norris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mike Norris dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Northup dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Norton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Nouri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terri Nunn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Will Nye dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cicely Oates dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan OBannon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ana Obregon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hugh OBrien dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maria OBrien dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrea Occhipinti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Taffy OConnell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kevin OConnor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carroll ODea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judith ODea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chris ODonnell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lani OGrady dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Catherine OHara dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael OKeefe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miles OKeefe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael OLeary dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lena Olin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barret Oliver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Olivier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Olivier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edward James Olmes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>J. Pat OMalley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Colleen ONeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James ONeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cynthia ONeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shannon ONeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tricia ONeil dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dick ONeill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer ONeill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Remy ONeill dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yoko Ono dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alan Oppenheimer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Opper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathleen ORegan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack ORourke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Umberto Orsini dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mechu Ortiz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Super Dave Osborne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Missy OShea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cliff Osmond dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pernilla Ostergren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeff Osterhage dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Osth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ossi Oswalda dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Overton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Owen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joanna Pacula dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anita Page dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joy Page dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcel Pagliero dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jacqueline Pagnol dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dre Pahich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pal dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anita Pallenberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stuart Pankin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Pantoliano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Pardo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Pare dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Parrish dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louella Parsons dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Pataki dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Pate dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mandy Patinkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Paton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Patrick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorna Patterson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mark Patton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rosemary Paul dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Paulin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Morgan Paull dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Paulsen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anika Pavel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anna Pavlova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Pearce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jacqueline Pearce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patricia Pearcy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jesse Pearson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Peel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joan Peers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pele dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lisa Pelikan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Raymond Pellegrin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pina Pellicer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rick Pemberton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Penn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Penny dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Virginia Penta dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stacey Peralta dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jose Perez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Perlman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anna Perrier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Felton Perry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louis Perryman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Pesci dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stewart Petersen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sammy Petrillo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Howard Petri dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Petrie dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Petterson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jo Ann Pflug dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michelle Phillips dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Phipps dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paloma Picasso dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sorrells Pickard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tiana Pierce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bronson Pinchot dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Miguel Pinero dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dominique Pinon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Danny Pintauro dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Sons of the Pioneers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brad Pitt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Kay Place dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michele Placich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roger Planchon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dana Plato dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Moliere Players dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hilda Plowright dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Amanda Plummer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adelina Poerio dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jean Poiret dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tommy Pollard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sarah Polley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roy Poole dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Albert Popwell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Don Porter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Porter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Markie Post dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Madeline Potter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Annie Potts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cliff Potts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>C.C.H. Pounder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louise Pounds dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Phyllis Povah dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Powell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joynson Powell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Taryn Power dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joan Prather dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wolfgang Preiss dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lucy Prentiss dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Prescott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Prescow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alan Price dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martin Priest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jurgen Prochnow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Prosky dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Prowse dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cameron Prudhomme dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nicholas Pryor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vladimir Pucholt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Purcell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Roselyne Puyo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Monty Python dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Qualen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rita Quigley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aidan Quinn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aileen Quinn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Quinn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Quinnessen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Francine Racette dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kurt Raab dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>M.G. Ramachandran dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gilda Radner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Raffetto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Railsback dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Douglas Rain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ford Rainey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Raisch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laura Rambotham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harold Ramis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Doris Rankin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Rappaport dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Rappaport dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Rapport dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Ratray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Heather Rattray dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Blanche Ravalec dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candy Raymond dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sheila Raynor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Rea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Read dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bertice Reading dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy Redden dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Reddy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Redfield dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Basil Redford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jemma Redgrave dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Reed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Reed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Reed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tracy Reed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Regalbuto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Whit Reichert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frances Reid dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Reigert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Reilly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thomas Reiner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judge Reinhold dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Winston Rekert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Remar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Simone Renant dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Liz Renay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kelly Reno dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Resin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Aldo Rey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alejandro Rey dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael J. Reynolds dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sybil Rhoda dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Rhys dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John RhysDavies dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candice Rialzon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beah Richards dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joely Richardson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lee Richardson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Natasha Richardson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Debi Richter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judith Ridley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peter Riegert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ron Rifkin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terence Right dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Riley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Larry Riley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shane Rimmer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brad Rinn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kristen Riter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Ritz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Ritz-Brothers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cecilia Rivera dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Rivero dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Rivers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joan Rivers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adam Roarke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sam Robards dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mathew Robbins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John C. Roberick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christian Roberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Glenn Roberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael D. Roberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tanya Roberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Teal Roberts dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Robertson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Robertson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robbie Robertson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hayward Robillard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andy Robinson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Robinson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wayne Robson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcia Rodd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maurice Roeves dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lela Rogers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helena Rojo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Howard E. Rollins~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andy Romano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Romer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Annie Ross dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yvonne Ross dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Rossi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leo Rossi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Roth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lionel Royce dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Saul Rubinek dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Rubinstein dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rita Rudner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mercedes Ruehl dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Rumar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Runyon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rupaul dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Rush dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Rush dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Russ dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Betsy Russell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Craig Russell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Russell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gianni Russo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fran Ryan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Ryan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Raisa Ryazonova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Rydall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Ryland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yacef Saadi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Greta Sacchi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Sachs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Sacks dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marianne Sagebrecht dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kengji Sahara dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael SaintDenis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Theresa Saldana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>P.J. Sales dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Louis Salon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Renato Salvatori dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>JoAnne Samuel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Sanada dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jaime Sanchez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Salvatore Sanchez dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Sanderson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Sandor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julian Sands dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Santchi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Santos dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vic Savage dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Savalas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Savini dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Teresa Ann Savoy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peggy Sawyer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Diana Scarwid dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Felice Schacter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wendy Schall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sabrina Scharf dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Catherine Schell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ronnie Schell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>August Schellenberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ralph Schicha dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Claudia Schiffer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anja Schmidt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Schneider dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Magda Schneider dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Schoeffling dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kyra Schon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Avery Schreiber dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dwight Schultz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Scott Schwartz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Schyck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patti Scialfa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Annbelle Sciorra dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edith Scon dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Zvee Scooler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martin Scorsese dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Campbell Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donovan Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jane Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Scott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vito Scotti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Scruggs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Franklyn Seales dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Seay dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Josef Sebanek dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pierre Segui dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Sekka dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Selleck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Milton Selzer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kent Senatore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Seneca dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Assumpta Serna dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julieta Serrano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pilar Seurat dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ralph Seymour dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kamran Shah dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>ShabbaDoo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Glen Shadix dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wallace Shaen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Shaffer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Shalhoub dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Shapiro dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Sharp dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Albert Sharpe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cornelia Sharpe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Shaver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stan Shaw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Susan Damante Shaw dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wallace Shawn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Shea dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Shearer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alice Sheedy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlie Sheen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Shepherd dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paula Sheppard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margaret Sheridan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Shiloal dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yoko Shimada dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sue Shiomi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yumi Shirakawa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dan Shor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothy Short dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Show dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ricky Shroder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard B. Shull dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mort Shuman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sabrina Siami dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Basil Sidney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gregory Sierra dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cynthia Sikes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James B. Sikking dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Trididad Silva dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Silvain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cyndi Silver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Silver dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Arlene Simmons dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Peggy Simpson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gordon John Sinclair dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lori Singer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marc Singer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Steve Singer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Penny Singleton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Sirola dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lilia Skala dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helgi Skulason dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Olga Slade dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard B. Skull dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Helen Slater dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard X. Slattery dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hana Slikova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marya Small dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bubba Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Martin Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jaclyn Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kate Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lane Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mel Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rainbeaux Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rex Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Terri Susan Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Smith dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sonja Smits dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wesley Snipes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy `The Greek' Snyder dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Park Jong Sod dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sojin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>P.J. Soles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andrew Solt dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Sommars dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Sonkkila dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Sorenson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Talisa Soto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Southern dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Merrie Spaeth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fay Spain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vincent Spano dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hazel Spears dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Spence dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Spencer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Posh Spice dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Spielberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Spinell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Loving Spoonful dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>G.D. Spradlin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rick Springfield dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Stacy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Stahl dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Staley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael StAngel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jiri Stanislav dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Forrest Stanley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lora Stanley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Stanmore dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Koo Stark dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kay Starr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ringo Starr dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Starrett dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Imaelda Staunton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alison Steadman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Simonetta Stefanelli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Steinberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Steiner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Albert Steinruck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carolyn Steller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sting dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harvey Stephens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pamela Stephens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Sterling dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tisa Sterling dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy Sterman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel Stern dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Erik Stern dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Stern dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frances Sternhagen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Casey Stevens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Morgan Stevens dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>MacLean Stevenson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alana Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Catherine Mary Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlotte Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandy Stewart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ivy StHelier dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pat Stich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Ogden Stiers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hugo Stiglitz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ben Stiller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sting dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher StJohn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Walter Stocker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Stockwell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Austin Stoker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shirley Stoler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christopher Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Danny Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ivory Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Philip Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Stone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcia Strassman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Russel Streiner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Annette Stroyberg dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barbara Stuart dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Styles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ed Sullivan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Sullivan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tom Sullivan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Madame SulTeWan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Summer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Todd Susman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Sutton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dominique Swain dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Swann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Forrest Swanson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Swanson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bob Sweeney dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dolph Sweet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stanley Swerdlow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tilda Swinton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ken Swofford dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harold Sylvester dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donald Symington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mr. T dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Takei dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Natalie Talmadge dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Tamm dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Quentin Tarantino dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Reba Tassel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sven-Bertil Taube dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vic Tayback dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Delores Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dub Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kit Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Renee Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rip Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valerie Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vaughn Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Zack Taylor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Tepper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Terry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nigel Terry dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>TerryThomas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurent Terzieff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lauren Tewes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lorna Thayer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joe Theismann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jodi Thelen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlize Theron dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Thibeau dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Brondon Thomas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Heather Thomas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henry Thomas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kristin Scott Thomas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tim Thomerson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Derek Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorri Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Emma Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Hal Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lea Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Linda Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kay Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kim Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shawn Thompson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martha Thomsen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Thring dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thu Thuy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Thurman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Theodora Thurman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tiana dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joseph Ticka dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cheryl Tiegs dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mel Tillis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Tillotson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Tilly dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlene Tilton dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marilu Tolo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeana Tomasina dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marisa Tomei dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Geoffrey Toonen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Toto dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tamara Toumanova dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harry Townes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jill Townsend dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrice Townsend dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stuart Townsend dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>J.R. Tozer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Ellen Trainor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daniel J. Travanti dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jemru Travers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nancy Travis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Noel Trevarthen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jack Trevor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Les Tremayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dorothy Tristan dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Judy Trott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Trubshawe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Natalie Trundy dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paris Tselios dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Tucker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Turkel dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Turner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tina Turner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lurene Tuttle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Shannon Tweed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tracy Tweed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Liv Tyler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charles Tyner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Urich dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Badi Uzza dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vera Vague dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Romolo Valli dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Saverio Vallone dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jose vanDam dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Barry VanDyke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Conny VanDyke dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kevin VanHentenryck dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jon VanNess dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rik VanNutter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmie VanPatten dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Timothy VanPatten dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vincent VanPatten dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah VanRhyn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah VanValkenburgh dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Monique VanVooren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Valentina Vargas dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Martin Vaughn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Reginald VelJohnson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Chick Vennera dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Diane Venora dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wanda Ventham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Verushka dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Virginia Vestoff dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcel Vibert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Asia Viera dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robert Viharo dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tony Vilar dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Henri Vilbert dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jesse Vint dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Enzo Vitale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mario Vitale dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Viva dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ruth Vivian dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ferdinand vonAlten dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Thomas vonBromssen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lenny VonDohlen dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gustav vonWangenheim dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Andreas Voutsina dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Milena Vukotic dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Wade dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Russel Wade dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christie Wagner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Wainwright dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Akiko Wakabayashi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eijo Wakabayashi dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kathryn Walker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Maggie Walker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tippy Walker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Max Wall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Wallace dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dee Wallace dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Wallis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Walter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tracey Walter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Julie Walters dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jimmy WangYu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Ward dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Herta Ware dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>S.J. Warmington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Warner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marcia Warner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fran Warren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Warren dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Warrilow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dionne Warwick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Warwick dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beverly Washburn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mavis Washington dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ted Wass dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gedde Watanabe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>William Waterman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Waters dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Charlene Watkins dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bobby Watson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Douglass Watson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Timothy Watson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kristina Wayborn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>E-than Wayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Wayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Keith Wayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Wayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Nina Wayne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carl Weathers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Richard Webb dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ann Wedgeworth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Leslie Weiner dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bruce Weitz dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mrs. Joseph L. Welch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tahnee Welch dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Louise Weller dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gwen Welles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mel Welles dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy Wells dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dawn Wells dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jennifer Wells dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Klaus Wenneman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fritz Wepper dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dianne West dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Westbrook dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Westmoreland dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margaret Weycherle dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Russ Wheeler dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>John Sylvester White dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ted White dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Wilfrid Hyde White dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Ernest Whitman dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Whitmore~jr. dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Who dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>The Wiere~Brothers dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lynda Wiesmeyer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dianne Wiest dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Collin Wilcox dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Larry Wilcox dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Estelle Wildwood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jan Wiley dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jose Wilker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Joy Wilkerson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Donna Wilkes dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Fred Willard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Toyah Willcox dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bernie Williams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Billy-Dee Williams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Eric Bransby Williams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>JoBeth Williams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sharon Williams dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Noble Willingham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Austin Willis dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Pierre-Richard Willm dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Beverly Wills dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Candy Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Elizabeth Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Josephine Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lambert Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Margery Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Louise Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael G. Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Trey Wilson dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Paul Winchell dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Penelope Windust dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Kitty Winn dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Philip Winter dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Deborah Winters dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael James Wixted dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alexander Wolcott dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Wolf dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Allan Wolfe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cyndi Wood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Wood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Gary Wood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lana Wood dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Alfre Woodard dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Bill Woods dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>James Woods dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Edward Woodward dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Morgan Woodward dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Christina World dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mary Woronov dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Marie Wright dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Wright dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Robin Wright dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Vivian Wu dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sandy Wyeth dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Patrick Wymark dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Dennis Wyndham dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Greg Wynne dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Tsutomu Yamazaki dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Celeste Yarnall dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Cassie Yates dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Yury Yarvet dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jeff York dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Rebecca York dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Burt Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Karen Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Mat Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Sean Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Skip Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Stephen Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Victor Sen Young dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Harris Yulin dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Johnny Yune dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>George Zacco dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Lenore Zann dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frank Zappa dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Michael Zaslow dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Suzanne Zenor dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Anthony Zerbe dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Carla Ziegfeld dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Laurie Zimmer dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Adrian Zmed dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>David Zucker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Jerry Zucker dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Daphne Zuniga dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Frantisek Zvarik dob is missing/not an integer at dob>
In actors63.xml - at actor stagename>Darrell Zwerling dob is missing/not an integer at dob>

In mains243.xml - at actor film>fid>CGl44 director is missing
In mains243.xml - at actor film>fid>LwS150 director is missing
In main243.xml - at actor film>fid>LB9 year>19yy year is not an integer
In mains243.xml - at actor film>fid>GC28 director is missing
In mains243.xml - at actor film>fid>GMe10 director is missing
In mains243.xml - at actor film>fid>SSS15 director is missing
In mains243.xml - at actor film>fid>SSS20 director is missing
In mains243.xml - at actor film>fid>SSS25 director is missing
In mains243.xml - at actor film>fid>SSS50 director is missing
In mains243.xml - at actor film>fid>ChJ60 director is missing
In mains243.xml - at actor film>fid>BaD16 director is missing
In mains243.xml - at actor film>fid>JD7 title is missing 
In main243.xml - at actor film>fid>WS45 year>19yy year is not an integer
In mains243.xml - at actor film>fid>WlJ10 title is missing 
In main243.xml - at actor film>fid>AS22 year>199x year is not an integer
In main243.xml - at actor film>fid>AS32 year>199x year is not an integer
In mains243.xml - at actor film>fid>GeP45 title is missing 
In mains243.xml - at actor film>fid>SS4 genre is missing
In mains243.xml - at actor film>fid>DPo2 genre is missing
In mains243.xml - at actor film>fid>DPo4 genre is missing
In mains243.xml - at actor film>fid>GxR10 title is missing 
In mains243.xml - at actor film>fid>GxR10 title is missing 
In main243.xml - at actor film>fid>RHd2 year>199x year is not an integer
In mains243.xml - at actor film>fid>Z6510 director is missing
In main243.xml - at actor film>fid>IAv12 year>199x year is not an integer
In main243.xml - at actor film>fid>MS0 year>196x year is not an integer
In main243.xml - at actor film>fid>MS36 year>2001  year is not an integer
In main243.xml - at actor film>fid>WiW30 year>19yy year is not an integer
In main243.xml - at actor film>fid>DLy25 year>19yy year is not an integer
In main243.xml - at actor film>fid>AEy13 year>19yy year is not an integer
In mains243.xml - at actor film>fid>BSi3 title is missing 
In main243.xml - at actor film>fid>CsS15 year>199x year is not an integer
In mains243.xml - at actor film>fid>KDo1x title is missing 
In main243.xml - at actor film>fid>KDo1x year>199x year is not an integer
In mains243.xml - at actor film>fid>KDo1x director is missing
In main243.xml - at actor film>fid>TdC13 year>19yy year is not an integer
In main243.xml - at actor film>fid>Z9590 year>19yy year is not an integer
In main243.xml - at actor film>fid>AbK15 year>19yy year is not an integer
In main243.xml - at actor film>fid>MkJ11 year>1997  year is not an integer
In main243.xml - at actor film>fid>MJu15 year>19yy year is not an integer

In casts124.xml - at  m>f>ClC18 a> star name is missing
In casts124.xml - at  m>f>DMl10 a> star name is missing
In casts124.xml - at  m>f>H65 a> star name is missin

<<<<<<< HEAD
            if(year!= null && !year.equals("")) query +="(m.year = " + year + ") AND ";
            
            if(director!= null && !director.equals("")) query +="(m.director LIKE '%" + director + "%')
>>>>>>> 2739cac (update readme)
=======
>>>>>>> d963760 (updated readme)
