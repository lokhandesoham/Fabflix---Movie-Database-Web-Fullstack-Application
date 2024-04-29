CREATE DATABASE moviedb;

USE moviedb;

CREATE TABLE movies (
                        id VARCHAR(10) PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        year INT NOT NULL,
                        director VARCHAR(100) NOT NULL
);

CREATE TABLE stars (
                       id VARCHAR(10) PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       birthYear INT
);

CREATE TABLE creditcards (
                             id VARCHAR(20) PRIMARY KEY,
                             firstName VARCHAR(50) NOT NULL,
                             lastName VARCHAR(50) NOT NULL,
                             expiration DATE NOT NULL
);

CREATE TABLE ratings (
                         movieId VARCHAR(10) NOT NULL,
                         rating FLOAT NOT NULL,
                         numVotes INT NOT NULL,
                         FOREIGN KEY (movieId) REFERENCES movies(id)
);

CREATE TABLE stars_in_movies (
                                 starId VARCHAR(10) NOT NULL,
                                 movieId VARCHAR(10) NOT NULL,
                                 PRIMARY KEY (starId, movieId),
                                 FOREIGN KEY (starId) REFERENCES stars(id),
                                 FOREIGN KEY (movieId) REFERENCES movies(id)
);

CREATE TABLE genres (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(32) NOT NULL
);


CREATE TABLE genres_in_movies (
                                  genreId INT NOT NULL,
                                  movieId VARCHAR(10) NOT NULL,
                                  PRIMARY KEY (genreId, movieId),
                                  FOREIGN KEY (genreId) REFERENCES genres(id),
                                  FOREIGN KEY (movieId) REFERENCES movies(id)
);

CREATE TABLE customers (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           firstName VARCHAR(50) NOT NULL,
                           lastName VARCHAR(50) NOT NULL,
                           ccId VARCHAR(20) NOT NULL,
                           address VARCHAR(200) NOT NULL,
                           email VARCHAR(50) NOT NULL,
                           password VARCHAR(20) NOT NULL,
                           FOREIGN KEY (ccId) REFERENCES creditcards(id)
);

CREATE TABLE sales (
                       Id INT AUTO_INCREMENT PRIMARY KEY,
                       customerId INT NOT NULL,
                       movieId VARCHAR(10) NOT NULL,
                       saleDate DATE NOT NULL,
                       FOREIGN KEY (customerId) REFERENCES customers(id),
                       FOREIGN KEY (movieId) REFERENCES movies(id)
);


