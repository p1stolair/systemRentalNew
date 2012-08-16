-- phpMyAdmin SQL Dump
-- version 3.1.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 16, 2012 at 05:40 PM
-- Server version: 5.1.30
-- PHP Version: 5.2.8

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
-- Table structure for table `denda`
--

CREATE TABLE IF NOT EXISTS `denda` (
  `nomor` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  `lamapinjam` int(11) NOT NULL,
  `denda` int(11) NOT NULL,
  PRIMARY KEY (`nomor`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `denda`
--

INSERT INTO `denda` (`nomor`, `status`, `lamapinjam`, `denda`) VALUES
(1, 'New Release', 1, 1000),
(2, 'Standard', 3, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `dettrans`
--

CREATE TABLE IF NOT EXISTS `dettrans` (
  `NODETAIL` int(11) NOT NULL,
  `NMRTRANS` int(11) DEFAULT NULL,
  `KODEDVD` varchar(15) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `HARUSKBL` date DEFAULT NULL,
  `TGLKEMBALI` date DEFAULT NULL,
  `DENDA` int(11) DEFAULT NULL,
  `DVDSTAT` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`NODETAIL`),
  KEY `FK_RELATIONSHIP_3` (`KODEDVD`),
  KEY `FK_RELATIONSHIP_4` (`NMRTRANS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dettrans`
--


-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE IF NOT EXISTS `dvd` (
  `KODEDVD` int(15) NOT NULL AUTO_INCREMENT,
  `JUDUL` varchar(20) DEFAULT NULL,
  `DVDDATE` date DEFAULT NULL,
  `GENRE` varchar(20) NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  `STOK` int(11) DEFAULT NULL,
  PRIMARY KEY (`KODEDVD`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`KODEDVD`, `JUDUL`, `DVDDATE`, `GENRE`, `STATUS`, `STOK`) VALUES
(1, 'Endless Love', '2012-08-14', 'Korea', 'New Release', 1),
(3, 'Real Steel', '2012-08-16', 'Action', 'New Release', 1),
(2, 'Hunger Games', '2012-08-16', 'Action', 'New Release', 3),
(4, 'Titanic', '2012-08-16', 'Drama', 'Standard', 2);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `nmrlog` int(11) NOT NULL AUTO_INCREMENT,
  `kodepeg` varchar(15) DEFAULT NULL,
  `lastlog` datetime DEFAULT NULL,
  `lastout` datetime DEFAULT NULL,
  PRIMARY KEY (`nmrlog`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `login`
--


-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `KODEMEM` varchar(20) NOT NULL,
  `CHARMEM` varchar(20) NOT NULL,
  `NOMEM` int(11) NOT NULL,
  `NAMAMEM` varchar(20) DEFAULT NULL,
  `ALAMATMEM` varchar(50) DEFAULT NULL,
  `TELPMEM` varchar(13) DEFAULT NULL,
  `JK` enum('L','P') NOT NULL,
  `DATEMEM` date DEFAULT NULL,
  PRIMARY KEY (`KODEMEM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`KODEMEM`, `CHARMEM`, `NOMEM`, `NAMAMEM`, `ALAMATMEM`, `TELPMEM`, `JK`, `DATEMEM`) VALUES
('A00001', 'A', 1, 'Ade Putra Habibi', 'Jl. Bratang Binangun', '085736217629', 'L', '2012-08-16'),
('B00001', 'B', 1, 'Bayu Pamungkas', 'Jl. Darmo', NULL, 'L', '2012-08-16'),
('A00002', 'A', 2, 'Alfian Prasetyo', 'Jl. Dukuh Kupang', NULL, 'L', '2012-08-14'),
('F00001', 'F', 1, 'Fatony Sidiq', 'Jl. Diponegoro', '083857165181', 'L', '2012-08-16'),
('A00003', 'A', 3, 'Aldila Efrilyana', 'Jl. Sumatera', '081515171801', 'P', '2012-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `KODEPEG` varchar(15) NOT NULL,
  `NAMAPEG` varchar(20) DEFAULT NULL,
  `ALAMATPEG` varchar(50) DEFAULT NULL,
  `TELPPEG` varchar(13) DEFAULT NULL,
  `LEVEL` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`KODEPEG`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--


-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `NMRTRANS` int(11) NOT NULL,
  `KODEPEG` varchar(15) DEFAULT NULL,
  `KODEMEM` varchar(15) DEFAULT NULL,
  `DATETRANS` datetime DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL,
  `BAYAR` int(11) DEFAULT NULL,
  `KEMBALI` int(11) DEFAULT NULL,
  PRIMARY KEY (`NMRTRANS`),
  KEY `FK_RELATIONSHIP_1` (`KODEPEG`),
  KEY `FK_RELATIONSHIP_2` (`KODEMEM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

