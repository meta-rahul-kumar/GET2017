/* Change value of addressLine2 column of Members table with “Jaipur”. */
SET SQL_SAFE_UPDATES = 0;
UPDATE members SET addressLine2="Jaipur";

/* Change value of addressLine1 column of Members table with value “EPIP, Sitapura” for the members belonging to category “F”. */
UPDATE members SET addressLine1="EPIP, Sitapura" WHERE category="F";

/* Delete all the rows from Publishers table. */
DELETE FROM publishers;

/* Insert the sample data back in Publishers table using substitution variables. */
set @publisher_id = 1;
set @publisher_nm = "Genius Publication";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES(@publisher_id, @publisher_nm);

set @publisher_id = 2;
set @publisher_nm = "N.K. Publication";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES(@publisher_id, @publisher_nm);

set @publisher_id = 3;
set @publisher_nm = "Aashirwad Publication";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES(@publisher_id, @publisher_nm);

set @publisher_id = 4;
set @publisher_nm = "CBC publication";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES(@publisher_id, @publisher_nm);

set @publisher_id = 5;
set @publisher_nm = "Wiley Publishing";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES(@publisher_id, @publisher_nm);

/* Delete those rows of Titles table belonging to Publisher with publisher_id = 1 */

DELETE FROM titles WHERE publisher_id = "1";