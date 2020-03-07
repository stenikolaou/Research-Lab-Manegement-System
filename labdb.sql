-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2020 at 10:45 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `labdb`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CoursesByFacultySP` (IN `MemberSurname` VARCHAR(30))  NO SQL
SELECT CourseTitle, CourseECTS, CourseLevelName, CourseSemester FROM courses, members, courseparticipants, courselevel
WHERE courses.CourseId = courseparticipants.CourseId
AND courseparticipants.MemberId = members.MemberId
AND members.MemberSurname = MemberSurname
AND members.MemberCategoryId = 1
AND courses.CourseLevelId = courselevel.CourseLevelId
ORDER BY CourseSemester ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateAnnSP` (IN `MemberId` INT, IN `AnnTitle` VARCHAR(30), IN `AnnDate` DATE, IN `AnnBody` VARCHAR(50))  NO SQL
INSERT INTO announcements (MemberId, AnnTitle, AnnDate, AnnBody)
VALUES (MemberId, AnnTitle, AnnDate, AnnBody)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateCourseLevelSP` (IN `CourseLevelName` VARCHAR(30))  NO SQL
INSERT INTO courselevel (CourseLevelName) VALUES (CourseLevelName)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateCourseParticipantSP` (IN `MemberId` INT, IN `CourseId` INT)  NO SQL
INSERT INTO courseparticipants (CourseId, MemberId) VALUES (MemberId, CourseId)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateCourseSP` (IN `CourseLevelId` INT(11), IN `CourseTitle` VARCHAR(30), IN `CourseSemester` INT(11), IN `CourseECTS` INT(11))  NO SQL
INSERT INTO courses (CourseLevelId, CourseTitle, CourseSemester, CourseECTS) VALUES (CourseLevelId, CourseTitle, CourseSemester, CourseECTS)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateMemberCategorySP` (IN `MemberCategoryName` VARCHAR(30))  NO SQL
INSERT INTO membercategory (MemberCategoryName) VALUES (MemberCategoryName)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateMemberSP` (IN `MemberCategoryId` INT(11), IN `MemberName` VARCHAR(30), IN `MemberSurname` VARCHAR(30), IN `MemberWebpage` VARCHAR(50), IN `MemberEmail` VARCHAR(50), IN `MemberShortCV` VARCHAR(50))  NO SQL
INSERT INTO members (MemberCategoryId, MemberName, MemberSurname, MemberWebpage, MemberEmail, MemberShortCV) 
VALUES (MemberCategoryId, MemberName, MemberSurname, MemberWebpage, MemberEmail, MemberShortCV)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateProjectMemberSP` (IN `MemberId` INT, IN `ProjectId` INT)  NO SQL
INSERT INTO projectmembers (ProjectId, MemberId) VALUES (MemberId, ProjectId)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateProjectSP` (IN `ProjectStatusId` INT(11), IN `ProjectName` VARCHAR(50), IN `ProjectDesc` VARCHAR(50))  NO SQL
INSERT INTO projects (ProjectStatusId, ProjectName, ProjectDesc)
VALUES (ProjectStatusId, ProjectName, ProjectDesc)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateProjectStatusSP` (IN `ProjectStatusType` VARCHAR(30))  NO SQL
INSERT INTO projectstatus (ProjectStatusType) VALUES (ProjectStatusType)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreatePubParticipantSP` (IN `PubId` INT, IN `MemberId` INT)  NO SQL
INSERT INTO pubparticipants (PubId, MemberId) VALUES (PubId, MemberId)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreatePubSP` (IN `ProjectId` INT(11), IN `PubTypeId` INT(11), IN `PubTitle` VARCHAR(50), IN `PubYear` YEAR, IN `PubSubject` VARCHAR(50))  NO SQL
INSERT INTO publications (ProjectId, PubTypeId, PubTitle, PubYear, PubSubject)
VALUES (ProjectId, PubTypeId, PubTitle, PubYear, PubSubject)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreatePubTypeSP` (IN `PubTypeName` VARCHAR(30))  NO SQL
INSERT INTO pubtype (PubTypeName) VALUES (PubTypeName)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteAnnSP` (INOUT `AnnId` INT)  NO SQL
DELETE FROM announcements WHERE announcements.AnnId = AnnId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteCourseLevelSP` (INOUT `CourseLevelId` INT(11))  NO SQL
DELETE FROM courselevel WHERE courselevel.CourseLevelId=CourseLevelId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteCourseParticipantSP` (INOUT `CourseId` INT, INOUT `MemberId` INT)  NO SQL
DELETE FROM courseparticipants WHERE courseparticipants.CourseId=CourseId AND courseparticipants.MemberId=MemberId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteCourseSP` (INOUT `CourseId` INT)  NO SQL
DELETE FROM courses WHERE courses.CourseId=CourseId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteMemberCategorySP` (INOUT `MemberCategoryId` INT(11))  NO SQL
DELETE FROM membercategory WHERE membercategory.MemberCategoryId=MemberCategoryId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteMemberSP` (INOUT `MemberId` INT(10))  NO SQL
DELETE FROM members WHERE members.MemberId=MemberId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteProjectMemberSP` (INOUT `ProjectId` INT, INOUT `MemberId` INT)  NO SQL
DELETE FROM projectmembers WHERE projectmembers.ProjectId=ProjectId AND projectmembers.MemberId=MemberId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteProjectSP` (INOUT `ProjectId` INT(11))  NO SQL
DELETE FROM projects WHERE projects.ProjectId=ProjectId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteProjectStatusSP` (INOUT `ProjectStatusId` INT(11))  NO SQL
DELETE FROM projectstatus WHERE projectstatus.ProjectStatusId=ProjectStatusId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeletePubParticipantSP` (INOUT `PubId` INT, INOUT `MemberId` INT)  NO SQL
DELETE FROM pubparticipants WHERE pubparticipants.PubId=PubId AND pubparticipants.MemberId=MemberId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeletePubSP` (INOUT `PubId` INT(11))  NO SQL
DELETE FROM publications WHERE publications.PubId=PubId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeletePubTypeSP` (INOUT `PubTypeId` INT(11))  NO SQL
DELETE FROM pubtype WHERE pubtype.PubTypeId=PubTypeId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PubByMemberSP` (IN `MemberSurname` VARCHAR(30))  NO SQL
SELECT PubTitle, PubYear, PubSubject FROM publications, members, pubparticipants 
WHERE publications.PubId = pubparticipants.PubId 
AND pubparticipants.MemberId=members.MemberId 
AND members.MemberSurname=MemberSurname
GROUP BY pubTitle
ORDER BY PubYear DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PubByProjectSP` (IN `ProjectName` VARCHAR(50))  NO SQL
SELECT PubTitle, PubYear, PubSubject, PubParticipants 
FROM publications, projects
WHERE publications.ProjectId = projects.ProjectId 
AND projects.ProjectName=ProjectName
GROUP BY pubTitle
ORDER BY PubYear DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadAnnsSP` ()  NO SQL
SELECT * FROM announcements$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadCourseLevelSP` ()  NO SQL
SELECT * FROM courselevel$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadCourseParticipantsSP` ()  NO SQL
SELECT * FROM courseparticipants$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadCoursesSP` ()  NO SQL
SELECT * FROM courses$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadMemberCategorySP` ()  NO SQL
SELECT * FROM membercategory$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadMembersSP` ()  NO SQL
SELECT * FROM members$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadProjectMembersSP` ()  NO SQL
SELECT * FROM projectmembers$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadProjectsSP` ()  NO SQL
SELECT * FROM projects$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadProjectStatusSP` ()  NO SQL
SELECT * FROM projectstatus$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadPubParticipantsSP` ()  NO SQL
SELECT * FROM pubparticipants$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadPubsSP` ()  NO SQL
SELECT * FROM publications$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadPubTypeSP` ()  NO SQL
SELECT * FROM pubtype$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowAllMembersSP` ()  NO SQL
SELECT DISTINCT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV, MemberCategoryName 
FROM members, membercategory
WHERE members.MemberCategoryId = membercategory.MemberCategoryId
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowAllPubSP` ()  NO SQL
SELECT PubTitle, PubYear, PubSubject, PubParticipants  
FROM publications 
GROUP BY PubTitle, PubYear
ORDER BY PubYear DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowAnnByDateAscSP` ()  NO SQL
SELECT AnnTitle, AnnBody, AnnDate FROM announcements
ORDER BY AnnDate ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowAnnByDateDescSP` ()  NO SQL
SELECT AnnTitle, AnnBody, AnnDate FROM announcements
ORDER BY AnnDate DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowConvPubSP` ()  NO SQL
SELECT PubTitle, PubYear, PubSubject, PubParticipants FROM publications 
WHERE PubTypeId=1
GROUP BY PubTitle
ORDER BY PubYear DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowCurrentProjectsSP` ()  NO SQL
SELECT ProjectName, ProjectDesc, ProjectMembers FROM projects
WHERE ProjectStatusId = 1
ORDER BY ProjectName ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowFacultySP` ()  NO SQL
SELECT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV FROM members WHERE MemberCategoryId=1
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowMagPubSP` ()  NO SQL
SELECT PubTitle, PubYear, PubSubject, PubParticipants
FROM publications 
WHERE PubTypeId=2
GROUP BY PubTitle
ORDER BY PubYear DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPastMembersSP` ()  NO SQL
SELECT MemberSurname AS 'Surname', MemberName AS 'Name', MemberShortCV AS 'ShortCV' from pastmembers
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPastProjectsSp` ()  NO SQL
SELECT ProjectName, ProjectDesc, ProjectMembers FROM projects
WHERE ProjectStatusId = 2
ORDER BY ProjectName ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPhdSP` ()  NO SQL
SELECT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV FROM members WHERE MemberCategoryId=3
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPostgraduateCoursesSP` ()  NO SQL
SELECT CourseTitle, CourseECTS, CourseSemester FROM courses
WHERE courses.CourseLevelId = 2
ORDER BY CourseSemester ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPostgraduatesSP` ()  NO SQL
SELECT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV FROM members WHERE MemberCategoryId=4
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowProjectParticipantsSP` (IN `ProjectName` VARCHAR(50))  NO SQL
SELECT MemberSurname, MemberName from members, projects, projectmembers
WHERE members.MemberId = projectmembers.MemberId
AND projects.ProjectId = projectmembers.ProjectId
AND projects.ProjectName = ProjectName
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowPubParticipantsSP` (IN `PubTitle` VARCHAR(50))  NO SQL
SELECT MemberSurname, MemberName from members, publications, pubparticipants
WHERE members.MemberId = pubparticipants.MemberId
AND publications.PubId = pubparticipants.PubId
AND publications.PubTitle = PubTitle
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowResearchersSP` ()  NO SQL
SELECT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV FROM members WHERE MemberCategoryId=2
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowUndergraduateCoursesSP` ()  NO SQL
SELECT CourseTitle, CourseECTS, CourseSemester FROM courses
WHERE courses.CourseLevelId = 1
ORDER BY CourseSemester ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ShowUndergraduatesSP` ()  NO SQL
SELECT MemberSurname, MemberName, MemberWebpage, MemberEmail, MemberShortCV FROM members WHERE MemberCategoryId=5
ORDER BY MemberSurname ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateAnnSP` (INOUT `AnnId` INT, INOUT `MemberId` INT, INOUT `AnnTitle` VARCHAR(30), INOUT `AnnDate` DATE, INOUT `AnnBody` VARCHAR(50))  NO SQL
UPDATE announcements SET
MemberId=MemberId, AnnTitle=AnnTitle, AnnDate=AnnDate, AnnBody=AnnBody
WHERE announcements.AnnId = AnnId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateCourseLevelSP` (INOUT `CourseLevelId` INT(11), INOUT `CourseLevelName` VARCHAR(30))  NO SQL
UPDATE courselevel SET
CourseLevelName=CourseLevelName
WHERE courselevel.CourseLevelId=CourseLevelId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateCourseSP` (INOUT `CourseId` INT, INOUT `CourseLevelId` INT, INOUT `CourseTitle` VARCHAR(30), INOUT `CourseSemester` INT, INOUT `CourseECTS` INT)  NO SQL
UPDATE courses SET
CourseLevelId=CourseLevelId, CourseTitle=CourseTitle, CourseSemester=CourseSemester, CourseECTS=CourseECTS
WHERE courses.CourseId=CourseId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateMemberCategorySP` (INOUT `MemberCategoryId` INT(10), INOUT `MemberCategoryName` VARCHAR(30))  NO SQL
UPDATE membercategory SET MemberCategoryName=MemberCategoryName
WHERE membercategory.MemberCategoryId=MemberCategoryId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateMemberSP` (INOUT `MemberId` INT(11), INOUT `MemberCategoryId` INT(11), INOUT `MemberName` VARCHAR(30), INOUT `MemberSurname` VARCHAR(30), INOUT `MemberWebpage` VARCHAR(50), INOUT `MemberEmail` VARCHAR(50), INOUT `MemberShortCV` VARCHAR(50))  NO SQL
UPDATE members SET 
MemberCategoryId=MemberCategoryId, MemberName=MemberName, MemberSurname=MemberSurname, MemberWebpage=MemberWebpage, MemberEmail=MemberEmail, MemberShortCV=MemberShortCV   
WHERE members.MemberId=MemberId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateProjectSP` (INOUT `ProjectId` INT(11), INOUT `ProjectStatusId` INT(11), INOUT `ProjectName` VARCHAR(50), INOUT `ProjectDesc` VARCHAR(50))  NO SQL
UPDATE projects SET
ProjectStatusId=ProjectStatusId, ProjectName=ProjectName, ProjectDesc=ProjectDesc
WHERE projects.ProjectId=ProjectId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateProjectStatusSP` (INOUT `ProjectStatusId` INT(11), INOUT `ProjectStatusType` VARCHAR(30))  NO SQL
UPDATE projectstatus SET ProjectStatusType=ProjectStatusType
WHERE projectstatus.ProjectStatusId=ProjectStatusId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePubSP` (INOUT `PubId` INT, INOUT `ProjectId` INT, INOUT `PubTypeId` INT, INOUT `PubTitle` VARCHAR(50), INOUT `PubYear` YEAR, INOUT `PubSubject` VARCHAR(50))  NO SQL
UPDATE publications SET
ProjectId=ProjectId, PubTypeId=PubTypeId, PubTitle=PubTitle, PubYear=PubYear, PubSubject=PubSubject
WHERE publications.PubId=PubId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePubTypeSP` (INOUT `PubTypeId` INT(11), INOUT `PubTypeName` VARCHAR(30))  NO SQL
UPDATE pubtype SET
PubTypeName=PubTypeName
WHERE pubtype.PubTypeId=PubTypeId$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `announcements`
--

