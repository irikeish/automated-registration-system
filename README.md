# automated-registration-system
Automated-Student-Registration-System

My first Java EE Web Application developed during summer training.

It is a simple Java EE web application with two types of users namely Registrar and Councilor to automate the process of registration of a student in a particular course(C,C++,Java,J2EE,Mysql etc).
Role of a Councilor:

Fills in the details of the of student and registers the student in the desired course(s).
View the details of students registered in each course.
Delete Student Profile
Role of a Registrar:

Increase/Decrease the capacity of students registered in a particular course.
Add/Delete/Edit a course.
View the details of students registered in each course.
In home page you see details of course provided.

Libraries required:

mysql-connector-java-5.1.16.jar
Server used :Apache-Tom-cat

Instructions:
Run automated_student_registration/src/com/automated_student_registration/utility/InitDb.java
 as java application to create the database and required tables
 and create some trigger,view given in file automated_student_registration/src/com/automated_student_registration/utility/trigger.txt for creating view,automatic id generation,capacity update after each registration.





