DELIMITER //

CREATE PROCEDURE add_XMLmovie(
    IN mid VARCHAR(10),
    IN movie_title VARCHAR(100),
    IN movie_year INT,
    IN movie_director VARCHAR(100),
    IN genre_name VARCHAR(32),
    IN gid INT
    
)
BEGIN
    my_label: BEGIN
        DECLARE message VARCHAR(255);
        DECLARE genre_id INT;
        DECLARE movie_id VARCHAR(10);
        
        -- DECLARE EXIT HANDLER FOR SQLEXCEPTION
        -- BEGIN
        --     -- If an error occurs, roll back the transaction and set a message
        --     ROLLBACK;
            
        --     SET message = 'An error occurred during the transaction.';
        --     SELECT message;
        -- END;

        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
        BEGIN
        -- If an error occurs, roll back the transaction and output a message
            GET DIAGNOSTICS CONDITION 1
            message = MESSAGE_TEXT; -- Retrieve the error message
            SELECT CONCAT('An error occurred during the transaction: ', message) AS message;
            ROLLBACK;
            
        END;

        -- Start the transaction
        START TRANSACTION;

        -- Check if the movie already exists
        SELECT id INTO movie_id
        FROM movies
        WHERE title = movie_title AND year = movie_year AND director = movie_director;

        IF movie_id IS NULL THEN
            -- Insert the new movie
            INSERT INTO movies (id, title, year, director)
            VALUES (mid, movie_title, movie_year, movie_director);
            
            IF genre_name IS NOT NULL THEN

                SELECT id INTO genre_id
                FROM genres
                WHERE name = genre_name;

                IF genre_id IS NULL THEN
                    -- Generate a new ID for the genre

                    -- Insert the new genre
                    INSERT INTO genres (id, name)
                    VALUES (gid, genre_name);

                    INSERT INTO genres_in_movies (genreId, movieId)
                    VALUES (gid, mid);
                ELSE
                    INSERT INTO genres_in_movies (genreId, movieId)
                    VALUES (genre_id, mid);
                END IF;
                
            END IF;
        ELSE
            -- Movie already exists, show message and return
            SET message = CONCAT('Movie already exists. Movie ID:',movie_id);
            SELECT message;
            LEAVE my_label;
        END IF;


        -- Check if the genre already exists
        -- SELECT id INTO genre_id
        -- FROM genres
        -- WHERE name = genre_name;

        -- IF genre_id IS NULL THEN
        --     -- Generate a new ID for the genre

        --     -- Insert the new genre
        --     INSERT INTO genres (id, name)
        --     VALUES (gid, genre_name);

        --     INSERT INTO genres_in_movies (genreId, movieId)
        --     VALUES (gid, movie_id);
        -- ELSE
        --     INSERT INTO genres_in_movies (genreId, movieId)
        --     VALUES (genre_id, movie_id);
        -- END IF;

        -- Link star to movie

        -- Link genre to movie
        

        -- Commit the transaction
        COMMIT;

        SET message = CONCAT('Movie added successfully. Movie ID: ', movie_id,  ' Genre ID: ', genre_id);
        SELECT message;
    END my_label;
END //

DELIMITER ;
COMMIT;
