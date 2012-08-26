-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 26, 2012 at 10:00 
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rentaldvd`
--

-- --------------------------------------------------------

--
-- Table structure for table `dettrans`
--

CREATE TABLE IF NOT EXISTS `dettrans` (
  `INDEXTRANS` varchar(20) NOT NULL,
  `NMRTRANS` varchar(20) DEFAULT NULL,
  `NODETAIL` int(11) DEFAULT NULL,
  `KODEPEG` varchar(20) DEFAULT NULL,
  `KODEDVD` varchar(20) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `JMLKEMBALI` int(11) DEFAULT NULL,
  `HARUSKBL` date DEFAULT NULL,
  `TGLKEMBALI` date DEFAULT NULL,
  `DENDA` int(11) DEFAULT NULL,
  `DVDSTAT` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`INDEXTRANS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dettrans`
--

INSERT INTO `dettrans` (`INDEXTRANS`, `NMRTRANS`, `NODETAIL`, `KODEPEG`, `KODEDVD`, `JUMLAH`, `JMLKEMBALI`, `HARUSKBL`, `TGLKEMBALI`, `DENDA`, `DVDSTAT`) VALUES
('2012000002001', '2012000002', 1, NULL, 'H00001', 1, 1, '2012-08-25', NULL, 0, 'Borrowed'),
('2012000003001', '2012000003', 1, 'APB', 'H00001', 1, 0, '2012-08-25', '2012-08-26', 2000, 'Returned'),
('2012000003002', '2012000003', 2, '', 'W00001', 1, 0, '2012-08-25', '2012-08-26', 2000, 'Returned'),
('2012000004001', '2012000004', 1, NULL, 'W00001', 1, 1, '2012-08-26', NULL, 0, 'Borrowed'),
('2012000004002', '2012000004', 2, NULL, 'F00001', 1, 1, '2012-08-26', NULL, 0, 'Borrowed'),
('2012000005001', '2012000005', 1, NULL, 'H00003', 1, 1, '2012-08-26', NULL, 0, 'Borrowed');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE IF NOT EXISTS `dvd` (
  `KODEDVD` varchar(15) NOT NULL,
  `JUDUL` varchar(50) DEFAULT NULL,
  `DVDDATE` date DEFAULT NULL,
  `GENRE` varchar(20) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `SEWA` int(11) DEFAULT NULL,
  `STOK` int(11) DEFAULT NULL,
  PRIMARY KEY (`KODEDVD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`KODEDVD`, `JUDUL`, `DVDDATE`, `GENRE`, `STATUS`, `SEWA`, `STOK`) VALUES
