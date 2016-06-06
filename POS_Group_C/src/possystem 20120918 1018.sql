-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema possystem
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ possystem;
USE possystem;

--
-- Table structure for table `possystem`.`association`
--

DROP TABLE IF EXISTS `association`;
CREATE TABLE `association` (
  `invoice_id` int(10) unsigned NOT NULL default '0',
  `item_id` varchar(45) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`association`
--

/*!40000 ALTER TABLE `association` DISABLE KEYS */;
INSERT INTO `association` (`invoice_id`,`item_id`) VALUES 
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1002'),
 (0,'i1002'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (0,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002');
INSERT INTO `association` (`invoice_id`,`item_id`) VALUES 
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (0,'i1001'),
 (0,'i1002'),
 (0,'i1001'),
 (0,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (0,'i1001'),
 (0,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1002'),
 (1,'i1002'),
 (1,'i1001'),
 (1,'i1001'),
 (1,'i1002');
/*!40000 ALTER TABLE `association` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`complementaryitems`
--

DROP TABLE IF EXISTS `complementaryitems`;
CREATE TABLE `complementaryitems` (
  `base_item_id` varchar(10) NOT NULL default '',
  `comlementary_item_id` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`base_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`complementaryitems`
--

/*!40000 ALTER TABLE `complementaryitems` DISABLE KEYS */;
INSERT INTO `complementaryitems` (`base_item_id`,`comlementary_item_id`) VALUES 
 ('i1001','i1006'),
 ('i1002','i1007');
/*!40000 ALTER TABLE `complementaryitems` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`discountscheme`
--

DROP TABLE IF EXISTS `discountscheme`;
CREATE TABLE `discountscheme` (
  `discount_type` int(10) unsigned NOT NULL default '0',
  `enroll_date` datetime NOT NULL default '2012-09-06 00:00:00',
  `expiry_date` datetime NOT NULL default '0000-00-00 00:00:00',
  `discount_name` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`discount_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`discountscheme`
--

/*!40000 ALTER TABLE `discountscheme` DISABLE KEYS */;
INSERT INTO `discountscheme` (`discount_type`,`enroll_date`,`expiry_date`,`discount_name`) VALUES 
 (1,'2012-09-10 00:00:00','2013-08-10 00:00:00','Get 20% off on Item'),
 (2,'2012-09-10 00:00:00','2013-08-10 00:00:00','Get 30% off on similar Item'),
 (3,'2012-08-10 00:00:00','2013-08-10 00:00:00','Buy One get One free'),
 (4,'2012-08-10 00:00:00','2013-08-10 00:00:00','Buy two get one free'),
 (5,'2012-08-10 00:00:00','2013-08-10 00:00:00','Buy One get 25% off  on another Item'),
 (6,'2012-09-10 00:00:00','2013-08-10 00:00:00','Buy One get another Item free');
/*!40000 ALTER TABLE `discountscheme` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `invoice_id` int(10) unsigned NOT NULL auto_increment,
  `total_amount` double unsigned NOT NULL default '0',
  `date` datetime NOT NULL,
  PRIMARY KEY  (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`invoice`
--

/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` (`invoice_id`,`total_amount`,`date`) VALUES 
 (1,3583.552,'2012-09-17 00:00:00'),
 (2,3583.552,'2012-09-17 00:00:00'),
 (3,3583.552,'2012-09-17 00:00:00'),
 (4,3583.552,'2012-09-17 00:00:00'),
 (5,10750.656,'2012-09-17 00:00:00'),
 (6,3583.552,'2012-09-17 00:00:00'),
 (7,3583.552,'2012-09-17 00:00:00'),
 (8,3583.552,'2012-09-17 00:00:00'),
 (9,3583.552,'2012-09-17 00:00:00'),
 (10,3582.432,'2012-09-17 00:00:00'),
 (11,3582.432,'2012-09-17 00:00:00'),
 (12,3582.432,'2012-09-17 00:00:00'),
 (13,3582.432,'2012-09-17 00:00:00'),
 (14,3582.432,'2012-09-17 00:00:00'),
 (15,3582.432,'2012-09-17 00:00:00'),
 (16,3582.432,'2012-09-17 00:00:00'),
 (17,3582.432,'2012-09-17 00:00:00'),
 (18,3582.432,'2012-09-17 00:00:00'),
 (19,3582.432,'2012-09-17 00:00:00'),
 (20,3582.432,'2012-09-17 00:00:00'),
 (21,3582.432,'2012-09-17 00:00:00'),
 (22,8286.432,'2012-09-17 00:00:00'),
 (23,11557.952,'2012-09-17 00:00:00'),
 (24,11557.952,'2012-09-17 00:00:00'),
 (25,8276.352,'2012-09-17 00:00:00'),
 (26,11569.152,'2012-09-17 00:00:00');
INSERT INTO `invoice` (`invoice_id`,`total_amount`,`date`) VALUES 
 (27,8276.352,'2012-09-17 00:00:00'),
 (28,8276.352,'2012-09-17 00:00:00'),
 (29,11569.152,'2012-09-17 00:00:00'),
 (30,11569.152,'2012-09-17 00:00:00'),
 (31,11569.152,'2012-09-17 00:00:00'),
 (32,11580.352,'2012-09-17 00:00:00'),
 (33,8287.552,'2012-09-17 00:00:00'),
 (34,8287.552,'2012-09-17 00:00:00'),
 (35,8287.552,'2012-09-17 00:00:00'),
 (36,0,'2012-09-17 00:00:00'),
 (37,0,'2012-09-17 00:00:00'),
 (38,0,'2012-09-17 00:00:00'),
 (39,0,'2012-09-17 00:00:00'),
 (40,0,'2012-09-17 00:00:00'),
 (41,0,'2012-09-17 00:00:00'),
 (42,0,'2012-09-17 00:00:00'),
 (43,0,'2012-09-17 00:00:00'),
 (44,8287.552,'2012-09-17 00:00:00'),
 (45,15141.504,'2012-09-17 00:00:00'),
 (46,8287.552,'2012-09-17 00:00:00');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` varchar(15) NOT NULL default '',
  `item_name` varchar(45) NOT NULL default '',
  `unit_price` double unsigned NOT NULL default '0',
  `discount_type` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_id`,`item_name`,`unit_price`,`discount_type`) VALUES 
 ('i1001','Nokia',3999.5,1),
 ('i1002','Samsung',4200,2);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`loyaltycard`
--

DROP TABLE IF EXISTS `loyaltycard`;
CREATE TABLE `loyaltycard` (
  `loyaltycard_id` int(10) unsigned NOT NULL default '0',
  `loyalty_points` int(10) unsigned NOT NULL default '0',
  `enroll_date` datetime NOT NULL default '2012-09-06 00:00:00',
  `expiry_date` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`loyaltycard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`loyaltycard`
--

/*!40000 ALTER TABLE `loyaltycard` DISABLE KEYS */;
INSERT INTO `loyaltycard` (`loyaltycard_id`,`loyalty_points`,`enroll_date`,`expiry_date`) VALUES 
 (11,782,'2012-09-06 00:00:00','2014-09-05 00:00:00'),
 (12,1000,'2012-09-06 00:00:00','2014-09-05 00:00:00');
/*!40000 ALTER TABLE `loyaltycard` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`loyaltycardholder`
--

DROP TABLE IF EXISTS `loyaltycardholder`;
CREATE TABLE `loyaltycardholder` (
  `cardholder_id` int(10) unsigned NOT NULL default '0',
  `cardholder_name` varchar(45) NOT NULL default '',
  `mobile_no` varchar(15) NOT NULL default '',
  `email_id` varchar(45) NOT NULL default '',
  `loyaltycard_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`cardholder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`loyaltycardholder`
--

/*!40000 ALTER TABLE `loyaltycardholder` DISABLE KEYS */;
INSERT INTO `loyaltycardholder` (`cardholder_id`,`cardholder_name`,`mobile_no`,`email_id`,`loyaltycard_id`) VALUES 
 (1,'Kumar Jivi','9015773177','guptaankit617@gmail.com',12);
/*!40000 ALTER TABLE `loyaltycardholder` ENABLE KEYS */;


--
-- Table structure for table `possystem`.`salesman`
--

DROP TABLE IF EXISTS `salesman`;
CREATE TABLE `salesman` (
  `login_id` varchar(25) NOT NULL default '',
  `password` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possystem`.`salesman`
--

/*!40000 ALTER TABLE `salesman` DISABLE KEYS */;
INSERT INTO `salesman` (`login_id`,`password`) VALUES 
 ('ankitgupta','shubhiankitg'),
 ('kumarjivi','sopra124#'),
 ('sheaggarwal','sopra123#');
/*!40000 ALTER TABLE `salesman` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
