use project;
CREATE TABLE `books` (
  `ID` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ;

CREATE TABLE `display_books` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;




CREATE TABLE `login` (
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  PRIMARY KEY (`USERNAME`,`PASSWORD`)
); 



CREATE TABLE `members` (
  `ID` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `departement` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ;

CREATE TABLE `issued_books` (
  `issued_id` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`issued_id`),
  KEY `book_id_idx` (`book_id`),
  KEY `member_id_idx` (`member_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `display_books` (`id`),
  CONSTRAINT `member_id` FOREIGN KEY (`member_id`) REFERENCES `members` (`ID`)
) ;