('E00001', 'Endless Love', '2012-08-14', 'Korea', 'New Release', 1500, 1),
('R00001', 'Real Steel', '2012-08-16', 'Action', 'New Release', 2000, 1),
('H00001', 'Hunger Games', '2012-08-16', 'Action', 'New Release', 1500, 3),
('T00001', 'Titanic', '2012-08-16', 'Drama', 'Standard', 1500, 2),
('H00002', 'Hugo', '2012-08-17', 'Fantasy', 'New Release', 2000, 2),
('H00003', 'Harry Potter 7 - Deathly Hallow part 1', '2012-08-17', 'Fantasy', 'Standard', 2000, 1),
('F00001', 'Final Destination 5', '2012-08-17', 'Horor', 'Standard', 2000, 2),
('W00001', 'Wanted', '2012-08-23', 'Action', 'New Release', 1500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `general`
--

CREATE TABLE IF NOT EXISTS `general` (
  `STATUS` varchar(20) NOT NULL,
  `LAMAPINJAM` int(11) NOT NULL,
  `DENDA` int(11) NOT NULL,
  PRIMARY KEY (`STATUS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `general`
--

INSERT INTO `general` (`STATUS`, `LAMAPINJAM`, `DENDA`) VALUES
('New Release', 1, 2000),
('Standard', 3, 1500);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `NMRLOG` int(11) NOT NULL AUTO_INCREMENT,
  `KODEPEG` varchar(15) DEFAULT NULL,
  `LASTLOG` datetime DEFAULT NULL,
  `LASTOUT` datetime DEFAULT NULL,
  PRIMARY KEY (`NMRLOG`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`NMRLOG`, `KODEPEG`, `LASTLOG`, `LASTOUT`) VALUES
(38, 'apb', '2012-08-24 23:57:13', '2012-08-24 23:57:25'),
(37, 'apb', '2012-08-24 23:38:24', '2012-08-24 23:38:28'),
(36, 'apb', '2012-08-24 23:35:07', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `KODEMEM` varchar(20) NOT NULL,
  `NAMAMEM` varchar(20) DEFAULT NULL,
  `ALAMATMEM` varchar(50) DEFAULT NULL,
  `TELPMEM` varchar(13) DEFAULT NULL,
  `JK` enum('L','P') DEFAULT NULL,
  `DATEMEM` date DEFAULT NULL,
  PRIMARY KEY (`KODEMEM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`KODEMEM`, `NAMAMEM`, `ALAMATMEM`, `TELPMEM`, `JK`, `DATEMEM`) VALUES
('A00001', 'Ade Putra Habibi', 'Jl. Bratang Binangun', '085736217629', 'L', '2012-08-16'),
('B00001', 'Bayu Pamungkas', 'Jl. Darmo', NULL, 'L', '2012-08-16'),
('A00002', 'Alfian Prasetyo', 'Jl. Dukuh Kupang', NULL, 'L', '2012-08-14'),
('F00001', 'Fatony Sidiq', 'Jl. Diponegoro', '083857165181', 'L', '2012-08-16'),
('A00003', 'Aldila Efrilyana', 'Jl. Sumatera', '081515171801', 'P', '2012-08-16'),
('B00002', 'Bayu Prasetyo', 'Jl. Perak Timur', '083857165181', 'L', '2012-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `KODEPEG` varchar(15) NOT NULL,
  `NAMAPEG` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `ALAMATPEG` varchar(50) DEFAULT NULL,
  `TELPPEG` varchar(13) DEFAULT NULL,
  `JKPEG` enum('L','P') DEFAULT NULL,
  `DATEPEG` date DEFAULT NULL,
  `LEVEL` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`KODEPEG`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`KODEPEG`, `NAMAPEG`, `PASSWORD`, `ALAMATPEG`, `TELPPEG`, `JKPEG`, `DATEPEG`, `LEVEL`) VALUES
('APB', 'Ade Putra Habibi', '81dc9bdb52d04dc20036dbd8313ed055', 'Jl. Bratang binangun', '085736217629', 'L', '2012-08-17', 'Admin'),
('FAS', 'Fadmanova Anantasean', '1234', 'Jl. Ketintang', '', 'P', '2012-08-17', 'Petugas'),
('GYS', 'Galih Yuli Saputro', '81dc9bdb52d04dc20036dbd8313ed055', 'Jl. Dukuh Pakis', '', 'L', '2012-08-17', 'Petugas'),
('RPS', 'Riska Puspita Sari', '110690', 'Jl Rajawali 5 Rewwin Waru', '085730749993', 'P', '2012-08-27', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `NMRTRANS` varchar(11) NOT NULL,
  `KODEPEG` varchar(15) DEFAULT NULL,
  `KODEMEM` varchar(15) DEFAULT NULL,
  `DATETRANS` date DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`NMRTRANS`),
  KEY `FK_RELATIONSHIP_1` (`KODEPEG`),
  KEY `FK_RELATIONSHIP_2` (`KODEMEM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`NMRTRANS`, `KODEPEG`, `KODEMEM`, `DATETRANS`, `TOTAL`) VALUES
('2012000005', 'APB', 'A00003', '2012-08-25', 2000),
('2012000004', 'APB', 'B00001', '2012-08-25', 1500),
('2012000003', 'APB', 'F00001', '2012-08-24', 3000),
('2012000002', 'APB', 'A00001', '2012-08-24', 1500),
('2012000001', 'APB', 'A00001', '2012-08-24', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
