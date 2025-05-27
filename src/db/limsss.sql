-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 09:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `limsss`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `b_id` int(11) NOT NULL,
  `b_isbn` varchar(20) NOT NULL,
  `b_title` varchar(255) NOT NULL,
  `b_category` varchar(255) NOT NULL,
  `b_author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `b_status` varchar(50) NOT NULL,
  `b_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`b_id`, `b_isbn`, `b_title`, `b_category`, `b_author`, `publisher`, `b_status`, `b_image`) VALUES
(9, '1236987452', 'Dome', 'Sci-Fiction', 'Anna', 'Donaa', 'APPROVED', ''),
(10, '7896541023', 'Alice in Wonderland', 'Mystery', 'Ken', 'Chan', 'APPROVED', 'src/bookimages/ain.jpg'),
(11, '4563219870', 'The Chronicles', 'Sci-fiction', 'Damian', 'Acrobat', 'APPROVED', ''),
(12, '4563218907', 'Mutya', 'Romance', 'Lara Jane', 'Wattpad', 'APPROVED', ''),
(13, '5698724130', 'Harry Potter', 'Mystery', 'Leonard The Great', 'HollyInc', 'APPROVED', ''),
(14, '5412369870', 'The Shining', 'Horror', 'Stephen Curry', 'Ace', 'APPROVED', ''),
(15, '0093658846', 'The King of Kings', 'History', 'Lauren Cohen', 'Glenn', 'APPROVED', ''),
(16, '7456983215', 'The Walking Dead', 'Survival', 'Rick Grimes', 'Carl Michonne', 'APPROVED', 'src/bookimages/twd.jpg'),
(18, '0989746268', 'The Witch', 'Horror', 'Karen Williams', 'A.X Company', 'PENDING', 'src/bookimages/thewitch.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `i_id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL,
  `quantity` varchar(255) NOT NULL,
  `borrowed` varchar(255) NOT NULL,
  `damaged` varchar(255) NOT NULL,
  `lost` varchar(255) NOT NULL,
  `available` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`i_id`, `b_id`, `quantity`, `borrowed`, `damaged`, `lost`, `available`) VALUES
(1, 13, '800', '150', '250', '100', '300'),
(2, 15, '900', '250', '111', '30', '539');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_un` varchar(50) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `u_un`, `log_action`, `log_time`) VALUES
(1, 1, 'keycre12', 'User Changed Their Details', '2025-05-22 04:26:20'),
(2, 2, 'miz.u', 'User Changed Their Details', '2025-05-22 06:00:50'),
(3, 2, 'miz.u', 'Logged Out', '2025-05-22 06:02:16'),
(4, 2, 'miz.u', 'Logged Out', '2025-05-22 06:08:01'),
(5, 1, 'keycre12', 'Logged Out', '2025-05-22 06:27:43'),
(6, 1, 'keycre12', 'Logged Out', '2025-05-22 06:42:11');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(255) NOT NULL,
  `u_contact` varchar(50) NOT NULL,
  `u_type` varchar(20) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_un` varchar(100) NOT NULL,
  `u_pass` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL,
  `sec_ques` varchar(255) NOT NULL,
  `sec_ans` varchar(255) NOT NULL,
  `u_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `u_fname`, `u_lname`, `u_contact`, `u_type`, `u_email`, `u_un`, `u_pass`, `status`, `sec_ques`, `sec_ans`, `u_image`) VALUES
(1, 'Keycee', 'Bolambot', '09493598037', 'Librarian', 'kc@gmail.com', 'keycre12', 'Vxn55QQ0uCgZTvkGeS2RaL8yZxyWj2MhIm/j5WHqX+A=', 'Active', 'What is your nickname?', 'kc', 'src/userimages/kento.jpg'),
(2, 'Mizaki', 'Tadash', '09090924838', 'Staff', 'mizaki@gmail.com', 'miz.u', 'hf18iJ9xzxBTdVlc3cBrnTj8Viy2nFT4wWWqdR2Bs9k=', 'Active', 'What is your nickname?', 'mizaki', 'src/userimages/louis.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`i_id`),
  ADD KEY `b_id` (`b_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `books` (`b_id`);

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