CREATE TABLE `announcements` (
  `AnnId` int(11) NOT NULL,
  `MemberId` int(11) NOT NULL,
  `AnnTitle` varchar(100) NOT NULL,
  `AnnDate` date NOT NULL,
  `AnnBody` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `announcements`
--

INSERT INTO `announcements` (`AnnId`, `MemberId`, `AnnTitle`, `AnnDate`, `AnnBody`) VALUES
(1, 1, 'Invitation to lecture', '2020-02-14', 'https://easyupload.io/j1i85j'),
(4, 1, 'Upcoming event', '2020-01-31', 'https://easyupload.io/ycipsd'),
(5, 1, 'Invitation to lecture', '2020-01-27', 'https://easyupload.io/sufoqy'),
(6, 1, 'Upcoming event', '2020-02-12', 'https://easyupload.io/1r9r0r'),
(7, 1, 'PhD thesis defended!', '2019-12-17', 'https://easyupload.io/2hpqiv'),
(8, 1, 'Invitation to lecture', '2020-02-11', 'https://easyupload.io/a0tp1y');

--
-- Triggers `announcements`
--
DELIMITER $$
CREATE TRIGGER `CheckAnnDateInsTR` BEFORE INSERT ON `announcements` FOR EACH ROW BEGIN

 IF new.AnnDate!=CURRENT_DATE()
        
    THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Cannot add a new announcement with a past date";

    END IF ;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CheckAnnDateUpTR` BEFORE UPDATE ON `announcements` FOR EACH ROW BEGIN

 IF new.AnnDate!=CURRENT_DATE()
        
    THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Cannot change announcement date to a past one";

    END IF ;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `courselevel`
--

CREATE TABLE `courselevel` (
  `CourseLevelId` int(11) NOT NULL,
  `CourseLevelName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courselevel`
--

INSERT INTO `courselevel` (`CourseLevelId`, `CourseLevelName`) VALUES
(1, 'Undergraduate'),
(2, 'Postgraduate');

-- --------------------------------------------------------

--
-- Table structure for table `courseparticipants`
--

CREATE TABLE `courseparticipants` (
  `CourseId` int(11) NOT NULL,
  `MemberId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courseparticipants`
--

INSERT INTO `courseparticipants` (`CourseId`, `MemberId`) VALUES
(2, 4),
(2, 10),
(2, 12),
(3, 5),
(3, 10),
(3, 12),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(4, 7),
(4, 13),
(5, 1),
(5, 2),
(5, 3),
(5, 6),
(5, 7),
(5, 13),
(6, 1),
(6, 2),
(6, 3),
(6, 4),
(6, 13),
(7, 1),
(7, 2),
(7, 3),
(7, 8),
(7, 11),
(7, 13);

--
-- Triggers `courseparticipants`
--
DELIMITER $$
CREATE TRIGGER `CheckUnderTR` BEFORE INSERT ON `courseparticipants` FOR EACH ROW BEGIN
    IF ((SELECT members.MemberCategoryId FROM members WHERE members.MemberId =new.MemberId)=5
        AND (select courses.CourseLevelId FROM courses WHERE courses.CourseId=new.CourseId)=2)
    THEN

      SIGNAL sqlstate "45000" 
      set message_text = "An undergraduate Student can not participate in an advanced course";

    END IF ;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `CourseId` int(11) NOT NULL,
  `CourseLevelId` int(11) NOT NULL,
  `CourseTitle` varchar(30) NOT NULL,
  `CourseSemester` int(11) NOT NULL,
  `CourseECTS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`CourseId`, `CourseLevelId`, `CourseTitle`, `CourseSemester`, `CourseECTS`) VALUES
