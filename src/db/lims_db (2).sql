-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2025 at 02:51 AM
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
-- Database: `lims_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `b_id` int(11) NOT NULL,
  `b_title` int(11) NOT NULL,
  `b_category` int(11) NOT NULL,
  `b_author` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, 0, 'null', 'User Changed Their Details', '2025-05-05 20:32:22'),
(2, 0, 'null', 'User Changed Their Details', '2025-05-05 20:33:32'),
(3, 0, 'null', 'User Changed Their Details', '2025-05-05 20:34:08'),
(4, 0, 'null', 'User Changed Their Details', '2025-05-05 20:42:31'),
(5, 0, 'null', 'User Changed Their Details', '2025-05-05 20:56:51'),
(6, 0, 'null', 'User Changed Their Details', '2025-05-05 21:21:19'),
(7, 18, 'ereneren', 'User Changed Their Details', '2025-05-05 21:28:42'),
(8, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-05 22:24:17'),
(9, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-05 22:25:41'),
(10, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-05 22:46:32'),
(11, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-05 22:49:12'),
(12, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-05 22:54:54'),
(13, 18, 'ereneren', 'Logged Out', '2025-05-05 23:29:36'),
(14, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-07 12:27:36'),
(15, 18, 'ereneren', 'User Changed Their Details', '2025-05-07 12:28:40'),
(16, 18, 'ereneren', 'Logged Out', '2025-05-07 12:28:54'),
(17, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-07 12:29:30'),
(18, 18, 'ereneren', 'Logged Out', '2025-05-07 13:05:56'),
(19, 18, 'ereneren', 'Forgot, and changed their password', '2025-05-07 13:54:44'),
(20, 23, 'louispogi', 'User Changed Their Details', '2025-05-08 00:38:47'),
(21, 23, 'louispogi', 'Logged Out', '2025-05-08 00:40:13'),
(22, 23, 'louispogi', 'Logged Out', '2025-05-08 00:44:44');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_contact` varchar(20) NOT NULL,
  `u_type` varchar(20) NOT NULL,
  `u_email` varchar(100) NOT NULL,
  `u_un` varchar(50) NOT NULL,
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
(1, 'Keycee', 'Bolambot', '09493598037', 'Librarian', 'keycee@gmail.com', 'keycre_12', 'keycre121704', 'Active', '', '', ''),
(2, 'Mizaki', 'Tadashi', '09090924838', 'Staff', 'tadashi@miz.com', 'miz.u', 'mizaki12', 'Active', '', '', ''),
(3, 'Klaire', 'Bohol', '09231571998', 'Librarian', 'klaire@gmail.com', 'klaire1', 'kl123654', 'Active', '', '', ''),
(5, 'Kc', 'Ginebra', '09896541368', 'Librarian', 'kc@gmail.com', 'kcert', '123456789kc', 'Pending', '', '', ''),
(7, 'Keyc', 'Suicossss', '09231578667', 'Staff', 'keycre@.', 'keycre', '9aFo9rfyyr62kbKuOelWN9/AW8GJF3XigQidUoCuj/w=', 'Active', '', '', ''),
(8, 'kendall', 'jenner', '09630321456', 'Staff', 'kendaljen@.', 'kendall', 'HpycOLM2iNolu3GkLOhCnL+hAI8HL1prMZH9iEYzJao=', 'Pending', '', '', ''),
(9, 'Kice', 'Suico', '09564335485', 'Staff', 'kc@scc.', 'kice12', '4Afu6FJD21v6rHVsaWwOq7YtREsNkL32D+gNBq1189Q=', 'Active', '', '', ''),
(10, 'Jonash', 'Nogra', '09090923657', 'Staff', 'nashu@.', 'nashu12', 'zg50Xq1SXnqstID8+QJbWbCPUgVqhImnIR2TnD7yGoA=', 'Active', '', '', ''),
(12, 'Keyc', 'Suico', '09236587496', 'Librarian', 'keyc@scc.com', 'keyc17', 'aOr76G6f5q3mIOBaqDXw+NhgROJ3+xyIHcUJwfTwvpw=', 'Active', '', '', ''),
(13, 'John', 'Mega', '09231571889', 'Librarian', 'jon@mga.ph', 'johnmeg', 'SfGKjUf3bDhe1/mdop6ZtX2J/egKSoPpUBfttOZSOX8=', 'Active', '', '', ''),
(14, 'Keycee', 'Suicoo', '09231571887', 'Staff', 'suico@gmail.com', 'suicokc', 'zTECqWY3FduxLU6AMawI9awxD4Rm1mqbz/brOo2rRaU=', 'Active', '', '', ''),
(16, 'Ken', 'Chan', '09231571887', 'Librarian', 'chan@gmail.com', 'chanuu', 'LINbqJZtkCEg+0UEA3+tNO/6S5Rh6YjkxNoHOtUNroI=', 'Active', '', '', ''),
(17, 'Tanjiro', 'Kamado', '09235874695', 'Librarian', 'demontan@gmail.com', 'tanjirok', '2qrW5WBOjhe9nxCNkeJq/mKB2sj9oAkQQKem172bQ7U=', 'Pending', '', '', ''),
(18, 'Eren', 'Yeager', '09090909143', 'Librarian', 'eren@aot.com', 'ereneren', 'FWAfcn7hOcLO1oz/Ault5hLH3IWHQgzGjHqXoBRlJBw=', 'Active', 'What is your nickname?', 'eren', ''),
(19, 'Ane', 'Marga', '09148657893', 'Librarian', 'cgaret@gmaik.com', 'cgaret', 'qweasdzxc', 'Active', 'secq', 'ans', ''),
(21, 'Mikasa', 'Yeager', '09090924838', 'Librarian', 'mika@aot.com', 'mikasa', 'erenlove', 'Active', '', '', ''),
(22, 'Kento', 'Yamazaki', '09042319714', 'Librarian', 'kento@gmail.com', 'kento', 'URhsOEbsuC7AuGg4ftIcZieg0pot9Sc78Exht00tuJ8=', 'Active', '', '', 'src/userimages/kento.jpg'),
(23, 'Louis', 'Tewkesbury', '09789654123', 'Staff', 'louis@.com', 'louispogi', 'bi9ICns+wxqU9XcDY0Fp8f/7BRsFgdexj5SvZVgMB1Y=', 'Active', 'What is your nickname?', 'iloveolivia', 'src/userimages/louis.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
