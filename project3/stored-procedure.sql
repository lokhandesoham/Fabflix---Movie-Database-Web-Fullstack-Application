DELIMITER //

CREATE PROCEDURE add_movie(
    IN movie_title VARCHAR(100),
    IN movie_year INT,
    IN movie_director VARCHAR(100),
    IN star_name VARCHAR(100),
    IN genre_name VARCHAR(32),
    IN star_birthYear INT 
)
BEGIN
    my_label: BEGIN
        DECLARE message VARCHAR(255);
        DECLARE star_id VARCHAR(10);
        DECLARE genre_id INT;
        DECLARE movie_id VARCHAR(10);
        
        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            -- If an error occurs, roll back the transaction and set a message
            ROLLBACK;
            SET message = 'An error occurred during the transaction.';
            SELECT message;
        END;

        -- Start the transaction
        START TRANSACTION;

        -- Check if the movie already exists
        SELECT id INTO movie_id
        FROM movies
        WHERE title = movie_title AND year = movie_year AND director = movie_director;

        IF movie_id IS NULL THEN
            -- Generate a new ID for the movie
            SELECT IFNULL(CONCAT('tt', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'tt0000000') INTO movie_id
            FROM movies;

            -- Insert the new movie
            INSERT INTO movies (id, title, year, director)
            VALUES (movie_id, movie_title, movie_year, movie_director);
        ELSE
            -- Movie already exists, show message and return
            SET message = CONCAT('Movie already exists. Movie ID:',movie_id);
            SELECT message;
            LEAVE my_label;
        END IF;

        -- Check if the star already exists
        SELECT id INTO star_id
        FROM stars
        WHERE name = star_name AND (birthYear = star_birthYear OR (birthYear IS NULL AND star_birthYear IS NULL));

        IF star_id IS NULL THEN
            -- Generate a new ID for the star
            SELECT IFNULL(CONCAT('nm', LPAD(SUBSTRING(MAX(id), 3) + 1, 7, '0')), 'nm0000001') INTO star_id
            FROM stars;

            -- Insert the new star
            INSERT INTO stars (id, name, birthYear)
            VALUES (star_id, star_name, star_birthYear);
        END IF;

        -- Check if the genre already exists
        SELECT id INTO genre_id
        FROM genres
        WHERE name = genre_name;

        IF genre_id IS NULL THEN
            -- Generate a new ID for the genre
            SELECT MAX(id) + 1 INTO genre_id
            FROM genres;

            -- Insert the new genre
            INSERT INTO genres (id, name)
            VALUES (genre_id, genre_name);
        END IF;

        -- Link star to movie
        INSERT INTO stars_in_movies (starId, movieId)
        VALUES (star_id, movie_id);

        -- Link genre to movie
        INSERT INTO genres_in_movies (genreId, movieId)
        VALUES (genre_id, movie_id);

        -- Commit the transaction
        COMMIT;

        SET message = CONCAT('Movie added successfully. Movie ID: ', movie_id, ' Star ID: ', star_id, ' Genre ID: ', genre_id);
        SELECT message;
    END my_label;
END //

DELIMITER ;
COMMIT;
