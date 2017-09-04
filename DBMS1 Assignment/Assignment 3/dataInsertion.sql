/* insert dummy data in members table */
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Rahul Kumar','6 Ka 516 Shivaji Park','Alwar','M');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Vikash Kumar','6 Ka 515 Shivaji Park','Sikar','M');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Nisha Yadav','6 Ka 514 Shivaji Park','Alwar','F');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Usha Yadav','6 Ka 513 Shivaji Park','Alwar','F');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Arvind Yadav','6 Ka 513 Shivaji Park','Alwar','M');

/* insert dummy data in subjects */
INSERT INTO `subjects` (`subject_id`, `subject_nm`) VALUES(1, 'C++');
INSERT INTO `subjects` (`subject_id`, `subject_nm`) VALUES(2, 'Analog Electronics');
INSERT INTO `subjects` (`subject_id`, `subject_nm`) VALUES(3, 'India Today Mazgazine');
INSERT INTO `subjects` (`subject_id`, `subject_nm`) VALUES(4, 'Structure Planning');
INSERT INTO `subjects` (`subject_id`, `subject_nm`) VALUES(5, 'Strength of Material');

/* insert dummy data in publishers */
INSERT INTO `publishers` (`publisher_id`, `publisher_nm`) VALUES(1, 'Genius Publication');
INSERT INTO `publishers` (`publisher_id`, `publisher_nm`) VALUES(2, 'N.K. Publication');
INSERT INTO `publishers` (`publisher_id`, `publisher_nm`) VALUES(3, 'Aashirwad Publication');
INSERT INTO `publishers` (`publisher_id`, `publisher_nm`) VALUES(4, 'CBC publication');
INSERT INTO `publishers` (`publisher_id`, `publisher_nm`) VALUES(5, 'Wiley Publishing');

/* insert dummy data in authors */
INSERT INTO `authors` (`author_id`, `author_nm`) VALUES(1, 'ABRAHAM SILBERSCHATZ');
INSERT INTO `authors` (`author_id`, `author_nm`) VALUES(2, 'Neelkanth Sharma');
INSERT INTO `authors` (`author_id`, `author_nm`) VALUES(3, 'Sudesh Garg');
INSERT INTO `authors` (`author_id`, `author_nm`) VALUES(4, 'K.C. Sarangi');
INSERT INTO `authors` (`author_id`, `author_nm`) VALUES(5, 'A. A. Sinha');

/* insert dummy data in titles*/
INSERT INTO `titles` (`title_id`, `title_name`, `subject_id`,  `publisher_id`) VALUES(1, 'Object Oriented Programming with C++','1','1');
INSERT INTO `titles` (`title_id`, `title_name`, `subject_id`,  `publisher_id`) VALUES(2, 'A handbook to Analog Electronics','2','2');
INSERT INTO `titles` (`title_id`, `title_name`, `subject_id`,  `publisher_id`) VALUES(3, 'A vision to New India','3','3');
INSERT INTO `titles` (`title_id`, `title_name`, `subject_id`,  `publisher_id`) VALUES(4, 'Complete Reference to Structure Planning','4','4');
INSERT INTO `titles` (`title_id`, `title_name`, `subject_id`,  `publisher_id`) VALUES(5, 'SOM for Beginner','5','5');

/*  insert dummy data in title_author */
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(2,'1');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(3,'2');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(4,'3');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(5,'4');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(1,'5');

/* insert dummy data in books */
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('2', NOW(), '279.85', '0');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('3', NOW(), '670.50', '1');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('3', NOW(), '345.34', '0');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('4', NOW(), '124.55', '1');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('5', NOW(), '883.00', '0');

/* insert dummy data in book_issue*/
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '1', '1', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '2', '2', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '3', '3', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '4', '4', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '5', '5', NOW() + INTERVAL 15 DAY);

/* insert dummy data in book_return*/
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '1', '1', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '2', '2', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '3', '3', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '4', '4', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '5', '5', NOW());