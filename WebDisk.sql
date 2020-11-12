/*
Navicat MySQL Data Transfer

Source Server         : 57
Source Server Version : 50644
Source Host           : 123.57.59.57:3306      /*IP address*/
Source Database       : WebDisk		/*Name of database*/

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-11-09 18:42:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Billing_Address
-- ----------------------------
DROP TABLE IF EXISTS `Billing_Address`;		/*Create this table, if it's not exist*/
CREATE TABLE `Billing_Address` (
  `FullName` varchar(50) DEFAULT NULL,		
  `Email` varchar(50) DEFAULT NULL,		
  `Address` varchar(50) DEFAULT NULL,		
  `City` varchar(50) DEFAULT NULL,		
  `State` varchar(50) DEFAULT NULL,		
  `Zip` varchar(50) DEFAULT NULL		
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Billing_Address
-- ----------------------------			
INSERT INTO `Billing_Address` VALUES ('jack', '48365984@qq.com', 'China', 'Anhui', 'hua', '15');
INSERT INTO `Billing_Address` VALUES ('mack', '15465484@163.com', 'China', 'Zhejiang', 'link', '75');

-- ----------------------------
-- Table structure for Contact_Details
-- ----------------------------
DROP TABLE IF EXISTS `Contact_Details`;   	
CREATE TABLE `Contact_Details` (
  `CountryCode` varchar(100) DEFAULT NULL,	
  `Telephone` int(11) DEFAULT NULL,		
  `EmailAddress` varchar(25) DEFAULT NULL,	
  `IsWantCustomMadeEmail` tinyint(1) DEFAULT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Contact_Details
-- ----------------------------
INSERT INTO `Contact_Details` VALUES ('44', '1768135478', '2457451@qq.com', '1');
INSERT INTO `Contact_Details` VALUES ('37', '1974578546', '174598955@163.com', '1');

-- ----------------------------
-- Table structure for Country
-- ----------------------------
DROP TABLE IF EXISTS `Country`;		/*Create this table, if it's not exist*/
CREATE TABLE `Country` (			/*Create a field to store the names of all countries*/
  `Country` varchar(80) NOT NULL,
  PRIMARY KEY (`Country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Country
-- ----------------------------			/*Insertion*/
INSERT INTO `Country` VALUES ('ABC');
INSERT INTO `Country` VALUES ('Afghanistan');
INSERT INTO `Country` VALUES ('Aland Islands');
INSERT INTO `Country` VALUES ('Algeria');
INSERT INTO `Country` VALUES ('Angola');
INSERT INTO `Country` VALUES ('Anguilla');
INSERT INTO `Country` VALUES ('China');
INSERT INTO `Country` VALUES ('Japanese');

-- ----------------------------
-- Table structure for European_Aviation
-- ----------------------------
DROP TABLE IF EXISTS `European_Aviation`;	/*Create this table, if it's not exist*/
CREATE TABLE `European_Aviation` (		
  `Id` int(5) NOT NULL,			
  `StartCountry` varchar(50) DEFAULT NULL,	
  `EndCountry` varchar(50) DEFAULT NULL,	
  `ToOrReturn` tinyint(1) DEFAULT NULL,		
  `DateOfDeparture` date DEFAULT NULL,		
  `ReturnDate` date DEFAULT NULL,		
  `TankType` varchar(20) DEFAULT NULL,		
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of European_Aviation
-- ----------------------------
INSERT INTO `European_Aviation` VALUES ('0', 'Franch', 'British', '2', '2020-11-12', '2020-11-18', 'Economy');	/*Insertion*/
INSERT INTO `European_Aviation` VALUES ('1', 'China', 'British', '1', '2020-11-12', '2020-11-30', 'Business ');	

-- ----------------------------
-- Table structure for Payment
-- ----------------------------
DROP TABLE IF EXISTS `Payment`;		/*Create this table, if it's not exist*/
CREATE TABLE `Payment` (
  `NameOnCard` varchar(50) DEFAULT NULL,	
  `CreditCardNumber` varchar(30) DEFAULT NULL,	
  `ExpMonth` varchar(20) DEFAULT NULL,		
  `ExpYear` int(5) DEFAULT NULL,		
  `CVV` int(10) DEFAULT NULL			
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Payment
-- ----------------------------
INSERT INTO `Payment` VALUES ('BOC', '17452046084', '12', '2020', '1506');	/*Insertion*/
INSERT INTO `Payment` VALUES ('OTP', null, null, null, null);

-- ----------------------------
-- Table structure for personal_Information
-- ----------------------------
DROP TABLE IF EXISTS `personal_Information`;	/*Create this table, if it's not exist*/
CREATE TABLE `personal_Information` (		
  `Title` varchar(10) NOT NULL,			/*Mr Mrs Miss Ms*/
  `FirstName` varchar(100) DEFAULT NULL,	
  `LastName` varchar(100) DEFAULT NULL,		
  `IsCard` tinyint(4) DEFAULT NULL,		
  `CardNumber` int(20) NOT NULL		
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal_Information
-- ----------------------------
INSERT INTO `personal_Information` VALUES ('miss', 'join', 'fujoin', '1', '1745204658');	/*Insertion*/
INSERT INTO `personal_Information` VALUES ('', null, null, null, '0');
