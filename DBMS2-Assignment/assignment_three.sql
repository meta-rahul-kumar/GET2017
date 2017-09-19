CREATE DATABASE eCommerce;

USE eCommerce;

CREATE TABLE IF NOT EXISTS Product_Categories(
    cat_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(30) NOT NULL,
    cat_parent_id INT NULL,
    FOREIGN KEY (cat_parent_id) REFERENCES Product_Categories(cat_id)
);

INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (1, 'Mobiles & Tablets', NULL);
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (2, 'Mobiles', '1');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (3, 'Smart Phones', '2');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (4, 'Featured Phones', '2');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (5, 'Tablets', '1');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (6, '2G', '5');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (7, '3G', '5');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (8, 'Accessories', '1');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (9, 'Cases & Covers', '1');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (10, 'Computers', NULL);
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (11, 'Desktop', '10');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (12, 'Laptop', '10');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (13, 'Laptop Accessories', '10');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (14, 'Keyboard', '13');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (15, 'Mouse', '13');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (16, 'Headphones', '13');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (17, 'Printers', '10');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (18, 'Inkjet', '17');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (19, 'Laser', '17');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (20, 'Home Appliances', NULL);
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (21, 'TVs', '20');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (22, 'LED', '21');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (23, 'LCD', '21');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (24, 'Plasma', '21');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (25, 'Air Conditioners', '20');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (26, 'Washing Machines', '20');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (27, 'Full Automatic', '26');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (28, 'Top Load', '27');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (29, 'Front Load', '27');
INSERT INTO `product_categories` (`cat_id`, `cat_name`, `cat_parent_id`) VALUES (30, 'Semi Automatic', '26');

/* 2. display all categories with their parent category. */
SELECT C1.cat_id AS "Category ID", C1.cat_name AS "Category Name" , IFNULL(C2.cat_name,"TOP CATEGORY") AS "Parent Category"
FROM product_categories AS C1
LEFT JOIN product_categories AS C2 ON C1.cat_parent_id = C2.cat_id
ORDER BY C2.cat_name ASC;

/* 3. display onlt TOP Categories*/
SELECT C1.cat_id AS "Category ID", C1.cat_name AS "Category Name" , IFNULL(C2.cat_name,"TOP CATEGORY") AS "Parent Category"
FROM product_categories AS C1
LEFT JOIN product_categories AS C2 ON C1.cat_parent_id = C2.cat_id
WHERE C1.cat_parent_id IS NULL;



       
       
    
/*INNER JOIN product_categories AS C2 ON C2.cat_parent_id = C1.cat_id; */

