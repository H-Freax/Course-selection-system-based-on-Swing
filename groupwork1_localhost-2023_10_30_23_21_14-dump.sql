-- MySQL dump 10.13  Distrib 8.0.15, for osx10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: groupwork1
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Course` (
  `id` varchar(255) DEFAULT NULL,
  `semesterid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `point` int DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `statue` varchar(255) DEFAULT NULL,
  `studentlimited` int DEFAULT NULL,
  `studentcount` int DEFAULT NULL,
  `begintime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('101','1','Introduction to Computer Science','Introductory course for CS majors',3,'Room A','Open',50,32,'2023-08-20 17:00:00','2023-12-10 20:30:00'),('102','1','Calculus I','First course in calculus sequence',4,'Room B','Open',60,45,'2023-08-22 19:00:00','2023-12-12 22:30:00'),('201','2','History of Art','Exploration of art history',3,'Room C','Open',40,20,'2024-01-11 00:00:00','2024-05-06 00:00:00'),('105','3','Database Management','Introduction to database systems',3,'Room B','Open',60,50,'2024-08-20 21:30:00','2024-12-16 02:00:00'),('106','4','Chemistry 101','Fundamentals of chemistry',4,'Room C','Open',45,40,'2025-01-10 18:00:00','2025-05-05 18:30:00');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseProfessor`
--

