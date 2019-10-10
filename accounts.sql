-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2019 at 05:35 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ledger`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `Company_Name` text NOT NULL,
  `Person_Name` text NOT NULL,
  `Contact_Number` text NOT NULL,
  `Invoice_Number` text NOT NULL,
  `Invoice_Date` text NOT NULL,
  `Amount` text NOT NULL,
  `Amount_Paid` text NOT NULL,
  `Due_Date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`Company_Name`, `Person_Name`, `Contact_Number`, `Invoice_Number`, `Invoice_Date`, `Amount`, `Amount_Paid`, `Due_Date`) VALUES
('Prince Stationery', 'Prince Gada', '9820364627', 'AI2001', '05-10-2019', '1000', '1000', '20-10-2019'),
('', '', '', '', '', '', '', ''),
('Arviti Infotech', 'Prince Gada', '9930338899', 'AI2002', '08-10-2019', '200', '200', '23-10-2019');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
