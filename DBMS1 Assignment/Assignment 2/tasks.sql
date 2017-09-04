/* shows all the table in lis database*/
SHOW TABLES;

/* Alter definitions of following LIS tables to provide the default constraints: set default value of issue_dat to Current Timestamp  */
ALTER TABLE book_issue
MODIFY COLUMN issue_dt  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

/*
SELECT TIMESTAMPADD(DAY,15,NOW());

ALTER TABLE book_issue
MODIFY COLUMN due_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

SELECT SUM(NOW()+1296000);

SELECT DATE_ADD(NOW(),INTERVAL +15 DAY);

ALTER TABLE book_issue 
ADD CONSTRAINT col_b_def  
DEFAULT DATE_ADD(NOW(),INTERVAL +15 DAY) FOR due_dt ;
*/

CREATE TRIGGER ins_update_end
     BEFORE INSERT ON book_issue
     FOR EACH ROW SET NEW.`due_date` = NOW() + INTERVAL 15 DAY;
     


/* Write a command to remove Members table of the LIS database. */
SET @@foreign_key_checks = 0;
DROP TABLE members;
SET @@foreign_key_checks = 1;