(2, 1, 'Relational Databases 1', 2, 5),
(3, 1, 'Relational Databases 2', 3, 5),
(4, 2, 'Advanced Relational Databases', 1, 5),
(5, 2, 'Java', 1, 5),
(6, 2, 'Data Mining', 2, 5),
(7, 2, 'Big Data', 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `membercategory`
--

CREATE TABLE `membercategory` (
  `MemberCategoryId` int(11) NOT NULL,
  `MemberCategoryName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `membercategory`
--

INSERT INTO `membercategory` (`MemberCategoryId`, `MemberCategoryName`) VALUES
(1, 'Faculty'),
(2, 'Researcher'),
(3, 'PhD Candidate'),
(4, 'Postgraduate'),
(5, 'Undergraduate');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `MemberId` int(11) NOT NULL,
  `MemberCategoryId` int(11) NOT NULL,
  `MemberName` varchar(30) NOT NULL,
  `MemberSurname` varchar(30) NOT NULL,
  `MemberWebpage` varchar(50) DEFAULT NULL,
  `MemberEmail` varchar(50) DEFAULT NULL,
  `MemberShortCV` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`MemberId`, `MemberCategoryId`, `MemberName`, `MemberSurname`, `MemberWebpage`, `MemberEmail`, `MemberShortCV`) VALUES
(1, 4, 'Stefanos', 'Nikolaou', 'not available', 'stefanikolaou@gmail.com', 'www.linkedin.com/in/stefanos-nikolaou'),
(2, 4, 'Dimitris', 'Koutsoukos', 'not available', 'not available', 'not available'),
(3, 4, 'Dimitris', 'Kolakas', 'not available', 'not available', 'not available'),
(4, 1, 'Christos', 'Doulkeridis', 'www.ds.unipi.gr/faculty/cdoulk/', 'cdoulk@unipi.gr', 'https://easyupload.io/3qejcu'),
(5, 1, 'Georgios', 'Vasilakopoulos', 'www.ds.unipi.gr/faculty/gvass/', 'gvass@unipi.gr', 'https://easyupload.io/di5vsv'),
(6, 2, 'Vassiliki', 'Koufi', 'not available', 'vkoufi@unipi.gr', 'not available'),
(7, 1, 'Andriana', 'Prentza', 'https://www.ds.unipi.gr/faculty/aprentza/', 'aprentza@unipi.gr', 'https://easyupload.io/2gjuvf'),
(8, 2, 'Andreas', 'Menychtas', 'not available', 'amenychtas@unipi.gr', 'not available'),
(9, 3, 'Konstantinos', 'Papadopoulos', 'not available', 'not available', 'not available'),
(10, 5, 'Ioannis', 'Pappas', 'not available', 'not available', 'not available'),
(11, 1, 'Dimosthenis', 'Kyriazis', 'https://www.ds.unipi.gr/faculty/dimos/', 'dimos@unipi.gr', 'https://easyupload.io/tjk6vr'),
(12, 5, 'Paraskevas', 'Antzas', 'not available', 'not available', 'not available'),
(13, 4, 'Grigoris ', 'Georgatos', 'not available', 'not available', 'not available'),
(14, 2, 'Kyriakos', 'Karataidis', 'not available', 'not available', 'not available'),
(15, 2, 'Dimitris', 'Mavrogenidis', 'not available', 'not available', 'not available');

--
-- Triggers `members`
--
DELIMITER $$
CREATE TRIGGER `CheckEmailInsTR` BEFORE INSERT ON `members` FOR EACH ROW BEGIN

    IF new.MemberEmail NOT LIKE '%@%.%'
        
 THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Wrong email format (shoul be like example@mail.com)";

    END IF ;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CheckEmailUpTR` BEFORE UPDATE ON `members` FOR EACH ROW BEGIN

    IF new.MemberEmail NOT LIKE '%@%.%'
        
 THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Wrong email format (shoul be like example@mail.com)";

    END IF ;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `DeleteMemberTR` AFTER DELETE ON `members` FOR EACH ROW BEGIN
    IF (old.MemberCategoryId=1 or old.MemberCategoryId=2 or old.MemberCategoryId=3)  
    THEN
        INSERT INTO pastmembers  values(old.MemberId,old.MemberCategoryId,
	old.MemberName,old.MemberSurname,old.MemberWebpage,
	old.MemberEmail,old.MemberShortCV);  
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pastmembers`
--

CREATE TABLE `pastmembers` (
  `MemberId` int(11) NOT NULL,
  `MemberCategoryId` int(11) NOT NULL,
  `MemberName` varchar(30) NOT NULL,
  `MemberSurname` varchar(30) NOT NULL,
  `MemberWebpage` varchar(50) NOT NULL,
  `MemberEmail` varchar(50) NOT NULL,
  `MemberShortCV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pastmembers`
--

INSERT INTO `pastmembers` (`MemberId`, `MemberCategoryId`, `MemberName`, `MemberSurname`, `MemberWebpage`, `MemberEmail`, `MemberShortCV`) VALUES
(18, 1, 'Konstantinos', 'Daskalakis', '', '', 'en.wikipedia.org/wiki/Constantinos_Daskalakis'),
(20, 3, 'Charalampos', 'Papadimitriou', '', '', 'Not available');

-- --------------------------------------------------------

--
-- Table structure for table `projectmembers`
--

CREATE TABLE `projectmembers` (
  `ProjectId` int(11) NOT NULL,
  `MemberId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projectmembers`
--

INSERT INTO `projectmembers` (`ProjectId`, `MemberId`) VALUES
(1, 1),
(1, 3),
(1, 4),
(1, 8),
(1, 13),
(1, 14),
(2, 4),
(2, 6),
(2, 7),
(2, 8),
(2, 12),
(2, 13),
(2, 15),
(3, 5),
(3, 6),
(3, 9),
(3, 10),
(3, 11),
(3, 14),
(4, 1),
(4, 3),
(4, 7),
(4, 8),
(4, 9),
(5, 6),
(5, 7),
(5, 10),
(5, 12),
(5, 13),
(5, 15);

--
-- Triggers `projectmembers`
--
DELIMITER $$
CREATE TRIGGER `CountProjMemDelTR` AFTER DELETE ON `projectmembers` FOR EACH ROW BEGIN
   UPDATE projects SET projects.ProjectMembers=(SELECT COUNT(*) FROM projectmembers WHERE old.ProjectId=ProjectId) WHERE ProjectId=old.ProjectId;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CountProjMemInsTR` AFTER INSERT ON `projectmembers` FOR EACH ROW begin

   UPDATE projects SET projects.ProjectMembers =(SELECT COUNT(*) FROM projectmembers WHERE new.ProjectId=projectmembers.ProjectId) WHERE projects.ProjectId=new.ProjectId;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `ProjectId` int(11) NOT NULL,
  `ProjectStatusId` int(11) NOT NULL,
  `ProjectName` varchar(50) NOT NULL,
  `ProjectDesc` varchar(50) NOT NULL,
  `ProjectMembers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`ProjectId`, `ProjectStatusId`, `ProjectName`, `ProjectDesc`, `ProjectMembers`) VALUES
(1, 1, 'Big Data Project', 'https://easyupload.io/3hzvjx', 6),
(2, 1, 'Machine Learning Project', 'https://easyupload.io/vh6pq4', 7),
(3, 1, 'NoSQL Project', 'https://easyupload.io/36d877', 6),
(4, 2, 'Clusters Project', 'https://easyupload.io/lpqb3x', 5),
(5, 2, 'Project5', '', 6);

-- --------------------------------------------------------

--
-- Table structure for table `projectstatus`
--

CREATE TABLE `projectstatus` (
  `ProjectStatusId` int(11) NOT NULL,
  `ProjectStatusType` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projectstatus`
--

INSERT INTO `projectstatus` (`ProjectStatusId`, `ProjectStatusType`) VALUES
(1, 'Current'),
(2, 'Past');

-- --------------------------------------------------------

--
-- Table structure for table `publications`
--

CREATE TABLE `publications` (
  `PubId` int(11) NOT NULL,
  `ProjectId` int(11) DEFAULT NULL,
  `PubTypeId` int(11) NOT NULL,
  `PubTitle` varchar(50) NOT NULL,
  `PubYear` year(4) NOT NULL,
  `PubSubject` varchar(50) NOT NULL,
  `PubParticipants` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publications`
--

INSERT INTO `publications` (`PubId`, `ProjectId`, `PubTypeId`, `PubTitle`, `PubYear`, `PubSubject`, `PubParticipants`) VALUES
(1, 1, 1, 'Advanced Healthcare Analytics', 2020, 'https://easyupload.io/uqw4ct', 4),
(2, 1, 1, 'Cloud Computing In Healthcare', 2020, 'https://easyupload.io/0x3926', 2),
(3, 1, 2, 'Big Data In Greek Hospitals', 2020, '', 4),
(4, 2, 1, 'pub4', 2019, '', 4),
(5, 3, 2, 'pub5', 2019, '', 4),
(6, 3, 2, 'pub6', 2020, '', 5),
(7, 4, 1, 'pub7', 2017, '', 3),
(8, 4, 2, 'pub8', 2016, '', 4),
(9, 4, 1, 'pub9', 2016, '', 3),
(10, 5, 2, 'pub10', 2014, '', 4);

--
-- Triggers `publications`
--
DELIMITER $$
CREATE TRIGGER `CheckPubYearInsTR` BEFORE INSERT ON `publications` FOR EACH ROW BEGIN

 IF new.pubyear<Year(CURRENT_DATE())
        
    THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Cannot add new publication with past year";

    END IF ;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CheckPubYearUpTR` BEFORE UPDATE ON `publications` FOR EACH ROW BEGIN

 IF new.pubyear<Year(CURRENT_DATE())
        
    THEN

      SIGNAL sqlstate "45000" 
      set message_text = "Cannot add new publication with past year";

    END IF ;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pubparticipants`
--

CREATE TABLE `pubparticipants` (
  `PubId` int(11) NOT NULL,
  `MemberId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pubparticipants`
--

INSERT INTO `pubparticipants` (`PubId`, `MemberId`) VALUES
(1, 1),
(1, 4),
(1, 9),
(1, 15),
(2, 3),
(2, 11),
(3, 1),
(3, 4),
(3, 5),
(3, 12),
(4, 1),
(4, 2),
(4, 7),
(4, 13),
(5, 3),
(5, 4),
(5, 8),
(5, 11),
(6, 1),
(6, 3),
(6, 4),
(6, 6),
(6, 7),
(7, 1),
(7, 3),
(7, 4),
(8, 2),
(8, 4),
(8, 9),
(8, 14),
(9, 4),
(9, 5),
(9, 8),
(10, 1),
(10, 3),
(10, 12),
(10, 13);

--
-- Triggers `pubparticipants`
--
DELIMITER $$
CREATE TRIGGER `CountPubPartDelTR` AFTER DELETE ON `pubparticipants` FOR EACH ROW BEGIN
   UPDATE publications SET publications.PubParticipants =(SELECT COUNT(*) FROM pubparticipants WHERE old.PubId=PubId) WHERE PubId=old.PubId;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CountPubPartInsTR` AFTER INSERT ON `pubparticipants` FOR EACH ROW begin

   UPDATE publications SET PubParticipants =(SELECT COUNT(*) FROM pubparticipants WHERE new.PubId=pubparticipants.PubId) WHERE publications.PubId=new.PubId;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pubtype`
--

CREATE TABLE `pubtype` (
  `PubTypeId` int(11) NOT NULL,
  `PubTypeName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pubtype`
--

INSERT INTO `pubtype` (`PubTypeId`, `PubTypeName`) VALUES
(1, 'Convention'),
(2, 'Magazine');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`AnnId`),
  ADD KEY `FK_Issue` (`MemberId`);

--
-- Indexes for table `courselevel`
--
ALTER TABLE `courselevel`
  ADD PRIMARY KEY (`CourseLevelId`);

--
-- Indexes for table `courseparticipants`
--
ALTER TABLE `courseparticipants`
  ADD PRIMARY KEY (`CourseId`,`MemberId`),
  ADD KEY `FK_Take_Part2` (`MemberId`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`CourseId`),
  ADD KEY `FK_Specifies` (`CourseLevelId`);

--
-- Indexes for table `membercategory`
--
ALTER TABLE `membercategory`
  ADD PRIMARY KEY (`MemberCategoryId`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`MemberId`),
  ADD KEY `FK_Relationship_6` (`MemberCategoryId`);

--
-- Indexes for table `projectmembers`
--
ALTER TABLE `projectmembers`
  ADD PRIMARY KEY (`ProjectId`,`MemberId`),
  ADD KEY `FK_Work_On2` (`MemberId`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`ProjectId`),
  ADD KEY `FK_Defines` (`ProjectStatusId`);

--
-- Indexes for table `projectstatus`
--
ALTER TABLE `projectstatus`
  ADD PRIMARY KEY (`ProjectStatusId`);

--
-- Indexes for table `publications`
--
ALTER TABLE `publications`
  ADD PRIMARY KEY (`PubId`),
  ADD KEY `FK_Mentioned_At` (`ProjectId`),
  ADD KEY `FK_Refers_To` (`PubTypeId`);

--
-- Indexes for table `pubparticipants`
--
ALTER TABLE `pubparticipants`
  ADD PRIMARY KEY (`PubId`,`MemberId`),
  ADD KEY `FK_Participate_In2` (`MemberId`);

--
-- Indexes for table `pubtype`
--
ALTER TABLE `pubtype`
  ADD PRIMARY KEY (`PubTypeId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `announcements`
--
ALTER TABLE `announcements`
  MODIFY `AnnId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `courselevel`
--
ALTER TABLE `courselevel`
  MODIFY `CourseLevelId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `CourseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `membercategory`
--
ALTER TABLE `membercategory`
  MODIFY `MemberCategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `MemberId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `ProjectId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `projectstatus`
--
ALTER TABLE `projectstatus`
  MODIFY `ProjectStatusId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `publications`
--
ALTER TABLE `publications`
  MODIFY `PubId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `pubtype`
--
ALTER TABLE `pubtype`
  MODIFY `PubTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `announcements`
--
ALTER TABLE `announcements`
  ADD CONSTRAINT `FK_Issue` FOREIGN KEY (`MemberId`) REFERENCES `members` (`MemberId`);

--
-- Constraints for table `courseparticipants`
--
ALTER TABLE `courseparticipants`
  ADD CONSTRAINT `FK_Take_Part` FOREIGN KEY (`CourseId`) REFERENCES `courses` (`CourseId`),
  ADD CONSTRAINT `FK_Take_Part2` FOREIGN KEY (`MemberId`) REFERENCES `members` (`MemberId`);

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `FK_Specifies` FOREIGN KEY (`CourseLevelId`) REFERENCES `courselevel` (`CourseLevelId`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`MemberCategoryId`) REFERENCES `membercategory` (`MemberCategoryId`);

--
-- Constraints for table `projectmembers`
--
ALTER TABLE `projectmembers`
  ADD CONSTRAINT `FK_Work_On` FOREIGN KEY (`ProjectId`) REFERENCES `projects` (`ProjectId`),
  ADD CONSTRAINT `FK_Work_On2` FOREIGN KEY (`MemberId`) REFERENCES `members` (`MemberId`);

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `FK_Defines` FOREIGN KEY (`ProjectStatusId`) REFERENCES `projectstatus` (`ProjectStatusId`);

--
-- Constraints for table `publications`
--
ALTER TABLE `publications`
  ADD CONSTRAINT `FK_Mentioned_At` FOREIGN KEY (`ProjectId`) REFERENCES `projects` (`ProjectId`),
  ADD CONSTRAINT `FK_Refers_To` FOREIGN KEY (`PubTypeId`) REFERENCES `pubtype` (`PubTypeId`);

--
-- Constraints for table `pubparticipants`
--
ALTER TABLE `pubparticipants`
  ADD CONSTRAINT `FK_Participate_In` FOREIGN KEY (`PubId`) REFERENCES `publications` (`PubId`),
  ADD CONSTRAINT `FK_Participate_In2` FOREIGN KEY (`MemberId`) REFERENCES `members` (`MemberId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
