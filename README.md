# Library Management System

## Introduction
The Library Management System project is a Java-based database management project designed to provide an efficient and user-friendly system to manage library operations. It automates cataloging, lending, and returning books, making it easier for library staff to manage operations and for users to find and borrow books. With its simple interface and range of features, the Library Management System provides a seamless experience for both staff and users, enhancing the library's services and improving access to knowledge and information.

## Features
- User-friendly interface for easy library operation management.
- Easy book and member search and tracking.
- Automated borrowing and returning of books.
- Quick and efficient book issuing and returning process.
- User account management and borrowing history tracking for improved services.
- Fine calculation and management for overdue books.
- Management of multiple copies of the same book.
- User authentication at login for security.
- Password encryption and regular backups for data safety.
- Advanced search and filter options for easy book finding.

## Tools Used
- Java IDE (Integrated Development Environment) for coding.
- MySQL or Microsoft SQL Workbench for database design and management.
- JDBC (Java Database Connectivity) for connecting Java with MySQL database.
- Java Swing for creating the user interface.

## Hardware/Software Requirements
- Operating System: Windows XP, Vista, 8, 8.1, 10.
- Language: Java.
- IDE: NetBeans IDE.
- Storage: 4GB RAM and 120GB ROM.
- Processor: Intel Pentium 4 and above.

## Scope
The project aims to automate the existing manual library system, storing valuable data for easy access and manipulation of book records. It serves both public and private libraries, reducing human errors and improving efficiency. The global Library Management Software market is projected to see increased sales growth from 2021 to 2031 due to rising demand for library management software.

## Entity-Relationship Diagram (ERD)
![ERD](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/ERD.png)

## Dataflow Diagram
![Dataflow Diagram](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/Flow%20Diagram.png)

## Table Queries Used
- CREATE TABLE Members (ID INT PRIMARY KEY, Name VARCHAR(50), Department VARCHAR(50));
- CREATE TABLE Books (ID INT PRIMARY KEY, Name VARCHAR(50), Genre VARCHAR(50));
- CREATE TABLE Issued_Books (Issued_ID INT PRIMARY KEY, Member_ID INT, Book_ID INT, Issued_Date DATE, Return_Date DATE, FOREIGN KEY(Member_ID) REFERENCES Members(ID), FOREIGN KEY(Book_ID) REFERENCES Books(ID));
- (Additional SQL queries used for inserting, deleting, updating, and selecting data)

## Screenshots
![Screenshot 1](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot1.png)
![Screenshot 2](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot2.png)
![Screenshot 3](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot3.png)
![Screenshot 4](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot4.png)
![Screenshot 5](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot5.png)
![Screenshot 6](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot6.png)
![Screenshot 7](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot7.png)
![Screenshot 8](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot8.png)
![Screenshot 9](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot9.png)
![Screenshot 10](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing/blob/main/screenshots/screenshot10.png)

## Repository
[GitHub Repository](https://github.com/MuhammadNoman76/Library-Management-System-using-MySQL-and-Java-Swing)