DROP TABLE IF EXISTS `CourseProfessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CourseProfessor` (
  `course_id` varchar(255) DEFAULT NULL,
  `professor_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseProfessor`
--

LOCK TABLES `CourseProfessor` WRITE;
/*!40000 ALTER TABLE `CourseProfessor` DISABLE KEYS */;
INSERT INTO `CourseProfessor` VALUES ('101','3'),('102','3'),('105','3'),('106','3'),('201','3');
/*!40000 ALTER TABLE `CourseProfessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseSchedule`
--

DROP TABLE IF EXISTS `CourseSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CourseSchedule` (
  `course_id` varchar(255) DEFAULT NULL,
  `weekday` varchar(255) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseSchedule`
--

LOCK TABLES `CourseSchedule` WRITE;
/*!40000 ALTER TABLE `CourseSchedule` DISABLE KEYS */;
INSERT INTO `CourseSchedule` VALUES ('101','Monday','2023-08-21 17:00:00','2023-08-21 18:30:00'),('101','Wednesday','2023-08-23 17:00:00','2023-08-23 18:30:00'),('102','Tuesday','2023-08-22 19:00:00','2023-08-22 20:30:00'),('201','Thursday','2024-01-12 00:00:00','2024-01-12 02:00:00'),('105','Monday','2024-08-21 21:30:00','2024-08-21 23:00:00'),('105','Wednesday','2024-08-23 21:30:00','2024-08-23 23:00:00'),('106','Tuesday','2025-01-11 18:00:00','2025-01-11 20:30:00');
/*!40000 ALTER TABLE `CourseSchedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseStudent`
--

DROP TABLE IF EXISTS `CourseStudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CourseStudent` (
  `course_id` varchar(255) DEFAULT NULL,
  `studuent_id` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseStudent`
--

LOCK TABLES `CourseStudent` WRITE;
/*!40000 ALTER TABLE `CourseStudent` DISABLE KEYS */;
INSERT INTO `CourseStudent` VALUES ('102','4',85),('105','7',88),('106','8',86),('201','4',33),('101','4',44);
/*!40000 ALTER TABLE `CourseStudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseTopic`
--

DROP TABLE IF EXISTS `CourseTopic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CourseTopic` (
  `course_id` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseTopic`
--

LOCK TABLES `CourseTopic` WRITE;
/*!40000 ALTER TABLE `CourseTopic` DISABLE KEYS */;
INSERT INTO `CourseTopic` VALUES ('101','Programming Fundamentals'),('102','Limits and Derivatives'),('105','Relational Databases'),('106','Chemical Reactions');
/*!40000 ALTER TABLE `CourseTopic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Employee` (
  `id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `nowpassword` varchar(255) DEFAULT NULL,
  `enabled` varchar(255) DEFAULT NULL,
  `lastactive` timestamp NULL DEFAULT NULL,
  `lastupdate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES ('1','admin','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1','2023-10-31 03:20:36','2023-10-31 02:08:59'),('2','alicesmith','password2','1','2023-10-21 17:30:00','2023-10-21 18:15:00'),('3','sarahjones','password3','1','2023-10-24 00:30:00','2023-10-24 01:15:00'),('6','admin1','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1','2023-10-27 15:55:33','2023-10-27 15:55:33');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Historypwd`
--

DROP TABLE IF EXISTS `Historypwd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Historypwd` (
  `personid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Historypwd`
--

LOCK TABLES `Historypwd` WRITE;
/*!40000 ALTER TABLE `Historypwd` DISABLE KEYS */;
INSERT INTO `Historypwd` VALUES ('4','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('1','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('1','038966de9f6b9a901b20b4c6ca8b2a46009feebe031babc842d43690c0bc222b'),('1','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22'),('3','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22');
/*!40000 ALTER TABLE `Historypwd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Person` (
  `PersonName` varchar(255) DEFAULT NULL,
  `PersonID` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES ('John Doe','1','employee'),('Alice Smith','2','Employee'),('Professor Smith','3','Professor'),('Student Johnson','4','Student'),('Professor Brown','5','Professor'),('p','6','Employee'),('student 2','9','Student'),('student1','10','Student'),('student1','10','Student'),('student1','10','Student');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonSchedule`
--

DROP TABLE IF EXISTS `PersonSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PersonSchedule` (
  `course_id` varchar(255) DEFAULT NULL,
  `semesterid` varchar(255) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `personid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PersonSchedule`
--

LOCK TABLES `PersonSchedule` WRITE;
/*!40000 ALTER TABLE `PersonSchedule` DISABLE KEYS */;
INSERT INTO `PersonSchedule` VALUES ('101','1','2023-08-21 17:00:00','2023-08-21 18:30:00','4'),('102','1','2023-08-22 19:00:00','2023-08-22 20:30:00','4'),('105','5','2024-08-21 21:30:00','2024-08-21 23:00:00','8'),('106','6','2025-01-11 18:00:00','2025-01-11 20:30:00','8');
/*!40000 ALTER TABLE `PersonSchedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Professor` (
  `id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `nowpassword` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `enabled` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `lastactive` timestamp NULL DEFAULT NULL,
  `lastupdate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Professor`
--

LOCK TABLES `Professor` WRITE;
/*!40000 ALTER TABLE `Professor` DISABLE KEYS */;
INSERT INTO `Professor` VALUES ('3','pro','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','English','1',60,'North','2023-10-31 03:19:39','2023-10-31 03:19:39'),('5','profbrown','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','Spanish','1',4,'South','2023-10-21 22:00:00','2023-10-21 22:45:00'),('7','profwhite','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','English','1',4.7,'East','2023-10-25 22:00:00','2023-10-25 22:45:00'),('8','professorgreen','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','Chemistry','1',4.2,'West','2023-10-26 18:00:00','2023-10-26 19:00:00');
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProfessorTopic`
--

DROP TABLE IF EXISTS `ProfessorTopic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ProfessorTopic` (
  `professor_id` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProfessorTopic`
--

LOCK TABLES `ProfessorTopic` WRITE;
/*!40000 ALTER TABLE `ProfessorTopic` DISABLE KEYS */;
INSERT INTO `ProfessorTopic` VALUES ('5','History'),('7','Literature'),('8','Chemical Bonds'),('3','Computer Science'),('3','Mathematics');
/*!40000 ALTER TABLE `ProfessorTopic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rate`
--

DROP TABLE IF EXISTS `Rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Rate` (
  `professor_id` varchar(255) DEFAULT NULL,
  `studuent_id` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `scorepart1` varchar(255) DEFAULT NULL,
  `scorepart2` varchar(255) DEFAULT NULL,
  `scorepart3` varchar(255) DEFAULT NULL,
  `scorepart4` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rate`
--

LOCK TABLES `Rate` WRITE;
/*!40000 ALTER TABLE `Rate` DISABLE KEYS */;
INSERT INTO `Rate` VALUES ('3','4','201','1','1','1','1','1','20'),('3','4','101','5','5','5','5','goodclass!','100');
/*!40000 ALTER TABLE `Rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Semester`
--

DROP TABLE IF EXISTS `Semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Semester` (
  `id` varchar(255) DEFAULT NULL,
  `semstername` varchar(255) DEFAULT NULL,
  `semesterstart` timestamp NULL DEFAULT NULL,
  `semesterend` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Semester`
--

LOCK TABLES `Semester` WRITE;
/*!40000 ALTER TABLE `Semester` DISABLE KEYS */;
INSERT INTO `Semester` VALUES ('1','Fall 2023','2023-08-15 08:00:00','2023-12-15 10:00:00'),('2','Spring 2024','2024-01-15 10:00:00','2024-05-15 08:00:00'),('5','Fall 2025','2025-08-15 12:00:00','2025-12-15 15:00:00'),('6','Spring 2026','2026-01-15 15:00:00','2026-05-15 12:00:00');
/*!40000 ALTER TABLE `Semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Student` (
  `id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `nowpassword` varchar(255) DEFAULT NULL,
  `enabled` varchar(255) DEFAULT NULL,
  `gpa` double DEFAULT NULL,
  `lastactive` timestamp NULL DEFAULT NULL,
  `lastupdate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('4','stu','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1',0.92,'2023-10-31 03:17:29','2023-10-31 03:17:39'),('9','stu1','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1',3.8,'2023-10-30 12:20:03','2023-10-30 12:20:05'),('10','stu11','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1',0,'2023-10-31 02:00:56','2023-10-31 02:00:51');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30 23:21:14
