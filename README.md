# Project Name: ASSIGNMENT 1 DUE DATE: 17 FEBRUARY 2025.

Software Engineering Project Assignment for Postgraduate Diploma Students in Software Engineering.

## Objective: Assignment Description.

Software Engineering is about managing software resources, and code is a big part of the resources you will have to manage in your life as a Software Engineer. 
The purpose of this assignment is to familiarize you with version control systems, specifically GitHub, and to demonstrate your ability to create, manage, and contribute to a software project repository. 
This assignment will also help you practice writing clear documentation and managing code commits effectively.

## Assignment Requirements.

### 1.	Create or Use an Existing GitHub Repository:
•	Create a new GitHub repository or use an existing one if you already have one that adheres to the format required.
•	The repository name should follow the format:
•	First name-last name-[number]
•	Replace your first and last names with your actual first and last names.
•	If the name is already taken, append a two-digit number (e.g., john-doe-01).

### 2.	Develop a Simple Project:
•	Choose any programming language or framework you choose (e.g., Python, JavaScript, Java, C++, etc.).
•	Develop a simple project that demonstrates basic functionality. Examples include:
•	A calculator application.
•	A "Hello World" web application.
•	A basic command-line tool.
•	A small game (e.g., Tic-Tac-Toe, Rock-Paper-Scissors).
•	Commit your code to the repository regularly. Ensure that your commits are meaningful and descriptive.

### 3.	Add a README File:
•	Include a README.md file in your repository.
•	The README file should contain:
•	A brief description of the project.
•	Instructions on how to run the project (if applicable).
•	Any dependencies or prerequisites required to run the project.
•	Screenshots or examples of the project in action (optional but encouraged).

### 4.	Submit the Repository Link:
•	Submit the URL of your GitHub repository as part of your assignment submission.

## Description of the Project: Class Register

The ClassRegister is a Java program designed to manage student information and attendance. It allows users to perform several tasks 1 to 4:
## Functions:
1. Add Student
2. Mark Attendance
3. View Register
4. Save/Load tp File (register.txt).
   
## Functionality:
### Add Student: 
- Adds a new student to the register, storing their name and student.

### Mark Attendance: 
- Records the attendance of each student in the register (present or absent).

### View Register: 
- Displays a formatted list of all students in the register, including their name, student ID, and attendance status.
  
### Save/Load to File: 
- Persists the register data to a file (register.txt) so that the data is preserved between program runs1. The file stores student names, IDs, and attendance.
  
## Structure:
- ClassRegister Class: The main class that contains the logic for managing the register. It uses an ArrayList to store Student objects.
- Student Class: A nested (inner) class that represents a student, with attributes for name, student ID, and attendance status (present/absent).
- File Storage: The program stores student data in a plain text file (register.txt), with each line representing a student and their information separated by commas.

## How it works:
### 1. Create the File (Initially): 
   The first time you run the program, the register.txt file will not exist. 
   That's fine; the program will create it when you add students and exit.
### 2. Add Students: 
   Use option 1 to add students to the register.
### 3. Mark Attendance: 
   Use option 2 to mark attendance. The available options are ###(y/n) with y-yes the student is present and ###n-no the student is absent.
### 4. View Register: 
   Use option 3 to view the register.
### 5. Exit: 
   Use option 4 to exit the program. This will save the register to the register.txt file.
### 6. Run Again: 
   When you run the program again, it will load the student data from the register.txt file.
