/*
 Navicat Premium Data Transfer

 Source Server         : WebDisk
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 123.57.59.57
 Source Database       : WebDisk

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : utf-8

 Date: 12/10/2020 10:10:57 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Contact_details`
-- ----------------------------
DROP TABLE IF EXISTS `Contact_details`;
CREATE TABLE `Contact_details` (
  `ID` int NOT NULL,
  `Country` varchar(45) DEFAULT NULL,
  `Telephone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `IsReceiveAds` binary(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `ID` FOREIGN KEY (`ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Contact_details`
-- ----------------------------
BEGIN;
INSERT INTO `Contact_details` VALUES ('0', 'Hungary', '12345678910', 'TestEmail@TestGmail.com', 0x30);
COMMIT;

-- ----------------------------
--  Table structure for `Flight`
-- ----------------------------
DROP TABLE IF EXISTS `Flight`;
CREATE TABLE `Flight` (
  `Flight_id` int NOT NULL,
  `Flight_number` varchar(10) DEFAULT NULL,
  `Departure_city` varchar(45) DEFAULT NULL,
  `Departure_time` time DEFAULT NULL,
  `Arrive_city` varchar(45) DEFAULT NULL,
  `Arrive_time` time DEFAULT NULL,
  `Price` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Flight`
-- ----------------------------
BEGIN;
INSERT INTO `Flight` VALUES ('0', 'EA001', 'Budapest', '05:00:00', 'Copenhagen', '08:55:00', '$250'), ('1', 'EA002', 'Budapest', '09:00:00', 'London', '11:35:00', '$355'), ('2', 'EA003', 'Budapest', '13:00:00', 'Amsterdam', '15:10:00', '$400'), ('3', 'EA004', 'Budapest', '16:00:00', 'Vienna', '20:35:00', '$480'), ('4', 'EA005', 'Budapest', '21:00:00', 'Paris', '23:20:00', '$500');
COMMIT;

-- ----------------------------
--  Table structure for `Flight_information`
-- ----------------------------
DROP TABLE IF EXISTS `Flight_information`;
CREATE TABLE `Flight_information` (
  `ID` int NOT NULL,
  `Flight_id` int DEFAULT NULL,
  `Flight_number` int DEFAULT NULL,
  `Departure_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Flight_id` (`Flight_id`),
  CONSTRAINT `flight_id` FOREIGN KEY (`Flight_id`) REFERENCES `Flight` (`Flight_id`),
  CONSTRAINT `ID3` FOREIGN KEY (`ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Payment`
-- ----------------------------
DROP TABLE IF EXISTS `Payment`;
CREATE TABLE `Payment` (
  `Order_number` int NOT NULL,
  `ID` int DEFAULT NULL,
  `First_name` varchar(45) DEFAULT NULL,
  `Second_name` varchar(45) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Zip` int DEFAULT NULL,
  `Name_on_card` varchar(100) DEFAULT NULL,
  `Credit_card_number` varchar(20) DEFAULT NULL,
  `Exp_year` int DEFAULT NULL,
  `Exp_month` varchar(20) DEFAULT NULL,
  `CVV` int DEFAULT NULL,
  PRIMARY KEY (`Order_number`),
  KEY `ID` (`ID`),
  CONSTRAINT `ID1` FOREIGN KEY (`ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Personal_information`
-- ----------------------------
DROP TABLE IF EXISTS `Personal_information`;
CREATE TABLE `Personal_information` (
  `ID` int NOT NULL,
  `Title` varchar(10) DEFAULT NULL,
  `First_name` varchar(45) DEFAULT NULL,
  `Last_name` varchar(45) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `First_on_birth` varchar(45) DEFAULT NULL,
  `Second_on_birth` varchar(45) DEFAULT NULL,
  `Passport` varchar(20) DEFAULT NULL,
  `Telephone` varchar(20) DEFAULT NULL,
  `Is_member` binary(1) DEFAULT NULL,
  `Membership_card_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `ID2` FOREIGN KEY (`ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Personal_information`
-- ----------------------------
BEGIN;
INSERT INTO `Personal_information` VALUES ('0', 'Mr.', 'John', 'Willon', 'JohnWillon123@gmail.com', 'John', 'Willon', 'ABC123', '+36 101111111', 0x30, 'null');
COMMIT;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `ID` int NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `CreayedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `User`
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('0', 'TestEmail@TestGmail.com', 'Test123', '2020-12-02 07:17:41');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
