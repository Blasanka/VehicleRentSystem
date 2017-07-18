-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2017 at 02:09 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customerdetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cNo` int(3) NOT NULL,
  `IDno` varchar(10) NOT NULL,
  `cname` varchar(30) NOT NULL,
  `caddress` varchar(50) NOT NULL,
  `cphoneNo` varchar(10) NOT NULL,
  `cemail` varchar(10) NOT NULL,
  `dlicenceNo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cNo`, `IDno`, `cname`, `caddress`, `cphoneNo`, `cemail`, `dlicenceNo`) VALUES
(6, '1452668v', 'lkh', 'sri lanka', 'sri ww', 'jj452', '0772356'),
(8, '12453687v', 'visma', 'badulla', '0719438656', 'vismaww', '78421hh'),
(9, '12453687v', 'visma', 'badulla', '0719438656', 'vismaww', 'ggsfgd'),
(11, '785666v', 'amal', 'colombo', '07755689', 'amalww', '78787ww'),
(12, '785666v', 'kamal', 'colombo', '07755689', 'kamalww', '787187ww'),
(13, '12453687v', 'visma', 'badulla', '0719438656', 'gmail.ocm', 'gsdsd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cNo` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
