CREATE DATABASE shopping_cart;
USE shopping_cart;

CREATE TABLE IF NOT EXISTS products(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price FLOAT(6,2) NOT NULL,
    quantity INT(4) NOT NULL,
    rating FLOAT(1,1) NOT NULL,
    seller VARCHAR(70) NOT NULL,
    thumbnail VARCHAR(200) NOT NULL
);

INSERT INTO `products` (`name`, `price`, `quantity`, `rating`, `seller`, `thumbnail`) VALUES
('Yonex Badminton', '320', '27', '5', 'Gaurav Sports', 'https://images-na.ssl-images-amazon.com/images/I/415QcJHqk8L._SY355_.jpg'),
('Nikon D5500 DSLR Camera', '24200', '2', '7.7', 'Vikash Digital Store', 'https://image1.pricedekho.com/p/2/1595689/6527393-nikon-d5500-dslr-camera-with-af-s-vr-nikkor-18-140mm-f35-56g-ed-vr-lens-black-picture-big.jpg'),
('Rolex Watch', '48200', '9', '6.5', 'Riddhi Siddhi Watches', 'https://www.collectorsquare.com/images/products/333665/thumbmini-rolex-watch-in-stainless-steel.jpg'),
('Yamaha Speakers', '33100', '77', '5.9', 'Vidhata Speakers', 'https://image2.pricedekho.com/p/96/1042003/3580947-yamaha-nsf-160-laptop-speaker-black-2-channel-picture-big.jpg'),
('Shoppers Football', '3299', '62', '6.8', 'Prakash Sports', 'https://cdn.shopclues.com/images/thumbnails/55350/200/200/13cr71486488273.jpg'),
('Dell S2240T Monitor', '10700', '4', '9.2', 'The Monitor Shop', 'http://images.buyingiq.com/p/109/1608963/3898776-dell-215-inch-touchscreen-monitor-picture-big.jpg'), 
('Z\'TON Table Tennis Racket', '2200', '23', '4.4', 'EWS Retailer', 'https://ae01.alicdn.com/kf/HTB1sM2ePXXXXXbCXFXXq6xXFXXXs/zton-table-tennis-racket-bag-pingpong-racket-bag.jpg_200x200.jpg'),
('4 Pc. of Plastic Bottels', '200', '17', '3.2', 'Priya Grossery Store', 'https://i.pinimg.com/originals/09/62/5a/09625a7f7a9b25a0bdf8868987be537a.jpg'),
('Redmi 4', '8999', '53', '8.1', 'Digital Mobile Shop', 'https://www.dhresource.com/200x200s/f2-albu-g5-M00-D9-D3-rBVaI1g2vkCAOE1eAAIyL1x9jpk825.jpg/4g-lte-xiaomi-redmi-4-touch-id-2gb-16gb-64.jpg'),
('Puma Blue Sneakers', '1270', '15', '9.0', 'Trends Fashion Hub', 'https://cdn.shopclues.com/images/thumbnails/51352/200/200/3621260311483167297.jpg');