-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for job
CREATE DATABASE IF NOT EXISTS `job` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `job`;

-- Dumping structure for table job.applicant
CREATE TABLE IF NOT EXISTS `applicant` (
  `applicantId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lastName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `qualification` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(25) NOT NULL DEFAULT '0',
  `experience` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cellNumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`applicantId`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table job.jobapplicant
CREATE TABLE IF NOT EXISTS `jobapplicant` (
  `jobid` int NOT NULL,
  `applicantid` int NOT NULL,
  KEY `FK__jobs` (`jobid`),
  KEY `FK__applicant` (`applicantid`),
  CONSTRAINT `FK__applicant` FOREIGN KEY (`applicantid`) REFERENCES `applicant` (`applicantId`),
  CONSTRAINT `FK__jobs` FOREIGN KEY (`jobid`) REFERENCES `jobs` (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table job.jobs
CREATE TABLE IF NOT EXISTS `jobs` (
  `jobId` int NOT NULL AUTO_INCREMENT,
  `jobDescriptipon` varchar(225) NOT NULL DEFAULT '',
  `salary` int NOT NULL,
  `experience` varchar(50) NOT NULL DEFAULT '',
  `qualifications` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
