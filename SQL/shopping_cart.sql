-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2017 at 04:01 PM
-- Server version: 5.5.23
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping_cart`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_item_name` varchar(50) NOT NULL,
  `cart_item_added_by` varchar(100) NOT NULL,
  `id` int(11) NOT NULL,
  `cart_item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cart_item_name`, `cart_item_added_by`, `id`, `cart_item_id`) VALUES
('Z\'TON Table Tennis Racket', 'rahul.ctae94@gmail.com', 32, 27);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_by` varchar(100) NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_by`, `order_date`, `order_total`) VALUES
(3, 'rahul.ctae94@gmail.com', '2017-10-23 08:31:40', 50400);

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `product_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `uniqueId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`product_id`, `order_id`, `uniqueId`) VALUES
(23, 3, 4),
(27, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` float(8,2) NOT NULL,
  `quantity` int(4) NOT NULL,
  `rating` float(2,1) NOT NULL,
  `seller` varchar(70) NOT NULL,
  `thumbnail` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `quantity`, `rating`, `seller`, `thumbnail`) VALUES
(22, 'Nikon D5500 DSLR Camera', 24200.00, 2, 7.7, 'Vikash Digital Store', 'https://image1.pricedekho.com/p/2/1595689/6527393-nikon-d5500-dslr-camera-with-af-s-vr-nikkor-18-140mm-f35-56g-ed-vr-lens-black-picture-big.jpg'),
(23, 'Rolex Watch', 48200.00, 9, 6.5, 'Riddhi Siddhi Watches', 'https://www.collectorsquare.com/images/products/333665/thumbmini-rolex-watch-in-stainless-steel.jpg'),
(24, 'Yamaha Speakers', 33100.00, 77, 5.9, 'Vidhata Speakers', 'https://image2.pricedekho.com/p/96/1042003/3580947-yamaha-nsf-160-laptop-speaker-black-2-channel-picture-big.jpg'),
(25, 'Shoppers Football', 3299.00, 62, 6.8, 'Prakash Sports', 'https://cdn.shopclues.com/images/thumbnails/55350/200/200/13cr71486488273.jpg'),
(27, 'Z\'TON Table Tennis Racket', 2200.00, 23, 4.4, 'EWS Retailer', 'https://ae01.alicdn.com/kf/HTB1sM2ePXXXXXbCXFXXq6xXFXXXs/zton-table-tennis-racket-bag-pingpong-racket-bag.jpg_200x200.jpg'),
(28, '4 Pc. of Plastic Bottels', 200.00, 17, 3.2, 'Priya Grossery Store', 'https://i.pinimg.com/originals/09/62/5a/09625a7f7a9b25a0bdf8868987be537a.jpg'),
(29, 'Redmi 4', 8999.00, 53, 8.1, 'Digital Mobile Shop', 'https://www.dhresource.com/200x200s/f2-albu-g5-M00-D9-D3-rBVaI1g2vkCAOE1eAAIyL1x9jpk825.jpg/4g-lte-xiaomi-redmi-4-touch-id-2gb-16gb-64.jpg'),
(30, 'Puma Blue Sneakers', 1270.00, 15, 9.0, 'Trends Fashion Hub', 'https://cdn.shopclues.com/images/thumbnails/51352/200/200/3621260311483167297.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_email` varchar(100) NOT NULL,
  `user_password` char(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_email`, `user_password`) VALUES
('rahul.ctae94@gmail.com', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `order_by` (`order_by`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`uniqueId`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `uniqueId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`order_by`) REFERENCES `users` (`user_email`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `order_detail_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
