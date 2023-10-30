-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: groupwork1
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Course` VALUES ('101','1','Introduction to Computer Science','Introductory course for CS majors',3,'Room A','Open',50,30,'2023-08-20 13:00:00','2023-12-10 15:30:00'),('102','1','Calculus I','First course in calculus sequence',4,'Room B','Open',60,45,'2023-08-22 15:00:00','2023-12-12 17:30:00'),('201','2','History of Art','Exploration of art history',3,'Room C','Open',40,20,'2024-01-10 19:00:00','2024-05-05 20:00:00'),('105','3','Database Management','Introduction to database systems',3,'Room B','Open',60,50,'2024-08-20 17:30:00','2024-12-15 21:00:00'),('106','4','Chemistry 101','Fundamentals of chemistry',4,'Room C','Open',45,40,'2025-01-10 13:00:00','2025-05-05 14:30:00');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseProfessor`
--

DROP TABLE IF EXISTS `CourseProfessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `CourseProfessor` VALUES ('101','3'),('102','3'),('105','7'),('106','8');
/*!40000 ALTER TABLE `CourseProfessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseSchedule`
--

DROP TABLE IF EXISTS `CourseSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `CourseSchedule` VALUES ('101','Monday','2023-08-21 13:00:00','2023-08-21 14:30:00'),('101','Wednesday','2023-08-23 13:00:00','2023-08-23 14:30:00'),('102','Tuesday','2023-08-22 15:00:00','2023-08-22 16:30:00'),('201','Thursday','2024-01-11 19:00:00','2024-01-11 21:00:00'),('105','Monday','2024-08-21 17:30:00','2024-08-21 19:00:00'),('105','Wednesday','2024-08-23 17:30:00','2024-08-23 19:00:00'),('106','Tuesday','2025-01-11 13:00:00','2025-01-11 15:30:00');
/*!40000 ALTER TABLE `CourseSchedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseStudent`
--

DROP TABLE IF EXISTS `CourseStudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `CourseStudent` VALUES ('101','4',90.5),('102','4',85),('105','7',88),('106','8',86),('201','4',33);
/*!40000 ALTER TABLE `CourseStudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseTopic`
--

DROP TABLE IF EXISTS `CourseTopic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Employee` VALUES ('1','admin','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1','2023-10-20 14:00:00','2023-10-20 14:30:00'),('2','alicesmith','password2','1','2023-10-21 13:30:00','2023-10-21 14:15:00'),('3','sarahjones','password3','1','2023-10-23 20:30:00','2023-10-23 21:15:00'),('6','admin1','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1','2023-10-26 22:46:22','2023-10-26 22:46:22');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Historypwd`
--

DROP TABLE IF EXISTS `Historypwd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Historypwd` VALUES ('1','oldpassword1'),('2','oldpassword2'),('3','oldpassword3'),('3','oldpassword3'),('6','31a76d7c1c7e8caffd45978dd1550716fded6121fe304172df75182b5888a49d'),('6','31a76d7c1c7e8caffd45978dd1550716fded6121fe304172df75182b5888a49d'),('6','31a76d7c1c7e8caffd45978dd1550716fded6121fe304172df75182b5888a49d'),('6','31a76d7c1c7e8caffd45978dd1550716fded6121fe304172df75182b5888a49d'),('6','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22');
/*!40000 ALTER TABLE `Historypwd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Person` VALUES ('John Doe','1','Employee'),('Alice Smith','2','Employee'),('Professor Smith','3','Professor'),('Student Johnson','4','Student'),('Professor Brown','5','Professor'),('p','6','Employee'),('p','6','Employee'),('p','6','Employee'),('p','6','Employee'),('p','6','Employee');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonSchedule`
--

DROP TABLE IF EXISTS `PersonSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `PersonSchedule` VALUES ('101','1','2023-08-21 13:00:00','2023-08-21 14:30:00','4'),('102','1','2023-08-22 15:00:00','2023-08-22 16:30:00','4'),('105','5','2024-08-21 17:30:00','2024-08-21 19:00:00','8'),('106','6','2025-01-11 13:00:00','2025-01-11 15:30:00','8');
/*!40000 ALTER TABLE `PersonSchedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Professor` VALUES ('3','pro','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','English','1',4.5,'North','2023-10-22 15:15:00','2023-10-22 16:00:00'),('5','profbrown','password5','Spanish','1',4,'South','2023-10-21 18:00:00','2023-10-21 18:45:00'),('7','profwhite','password7','English','1',4.7,'East','2023-10-25 18:00:00','2023-10-25 18:45:00'),('8','professorgreen','password8','Chemistry','1',4.2,'West','2023-10-26 14:00:00','2023-10-26 15:00:00');
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProfessorTopic`
--

DROP TABLE IF EXISTS `ProfessorTopic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `ProfessorTopic` VALUES ('3','Computer Science'),('3','Mathematics'),('5','History'),('7','Literature'),('8','Chemical Bonds');
/*!40000 ALTER TABLE `ProfessorTopic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rate`
--

DROP TABLE IF EXISTS `Rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Rate` (
  `professor_id` varchar(255) DEFAULT NULL,
  `studuent_id` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `scorepart1` varchar(255) DEFAULT NULL,
  `scorepart2` varchar(255) DEFAULT NULL,
  `scorepart3` varchar(255) DEFAULT NULL,
  `scorepart4` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `rate_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rate`
--

LOCK TABLES `Rate` WRITE;
/*!40000 ALTER TABLE `Rate` DISABLE KEYS */;
INSERT INTO `Rate` VALUES ('7','4','105','4','5','4','4','Interesting course!','4.25','1'),('8','5','106','4','4','5','4','Knowledgeable professor!','4.25','2');
/*!40000 ALTER TABLE `Rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Semester`
--

DROP TABLE IF EXISTS `Semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Semester` VALUES ('1','Fall 2023','2023-08-15 04:00:00','2023-12-15 05:00:00'),('2','Spring 2024','2024-01-15 05:00:00','2024-05-15 04:00:00'),('5','Fall 2025','2025-08-15 08:00:00','2025-12-15 10:00:00'),('6','Spring 2026','2026-01-15 10:00:00','2026-05-15 08:00:00');
/*!40000 ALTER TABLE `Semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `Student` VALUES ('4','stu','080a9ed428559ef602668b4c00f114f1a11c3f6b02a435f0bdc154578e4d7f22','1',3.8,'2023-10-20 19:30:00','2023-10-20 20:15:00');
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

-- Dump completed on 2023-10-26 15:53:10
