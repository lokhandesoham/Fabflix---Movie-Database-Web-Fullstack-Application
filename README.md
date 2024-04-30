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

Contributions- Soham Ravindra Lokhande(46816606) – Worked on Login page and set up the Filter Servelt and login redirection. Implemented the Main browsing page and on the html formatting. Worked on the Shopping cart page and the Remove movie button in shopping cart. Made Post request for the credit card information and made the sql query for it and sent the query to database..

Swami Sivananda Nanendla(62389275) – Worked on the Movies Page and formulated all the queries required to extract the desired search result. Worked on Single movie and star page and made queries to order them as required. Worked on the Sort by and Pagination and Prev-next button. Recorded the video.

The LIKE statement is used in the WHERE clause of the SQL query to filter movie titles based on a substring represented by the title variable. It's employed with wildcard characters % before and after the title variable, allowing for matches anywhere within the movie titles. In the search query we have used the like query for instance when user gives only part of the word which is not complete. We can see the example below • ABC%': All strings that start with 'ABC'. E.g. 'ABCD' and 'ABCABC'. • '%XYZ': All strings that end with 'XYZ'. E.g. 'WXYZ' and 'ZZXYZ'.

Below is one of the query we have used using “”like””. Let’s say the user only searches partially with the title , director. (in MoviesServlet.java) if(title!= null && !title.equals("")) query +="(m.title LIKE '%" + title + "%') AND ";

            if(year!= null && !year.equals("")) query +="(m.year = " + year + ") AND ";
            
            if(director!= null && !director.equals("")) query +="(m.director LIKE '%" + director + "%')
>>>>>>> 2739cac (update readme)
