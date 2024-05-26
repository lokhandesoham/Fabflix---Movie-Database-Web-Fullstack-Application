DELIMITER //

CREATE PROCEDURE add_XMLcast(
    IN sid VARCHAR(10),
    IN mid VARCHAR(10)
    
)
BEGIN
    my_label: BEGIN
        DECLARE message VARCHAR(255);
        
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

        

        INSERT INTO stars_in_movies (starId, movieId)
        VALUES (sid, mid);
    
        
        -- Commit the transaction
        COMMIT;

    END my_label;
END //

DELIMITER ;
COMMIT;
