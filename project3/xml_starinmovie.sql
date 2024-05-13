DELIMITER //

CREATE PROCEDURE add_XMLcast(
    IN mid VARCHAR(10),
    IN star_name VARCHAR(100),
    IN sid VARCHAR(10)
    
)
BEGIN
    my_label: BEGIN
        DECLARE message VARCHAR(255);
        DECLARE star_id VARCHAR(10);
        
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
        SELECT id INTO star_id
        FROM stars
        WHERE name = star_name;

        IF star_id IS NULL THEN

            -- Insert the new star
            INSERT INTO stars (id, name)
            VALUES (sid, star_name);

            INSERT INTO stars_in_movies (starId, movieId)
            VALUES (sid, mid);
        ELSE
            INSERT INTO stars_in_movies (starId, movieId)
            VALUES (star_id, mid);
        END IF;
        
        -- Commit the transaction
        COMMIT;

        SET message = CONCAT('Movie added successfully. Movie ID: ', movie_id,  ' Genre ID: ', genre_id);
        SELECT message;
    END my_label;
END //

DELIMITER ;
COMMIT;
