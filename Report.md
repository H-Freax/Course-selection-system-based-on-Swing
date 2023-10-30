# University Information Management System: New Business Model and Architectural Design
## Abstract
This report aims to provide an improved data model for university information management systems. Compared to traditional university information systems, the new model offers a more unified and efficient approach to handling large amounts of data and relationships by centralizing storage and management.

---

## Table of Contents

1. Current State Analysis

2. Proposed Solution and Advantages

3. Architectural Diagram

4. Class Diagram and New Capabilities

5. Complete Running Application

6. Overall Assessment and Future Implications

7. Conclusion

---

## 1. Current State Analysis

Traditional university data management systems are often fragmented, possibly managed by different departments or systems. For example, student information, professor information, and course information may be stored in separate databases or tables, leading to data redundancy and increased complexity in management.

### Challenges

- Fragmented data storage
- Data redundancy
- Lack of real-time data updates

---

## 2. Proposed Solution and Advantages


#### Proposed Solutions

1. **Data Encryption and Security**: Implement stronger encryption measures for the `NowPassword` field, such as using modern, secure hashing algorithms like bcrypt or Argon2.

2. **Data Validation and Integrity**: Enforce data validation rules for all input fields (e.g., `Username`, `Language`, `Rate`, etc.) to ensure data accuracy and integrity.

3. **Activity Monitoring and Auto-updating**: Automatically update the `LastActive` and `LastUpdate` fields through either application logic or database triggers.

4. **Student Evaluation System**: Introduce a student evaluation system that allows students to rate the teaching effectiveness of professors, affecting their `Rate` field.

5. **Teacher Resource Sharing**: Provide a platform for professors to upload and share teaching resources like lecture slides, papers, etc.

6. **Business Collaboration**: Collaborate with corporations and research institutions to provide internship and research opportunities, categorized via the `Region` and `Language` fields.

7. **Rating Algorithm Optimization**: Use a more complex algorithm (such as a weighted average) for calculating the `Rate` to achieve a more accurate and fair rating.

8. **Multi-Language Support**: Allow the `Language` field to store multiple languages to reflect the professor's multilingual capabilities or teaching requirements.

9. **Regional Categorization and Search**: Standardize and categorize the `Region` field for easier future data analysis and search functionalities.

#### Advantages

1. **Enhanced Security**: Strong hashing algorithms and data encryption will greatly improve data security.
  
2. **Data Accuracy**: Data validation and integrity checks will reduce errors and inconsistencies, enhancing the quality of the data.

3. **Real-time Updates**: Automatic updating of activity and update timestamps ensures that the data is always up-to-date.

4. **Accurate and Fair Ratings**: An optimized rating algorithm will more accurately reflect the professor's performance and evaluation.

5. **Diversity and Inclusivity**: Multi-language support and regional categorization not only provide more information but also cater to more diverse query requirements.

6. **Ease of Analysis and Search**: A standardized and categorized `Region` field will simplify the data analysis process and provide more accurate search results.

7. **Student Engagement**: The student evaluation system will increase student engagement and provide more feedback to both professors and educational institutions.

8. **Teacher Development**: The resource sharing platform will aid in the professional development of teachers and improve the quality of teaching.

9. **Business Opportunities**: Collaborations with corporations and feedback form employee will offer more business and research opportunities for schools and professors.

By employing these solutions and advantages, we can manage and utilize the `Professor`,  `Student`, `Employee` table more effectively, thereby enhancing the overall quality and usability of the system.

---



## 3. Architectural Diagram and Design


```

```

In this model, all people (whether employees, professors, or students) are stored in a centralized `Person` table and differentiated by a `Role` field. This is unlike traditional models, which may scatter these roles across multiple different tables or databases.


---

## 4. Class Diagram and New Capabilities

### Class Diagram
![Image](https://limyoonaxis-team.monday.com/protected_static/19437721/resources/1103091297/groupwork1.png)


In the new model, almost all tables are connected to other tables through foreign keys to ensure data referential integrity. This ensures that any updates to a table at any time will correctly reflect in other tables associated with it.


#### Database Architecture

The database uses a Relational Database Management System (RDBMS) for organizing and managing the data. MySQL is the primary database system used here.


#### 1.Person Class    

This table stores basic information related to all persons on the platform.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| PersonID | varchar(255) | Unique Identifier | Primary Key |
| PersonName | varchar(255) | Name of the person |  |
| Role | varchar(255) | Role (e.g., Student, Professor, Admin) |  |

#### Overview

The `Person` class is a Java class designed to represent individuals. It contains basic attributes such as name, ID, and role, and provides methods for saving, updating, loading, and deleting person objects in a database.

#### Attributes

- `personName (static String)`: The name of the person.
- `personID (String)`: The unique identifier for the person.
- `role (String)`: The role or position of the person.

#### Constructor

```java
public Person(String personName, String personID, String role)
```

The constructor is used to create a `Person` object and initialize the person's name, ID, and role.

#### Methods

##### Getting and Setting Attribute Values

- `getPersonName(): String`: Get the person's name.
- `setPersonName(String personName)`: Set the person's name.
- `getPersonID(): String`: Get the person's unique ID.
- `setPersonID(String personID)`: Set the person's unique ID.
- `getRole(): String`: Get the person's role.
- `setRole(String role)`: Set the person's role.

##### Database Interaction

- `saveToDatabase(Connection connection)`: Save the `Person` object to the database. Inserts a new record with the person's name, ID, and role into the database.
- `updateInDatabase(Connection connection)`: Update the information of the `Person` object in the database. Modifies the name and role based on the person's ID.
- `loadFromDatabase(Connection connection, String personID)`: Load a `Person` object from the database using the person's ID. Returns a `Person` object with the retrieved information.
- `deleteFromDatabase(Connection connection, String personID)`: Delete a specific `Person` object from the database using the person's ID.

#### Usage Examples

Here are some examples of using the `Person` class:

```java
// Create a new person object
Person person = new Person("John Doe", "12345", "Employee");

// Save the person to the database
Connection dbConnection = // Obtain a database connection
person.saveToDatabase(dbConnection);

// Load a person from the database
Person loadedPerson = Person.loadFromDatabase(dbConnection, "12345");
```

#### Notes

- Properly handle opening and closing database connections when working with a database.
- This class is a simplified example and can be extended to include more attributes and methods as needed.

---
#### 2. Employee Class

This table stores information related to employees, such as username and password.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| ID | varchar(255) | Unique Identifier for Employee | Foreign Key (Person) |
| Username | varchar(255) | Username |  |
| NowPassword | varchar(255) | Current Hashed Password |  |
| Enabled | varchar(255) | Is Enabled (e.g., 'Yes', 'No') |  |
| LastActive | timestamp | Last Active Timestamp |  |
| LastUpdate | timestamp | Last Update Timestamp |  |

#### Overview

The `Employee` class is a Java class for representing employees, extending from the `Person` class. In addition to the basic attributes such as name, ID, and role from `Person`, it also includes username, hashed password, enabled status, last active timestamp, and last updated timestamp. The class provides methods for interacting with the database.

#### Attributes

- `ID (String)`: Unique identifier for the employee, a foreign key pointing to `personID` in `Person`.
- `username (String)`: Username of the employee.
- `hashedPassword (String)`: Hashed password of the employee.
- `enabled (String)`: Indicates whether the employee is enabled.
- `lastActive (Timestamp)`: Timestamp of the last activity.
- `lastUpdate (Timestamp)`: Timestamp of the last update.

#### Constructors

```java
public Employee(String ID, String username, String hashedPassword, String enabled, Timestamp lastActive, Timestamp lastUpdate)
```

Constructor to create an `Employee` object and initialize all its attributes.

#### Methods

##### Getters and Setters

- `getID(): String`: Gets the unique ID of the employee.
- `setID(String ID)`: Sets the unique ID of the employee.
- `getUsername(): String`: Gets the username of the employee.
- `setUsername(String username)`: Sets the username of the employee.
- `getHashedPassword(): String`: Gets the hashed password of the employee.
- `setHashedPassword(String hashedPassword)`: Sets the hashed password of the employee.
- `getEnabled(): String`: Gets whether the employee is enabled.
- `setEnabled(String enabled)`: Sets whether the employee is enabled.
- `getLastActive(): Timestamp`: Gets the last active timestamp of the employee.
- `setLastActive(Timestamp lastActive)`: Sets the last active timestamp of the employee.
- `getLastUpdate(): Timestamp`: Gets the last updated timestamp of the employee.
- `setLastUpdate(Timestamp lastUpdate)`: Sets the last updated timestamp of the employee.

##### Database Interaction

- `saveToDatabase(Connection connection)`: Saves the `Employee` object to the database. Inserts all attributes as a new record into the database.
- `updateInDatabase(Connection connection)`: Updates the `Employee` object information in the database. Modifies other attributes based on the employee's ID.
- `loadFromDatabase(Connection connection, String ID)`: Loads the `Employee` object using the employee’s ID from the database. Returns an `Employee` object with the retrieved information.
- `deleteFromDatabase(Connection connection, String ID)`: Deletes a specific `Employee` object using the employee’s ID from the database.

#### Usage Example

```java
// Create a new employee object
Employee employee = new Employee("12345", "johndoe", "hashedPassword123", "enabled", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));

// Save the employee to the database
Connection dbConnection = // Get database connection
employee.saveToDatabase(dbConnection);

// Load the employee from the database
Employee loadedEmployee = Employee.loadFromDatabase(dbConnection, "12345");
```

#### Note

- Properly handle opening and closing of the database connection when interacting with the database.
- This class is a simplified example and can be extended to include more attributes and methods as needed.

---

#### 3. Historypwd Table

This table stores password history information related to all persons on the platform.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| PersonID | varchar(255) | Unique Identifier for Person | Foreign Key (Person) |
| Password | varchar(255) | Old Hashed Password |  |
#### Overview

The `Historypwd` table is a database table used for recording password history. It is linked with the `Person` table and stores the password history associated with specific individuals. This can be useful for implementing security policies like password complexity or password change history.

#### Fields

- `PersonID (varchar(255))`: The unique identifier for the individual related to the password history, a foreign key pointing to `personID` in the `Person` table.
- `Password (varchar(255))`: The hashed password stored in the history.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Historypwd (PersonID, Password) VALUES (?, ?)`: Inserts a new password history record into the `Historypwd` table.

##### Data Retrieval

- `SELECT * FROM Historypwd WHERE PersonID = ?`: Queries the password history related to a specified `PersonID`.

##### Data Deletion

- `DELETE FROM Historypwd WHERE PersonID = ? AND Password = ?`: Deletes a specific password history record based on the specified `PersonID` and `Password`.

#### Usage Example

```sql
-- Insert a new password history record
INSERT INTO Historypwd (PersonID, Password) VALUES ('12345', 'hashedPassword123');

-- Query the password history for a specific individual
SELECT * FROM Historypwd WHERE PersonID = '12345';
```

#### Note

- Properly handle opening and closing of the database connection when interacting with the database.
- This table is a simplified example and can be extended to include more fields and operations as needed.

---

#### 4. Professor Table

This table stores information related to professors.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| ID | varchar(255) | Unique Identifier for Professor | Foreign Key (Person) |
| Username | varchar(255) | Username |  |
| NowPassword | varchar(255) | Current Hashed Password |  |
| Language | varchar(255) | Language of Teaching |  |
| Enabled | varchar(255) | Is Enabled |  |
| Rate | double | Average Rating of Professor |  |
| Region | varchar(255) | Geographical Location or Office |  |
| LastActive | timestamp | Last Active Timestamp |  |
| LastUpdate | timestamp | Last Update Timestamp |  |

#### Overview

The `Professor` table is a database table used for storing information about professors. It is linked with the `Person` table through a foreign key and primarily records the username, password, language, enablement status, rating, region, and the last active and updated timestamps for the professor.

#### Fields

- `ID (varchar(255))`: The unique identifier for the professor, a foreign key pointing to `personID` in the `Person` table.
- `Username (varchar(255))`: The username for the professor.
- `NowPassword (varchar(255))`: The hashed password for the professor.
- `Language (varchar(255))`: The language associated with the professor.
- `Enabled (varchar(255))`: Indicates whether the professor is enabled or not.
- `Rate (double)`: The rating for the professor.
- `Region (varchar(255))`: The region where the professor is based.
- `LastActive (timestamp)`: The last active timestamp.
- `LastUpdate (timestamp)`: The last updated timestamp.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Professor (ID, Username, NowPassword, Language, Enabled, Rate, Region, LastActive, LastUpdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`: Inserts a new professor record into the `Professor` table.

##### Data Retrieval

- `SELECT * FROM Professor WHERE ID = ?`: Retrieves information about a professor based on the specified `ID`.

##### Data Update

- `UPDATE Professor SET Field = ? WHERE ID = ?`: Updates a certain field for a professor record based on the specified `ID`.

##### Data Deletion

- `DELETE FROM Professor WHERE ID = ?`: Deletes a specific professor record based on the specified `ID`.

#### Usage Example

```sql
-- Insert a new professor record
INSERT INTO Professor (ID, Username, NowPassword, Language, Enabled, Rate, Region, LastActive, LastUpdate) VALUES ('12345', 'ProfJohn', 'hashedPassword123', 'English', 'Enabled', 4.5, 'USA', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Retrieve information for a specific professor
SELECT * FROM Professor WHERE ID = '12345';
```

#### Note

- Properly handle opening and closing of the database connection when interacting with the database.
- This table is a simplified example and can be extended to include more fields and operations as needed.

---

#### 5. Student Table

This table stores information related to students.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| ID | varchar(255) | Unique Identifier for Student | Foreign Key (Person) |
| Username | varchar(255) | Username |  |
| NowPassword | varchar(255) | Current Hashed Password |  |
| Enabled | varchar(255) | Is Enabled |  |
| GPA | double | Grade Point Average |  |
| LastActive | timestamp | Last Active Timestamp |  |
| LastUpdate | timestamp | Last Update Timestamp |  |
#### Overview

The `Student` table is designed to store detailed information about students. It is related to the `Person` table through a foreign key and primarily holds records of the student's username, hashed password, enabled status, Grade Point Average (GPA), and timestamps for last activity and last update.

#### Fields

- `ID (varchar(255))`: A unique identifier for the student, which is a foreign key pointing to the `Person` table.
- `Username (varchar(255))`: The username of the student.
- `NowPassword (varchar(255))`: The hashed password for the student.
- `Enabled (varchar(255))`: Indicates whether the student's account is enabled.
- `GPA (double)`: The Grade Point Average of the student.
- `LastActive (timestamp)`: The timestamp for the student's last activity.
- `LastUpdate (timestamp)`: The timestamp for the last update of the student's information.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Student (ID, Username, NowPassword, Enabled, GPA, LastActive, LastUpdate) VALUES (?, ?, ?, ?, ?, ?, ?)`: Inserts a new record into the `Student` table.

##### Data Query

- `SELECT * FROM Student WHERE ID = ?`: Retrieves information related to a student based on the unique identifier (ID).

##### Data Update

- `UPDATE Student SET Field = ? WHERE ID = ?`: Updates a specific field for a student record based on the unique identifier (ID).

##### Data Deletion

- `DELETE FROM Student WHERE ID = ?`: Deletes a specific student record based on the unique identifier (ID).

#### Example Usage

```sql
-- Insert a new student record
INSERT INTO Student (ID, Username, NowPassword, Enabled, GPA, LastActive, LastUpdate) VALUES ('54321', 'StudentJane', 'hashedPassword321', 'Enabled', 3.5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Query all information of a specific student
SELECT * FROM Student WHERE ID = '54321';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- This table serves as a simplified example and can be extended to include more fields and features as needed.

---

#### 6. Semester Table

This table stores information related to semesters.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| ID | varchar(255) | Unique Identifier for Semester | Primary Key |
| SemesterName | varchar(255) | Name of the Semester (e.g., 'Fall 2021') |  |
| SemesterStart | timestamp | Start Date of Semester |  |
| SemesterEnd | timestamp | End Date of Semester |  |

#### Overview

The `Semester` table is designed to store information related to academic semesters. It primarily holds records of the unique identifier for the semester, its name, start date, and end date.

#### Fields

- `ID (varchar(255))`: A unique identifier for the semester.
- `SemesterName (varchar(255))`: The name of the semester.
- `SemesterStart (timestamp)`: The start date for the semester.
- `SemesterEnd (timestamp)`: The end date for the semester.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Semester (ID, SemesterName, SemesterStart, SemesterEnd) VALUES (?, ?, ?, ?)`: Inserts a new record into the `Semester` table.

##### Data Query

- `SELECT * FROM Semester WHERE ID = ?`: Retrieves information related to a semester based on its unique identifier (ID).

##### Data Update

- `UPDATE Semester SET Field = ? WHERE ID = ?`: Updates a specific field for a semester record based on its unique identifier (ID).

##### Data Deletion

- `DELETE FROM Semester WHERE ID = ?`: Deletes a specific semester record based on its unique identifier (ID).

#### Example Usage

```sql
-- Insert a new semester record
INSERT INTO Semester (ID, SemesterName, SemesterStart, SemesterEnd) VALUES ('Fall2023', 'Fall 2023', '2023-09-01 00:00:00', '2023-12-31 23:59:59');

-- Query all information of a specific semester
SELECT * FROM Semester WHERE ID = 'Fall2023';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- This table serves as a simplified example and can be extended to include more fields and features as needed.

---

#### 7. Course Table

This table stores information related to courses.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| ID | varchar(255) | Unique Identifier for Course | Primary Key |
| SemesterID | varchar(255) | Unique Identifier for Semester | Foreign Key (Semester) |
| Name | varchar(255) | Name of the Course |  |
| Introduction | varchar(255) | Course Description |  |
| Point | integer | Credit Points |  |
| Location | varchar(255) | Location for the Course |  |
| Status | varchar(255) | Status of the Course (e.g., 'Open', 'Closed') |  |
| StudentLimited | integer | Maximum Student Capacity |  |
| StudentCount | integer | Current Number of Students |  |
| BeginTime | timestamp | Course Start Time |  |
| EndTime | timestamp | Course End Time |  |

#### Overview

The `Course` table is designed to store information related to courses. It includes fields for the unique identifier of the course, associated semester, name, introduction, credits, location, status, student limit, current student count, start time, and end time.

#### Fields

- `ID (varchar(255))`: The unique identifier for the course.
- `SemesterID (varchar(255))`: The unique identifier for the semester to which the course belongs, foreign key pointing to the `Semester` table.
- `Name (varchar(255))`: The name of the course.
- `Introduction (varchar(255))`: A brief introduction or description of the course.
- `Point (integer)`: The number of credits the course is worth.
- `Location (varchar(255))`: The location or venue of the course.
- `Status (varchar(255))`: The current status of the course.
- `StudentLimited (integer)`: The maximum number of students allowed in the course.
- `StudentCount (integer)`: The current number of enrolled students in the course.
- `BeginTime (timestamp)`: The start time of the course.
- `EndTime (timestamp)`: The end time of the course.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Course (...) VALUES (...)`: Inserts a new record into the `Course` table.

##### Data Query

- `SELECT * FROM Course WHERE ID = ?`: Retrieves information related to a course based on its unique identifier (ID).

##### Data Update

- `UPDATE Course SET Field = ? WHERE ID = ?`: Updates a specific field for a course record based on its unique identifier (ID).

##### Data Deletion

- `DELETE FROM Course WHERE ID = ?`: Deletes a specific course record based on its unique identifier (ID).

#### Example Usage

```sql
-- Insert a new course record
INSERT INTO Course (ID, SemesterID, Name, Introduction, Point, Location, Status, StudentLimited, StudentCount, BeginTime, EndTime) VALUES ('CS101', 'Fall2023', 'Computer Science 101', 'Introduction to Computer Science', 3, 'Room 201', 'Open', 50, 0, '2023-09-01 09:00:00', '2023-12-20 09:00:00');

-- Query all information of a specific course
SELECT * FROM Course WHERE ID = 'CS101';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- This table serves as a simplified example and can be extended to include more fields and features as needed.
---

#### 8. CourseSchedule Table

This table stores information related to the course timetable.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| Weekday | varchar(255) | Day of the Week (e.g., 'Monday', 'Tuesday') |  |
| StartTime | timestamp | Class Start Time |  |
| EndTime | timestamp | Class End Time |  |

#### Overview

The `CourseSchedule` table is designed to store information related to the timing and scheduling of courses. This table records the unique identifier for the course (foreign key pointing to the `Course` table), the weekday on which the course is held (e.g., Monday, Tuesday, etc.), the start time, and the end time for each session.

#### Fields

- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to the `Course` table.
- `Weekday (varchar(255))`: The weekday on which the course is held (e.g., Monday, Tuesday, etc.).
- `StartTime (timestamp)`: The start time for the course session.
- `EndTime (timestamp)`: The end time for the course session.

#### Primary Operations

##### Data Insertion

- `INSERT INTO CourseSchedule (...) VALUES (...)`: Inserts a new scheduling record into the `CourseSchedule` table.

##### Data Query

- `SELECT * FROM CourseSchedule WHERE Course_ID = ?`: Retrieves the scheduling information related to a specific course based on its unique identifier (Course_ID).

##### Data Update

- `UPDATE CourseSchedule SET Field = ? WHERE Course_ID = ? AND Weekday = ?`: Updates specific fields for a course schedule record based on its unique identifier (Course_ID) and the weekday.

##### Data Deletion

- `DELETE FROM CourseSchedule WHERE Course_ID = ? AND Weekday = ?`: Deletes a specific scheduling record based on its unique identifier (Course_ID) and the weekday.

#### Example Usage

```sql
-- Insert a new scheduling record
INSERT INTO CourseSchedule (Course_ID, Weekday, StartTime, EndTime) VALUES ('CS101', 'Monday', '2023-09-01 09:00:00', '2023-09-01 10:00:00');

-- Query all scheduling information of a specific course
SELECT * FROM CourseSchedule WHERE Course_ID = 'CS101';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- This table serves as a simplified example and can be extended to include more fields and features as needed.

---

#### 9. PersonSchedule Table

This table stores information related to personal class timetables.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| SemesterID | varchar(255) | Unique Identifier for Semester | Foreign Key (Semester) |
| StartTime | timestamp | Class Start Time |  |
| EndTime | timestamp | Class End Time |  |
| PersonID | varchar(255) | Unique Identifier for Person | Foreign Key (Person) |

#### Overview

The `PersonSchedule` table is designed to store information related to individual course schedules. This table records the unique identifier for the course (foreign key pointing to the `Course` table), the unique identifier related to the semester (foreign key pointing to the `Semester` table), the start and end times for each session, and the unique identifier related to the person (foreign key pointing to the `Person` table).

#### Fields

- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to the `Course` table.
- `SemesterID (varchar(255))`: The unique identifier related to the semester, foreign key pointing to the `Semester` table.
- `StartTime (timestamp)`: The start time for the course session.
- `EndTime (timestamp)`: The end time for the course session.
- `PersonID (varchar(255))`: The unique identifier related to the person, foreign key pointing to the `Person` table.

#### Primary Operations

##### Data Insertion

- `INSERT INTO PersonSchedule (...) VALUES (...)`: Inserts a new schedule record into the `PersonSchedule` table.

##### Data Query

- `SELECT * FROM PersonSchedule WHERE PersonID = ?`: Retrieves the schedule information related to a specific person based on their unique identifier (PersonID).

##### Data Update

- `UPDATE PersonSchedule SET Field = ? WHERE PersonID = ? AND Course_ID = ?`: Updates specific fields for a schedule record based on its unique identifier (PersonID) and the course ID.

##### Data Deletion

- `DELETE FROM PersonSchedule WHERE PersonID = ? AND Course_ID = ?`: Deletes a specific schedule record based on its unique identifier (PersonID) and the course ID.

#### Example Usage

```sql
-- Insert a new schedule record
INSERT INTO PersonSchedule (Course_ID, SemesterID, StartTime, EndTime, PersonID) VALUES ('CS101', '2023Fall', '2023-09-01 09:00:00', '2023-09-01 10:00:00', '12345');

-- Query all schedule information of a specific person
SELECT * FROM PersonSchedule WHERE PersonID = '12345';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- This table serves as a simplified example and can be extended to include more fields and features as needed.

---

#### 10. CourseTopic Table

This table stores information related to topics associated with courses.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| Topic | varchar(255) | Topic associated with the Course (e.g., 'Mathematics', 'Computer Science') |  |

#### Overview

The `CourseTopic` table is designed to store information related to topics that are associated with courses. This table includes the unique identifier for the course (foreign key pointing to the `Course` table) and the topic related to the course.

#### Fields

- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to the `Course` table.
- `Topic (varchar(255))`: The topic related to the course.

#### Primary Operations

##### Data Insertion

- `INSERT INTO CourseTopic (Course_ID, Topic) VALUES (?, ?)`: Inserts a new record into the `CourseTopic` table.

##### Data Query

- `SELECT * FROM CourseTopic WHERE Course_ID = ?`: Retrieves the topic(s) related to a specific course based on its unique identifier.

##### Data Deletion

- `DELETE FROM CourseTopic WHERE Course_ID = ? AND Topic = ?`: Deletes a specific record based on its course unique identifier and topic.

#### Example Usage

```sql
-- Insert a new course-topic record
INSERT INTO CourseTopic (Course_ID, Topic) VALUES ('CS101', 'Data Structures');

-- Query all topics related to a specific course
SELECT * FROM CourseTopic WHERE Course_ID = 'CS101';
```

---
#### 11. ProfessorTopic Table

This table stores information related to topics that professors specialize in or are associated with.

| Field Name    | Data Type    | Description                                         | Constraint                 |
|---------------|--------------|-----------------------------------------------------|-----------------------------|
| Professor_ID  | varchar(255) | Unique Identifier for Professor                     | Foreign Key (Professor)     |
| Topic         | varchar(255) | Topic associated with the Professor (e.g., 'Mathematics', 'Computer Science') |                             |

#### Overview

The `ProfessorTopic` table is used for storing topics related to specific professors. Each record is associated with the `Professor` table via a foreign key.

#### Fields

- `Professor_ID (varchar(255))`: The unique identifier for the professor, a foreign key pointing to the `Professor` table.
- `Topic (varchar(255))`: The topic related to the professor.

#### Primary Operations

##### Data Insertion

- `INSERT INTO ProfessorTopic (Professor_ID, Topic) VALUES (?, ?)`: Inserts a new topic related to a specific professor into the table.

##### Data Retrieval

- `SELECT * FROM ProfessorTopic WHERE Professor_ID = ?`: Retrieves all topics related to a professor based on their unique identifier.

##### Data Deletion

- `DELETE FROM ProfessorTopic WHERE Professor_ID = ? AND Topic = ?`: Deletes a record related to a specific professor and topic.

#### Usage Example

```sql
-- Insert a new record
INSERT INTO ProfessorTopic (Professor_ID, Topic) VALUES ('12345', 'Computer Science');

-- Retrieve all topics for a specific professor
SELECT * FROM ProfessorTopic WHERE Professor_ID = '12345';
```

#### Note

- This table primarily serves to record the areas of expertise or teaching topics for professors.
- Properly handle opening and closing of the database connection when interacting with the database.

---


#### 12. CourseProfessor Table

This table stores information related to the association between courses and professors.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| Professor_ID | varchar(255) | Unique Identifier for Professor | Foreign Key (Professor) |
#### Overview

The `CourseProfessor` table is designed to store information related to the relationship between courses and professors. This table includes the unique identifier for the course (foreign key pointing to the `Course` table) and the unique identifier for the professor (foreign key pointing to the `Professor` table).

#### Fields

- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to the `Course` table.
- `Professor_ID (varchar(255))`: The unique identifier for the professor, foreign key pointing to the `Professor` table.

#### Primary Operations

##### Data Insertion

- `INSERT INTO CourseProfessor (Course_ID, Professor_ID) VALUES (?, ?)`: Inserts a new record into the `CourseProfessor` table.

##### Data Query

- `SELECT * FROM CourseProfessor WHERE Course_ID = ? OR Professor_ID = ?`: Retrieves records related to a specific course or professor based on their unique identifiers.

##### Data Deletion

- `DELETE FROM CourseProfessor WHERE Course_ID = ? AND Professor_ID = ?`: Deletes a specific record based on its course and professor unique identifiers.

#### Example Usage

```sql
-- Insert a new course-professor relationship record
INSERT INTO CourseProfessor (Course_ID, Professor_ID) VALUES ('CS101', 'P123');

-- Query all professors related to a specific course
SELECT * FROM CourseProfessor WHERE Course_ID = 'CS101';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- These tables serve as simplified examples and can be extended to include more fields and features as needed.
- 
---

#### 13.CourseStudent Table

This table stores information related to the association between courses and students.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| Student_ID | varchar(255) | Unique Identifier for Student | Foreign Key (Student) |
| Score | double | Score of the Student in the Course |  |
#### Overview

The `CourseStudent` table is designed to store information related to the relationship between courses and students. This table includes the unique identifier for the course (foreign key pointing to the `Course` table), the unique identifier for the student (foreign key pointing to the `Student` table), and the score the student has achieved in the course.

#### Fields

- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to the `Course` table.
- `Student_ID (varchar(255))`: The unique identifier for the student, foreign key pointing to the `Student` table.
- `Score (double)`: The score achieved by the student in the course.

#### Primary Operations

##### Data Insertion

- `INSERT INTO CourseStudent (Course_ID, Student_ID, Score) VALUES (?, ?, ?)`: Inserts a new record into the `CourseStudent` table.

##### Data Query

- `SELECT * FROM CourseStudent WHERE Course_ID = ? OR Student_ID = ?`: Retrieves records related to a specific course or student based on their unique identifiers.

##### Data Update

- `UPDATE CourseStudent SET Score = ? WHERE Course_ID = ? AND Student_ID = ?`: Updates the score for a specific student in a specific course.

##### Data Deletion

- `DELETE FROM CourseStudent WHERE Course_ID = ? AND Student_ID = ?`: Deletes a specific record based on its course and student unique identifiers.

#### Example Usage

```sql
-- Insert a new course-student relationship record with the score
INSERT INTO CourseStudent (Course_ID, Student_ID, Score) VALUES ('CS101', 'S123', 95);

-- Query all students and their scores related to a specific course
SELECT * FROM CourseStudent WHERE Course_ID = 'CS101';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- These tables serve as simplified examples and can be extended to include more fields and features as needed.
---

#### 14. Rate Table

This table stores information related to ratings and reviews for professors.

| Field Name | Data Type | Description | Constraint |
|------------|-----------|-------------|------------|
| Professor_ID | varchar(255) | Unique Identifier for Professor | Foreign Key (Professor) |
| Student_ID | varchar(255) | Unique Identifier for Student | Foreign Key (Student) |
| Course_ID | varchar(255) | Unique Identifier for Course | Foreign Key (Course) |
| ScorePart1 | varchar(255) | Rating Part 1 (e.g., 'Teaching Quality') |  |
| ScorePart2 | varchar(255) | Rating Part 2 (e.g., 'Responsiveness') |  |
| ScorePart3 | varchar(255) | Rating Part 3 (e.g., 'Clarity') |  |
| ScorePart4 | varchar(255) | Rating Part 4 (e.g., 'Engagement') |  |
| Comment | varchar(255) | Review or Comment |  |
| Score | varchar(255) | Total Rating |  |

#### Overview

The `Rate` table is designed to store ratings and reviews that students give to professors. This table includes the unique identifiers for the professor (foreign key pointing to `Professor` table), the student (foreign key pointing to `Student` table), and the course (foreign key pointing to `Course` table), along with various scores and comments.

#### Fields

- `Professor_ID (varchar(255))`: The unique identifier for the professor, foreign key pointing to `Professor` table.
- `Student_ID (varchar(255))`: The unique identifier for the student, foreign key pointing to `Student` table.
- `Course_ID (varchar(255))`: The unique identifier for the course, foreign key pointing to `Course` table.
- `ScorePart1 (varchar(255))`: Score part 1.
- `ScorePart2 (varchar(255))`: Score part 2.
- `ScorePart3 (varchar(255))`: Score part 3.
- `ScorePart4 (varchar(255))`: Score part 4.
- `Comment (varchar(255))`: Comments on the rating.
- `Score (varchar(255))`: Overall score.

#### Primary Operations

##### Data Insertion

- `INSERT INTO Rate (Professor_ID, Student_ID, Course_ID, ScorePart1, ScorePart2, ScorePart3, ScorePart4, Comment, Score) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`: Inserts a new rating record into the `Rate` table.

##### Data Query

- `SELECT * FROM Rate WHERE Professor_ID = ? OR Student_ID = ? OR Course_ID = ?`: Retrieves rating records related to a specific professor, student, or course based on their unique identifiers.

##### Data Update

- `UPDATE Rate SET Comment = ?, Score = ? WHERE Professor_ID = ? AND Student_ID = ? AND Course_ID = ?`: Updates the comments and overall score of a specific rating.

##### Data Deletion

- `DELETE FROM Rate WHERE Professor_ID = ? AND Student_ID = ? AND Course_ID = ?`: Deletes a specific rating record.

#### Example Usage

```sql
-- Insert a new rating record
INSERT INTO Rate (Professor_ID, Student_ID, Course_ID, ScorePart1, ScorePart2, ScorePart3, ScorePart4, Comment, Score) VALUES ('P123', 'S123', 'CS101', '5', '4', '5', '5', 'Excellent', '19');

-- Query all ratings related to a specific professor
SELECT * FROM Rate WHERE Professor_ID = 'P123';
```

#### Note

- Properly manage the opening and closing of database connections when performing database operations.
- These tables serve as simplified examples and can be extended to include more fields and features as needed.

---
### Foreign Key Relationships

To maintain data referential integrity, multiple foreign key relationships exist between the tables. These relationships have been outlined above in the table designs.


---


## 5.Complete Running Application

### **Login Area**:

#### 1. Login Page:
- **UserName**: Allows users to input their username.
- **Password**: Allows users to input their password.
- **User Type Selection**: Users can choose their role, e.g., Admin, Faculty, or Student.
- **Login Button**: Click to log in.
- **Register Button**: Click to register if the user does not have an account.

#### 2.Validation Page:
- **Person Id**: Input for the user's ID.
- **Person Name**: Input for the user's name.
- **User Type Selection**: Similar to the login page, users can choose their role.
- **Register Button**: Click to complete registration.
- **Back Button**: Click to return to the previous page.

#### 3.Create Account :
- **Username**: Input for the username.
- **Password**: Input for the user's password.
- **Create**: Click to create user's account

---

### **Business WorkArea**:

#### 1. Left Navigation Panel:

  - **Universal ComboxArea**: Click to view your course timetable.
  - **Manage Courses**: Enter the course management page to view, create, and edit courses.
  - **Manage Student**: Enter the student management page to view, create, and edit courses.
  - **Rate Chart**: View and edit your personal information.
  - **Ranking**: View your teaching ranking or evaluations.
  - **Log out**: Click to log out of the system.

#### 2. Universal ComboxArea:

 - **CourseComboBoxAreaJPanel**: Click to view details and manage your courses.

- **CourseScheduleComboBoxAreaJPanel**: Access the platform to view, adjust, or update the course schedules.

- **EmployeeComboBoxAreaJPanel**: Navigate to the employee management page to oversee, add, or modify employee data.

- **FacultyComboBoxAreaJPanel**: Engage with the faculty management area to network, share, or gather faculty-specific resources.

- **PersonComboBoxAreaJPanel**: Access and edit individual information or connect with others on the platform.

- **PersonScheduleComboBoxAreaJPanel**: View and make changes to your personal schedule or appointments.

- **RateComboBoxAreaJPanel**: Navigate to view or modify rates, perhaps related to courses or services.

- **SemesterComboBoxAreaJPanel**: Access to view, plan, or modify academic semester details.

- **StudentComboBoxAreaJPanel**: Enter the student section to oversee, communicate, or modify student data.

#### 3. FacultyManagementJPanel:

Engage with the faculty management panel to oversee, collaborate, and manage faculty-related activities and resources.

#### 4. StudentManagementJPanel:

Access the student management area to oversee, communicate with, or make necessary modifications to student profiles, data, or academic status.

#### 5. RateChartJPanel:

Navigate through this panel to view, analyze, or adjust the rate charts, possibly related to course fees, faculty compensation, or other services.

---

### **Faculty WorkArea**:

#### 1. Left Navigation Panel:
- **Left Navigation Panel**:
  - **Schedule**: Click to view your course timetable.
  - **Manage Courses**: Enter the course management page to view, create, and edit courses.
  - **Manage Student**: Click to manage student information related to you.
  - **My Profile**: View and edit your personal information.
  - **Ranking**: View your teaching ranking or evaluations.
  - **Log out**: Click to log out of the system.

#### 2. MyScheduleJPanel:

**Dropdown Menu**: Allows the user to select the desired semester. 
**Information Label**: Displays the semester's time range. 

**Table**:
- **Course Name**: Lists the names of the courses for the selected semester.
- **Location**: Provides the room or venue where the course will take place.
- **Course Time**: Specifies the days and times the courses will be held.
- **Semester**: Indicates the academic semester for the listed courses.
- 
**Button**:
- **Add To Calendar**: Allows the user to add the displayed courses to their personal calendar.

#### 3. ManageCoursesJPanel:

**Tabs**:
- **Current Course**: Displays the current courses for a selected semester.
- **Create Course**: Allows users to create a new course.

**Dropdown Menu**:
- **Select Semester**: Enables the user to select the desired semester to view the courses.

**Table (Current Course Tab)**:
- **Course ID**: Lists the ID of the courses.
- **Course Name**: Specifies the name of each course.
- **Course Topic**: Describes the main subject or topic of each course.
- **Time**: Provides the timing details for each course.

**Search Bar**:
- **Course Name/Course Topic**: Allows users to search for courses based on name or topic.
- 
**Form Fields (Both Tabs)**:
- **Course ID**: Input for the course's identification number.
- **Course Location**: Input for the location or room where the course will be conducted.
- **Course Topic**: Input for the main subject or topic of the course.
- **Course Name**: Input for the name of the course.
- **Course point**: Input for the credit or point value of the course.
- **Course Begintime**: Input for the start time of the course.
- **Course Endtime**: Input for the end time of the course.
- **Student Limited**: Input for the maximum number of students allowed in the course.
- **Student Count**: Input to display the current number of enrolled students.
- **Semester**: Input for the academic semester.
- **Course Introduction**: Text area to provide a detailed introduction or description of the course.
- **Professor**: Input for the name of the course instructor.
- **Professor Rating in this class**: Input to display or update the professor's rating for this particular course.

**Student List (Current Course Tab)**:
- Columns for **Student Name**, **Student NUID**, and **Student Score**. Allows for viewing and editing student details for a specific course.

**Buttons**:
- **Search**: Initiates the search based on the input in the search bar.
- **Save**: Saves any changes made to course details.
- **Create** (in Create Course Tab): Creates a new course based on the inputted details.
- **View** (in Create Course Tab): Views the created or updated course details.

---

#### 4.ManageStudentJPanel

**Search Section**:
- **Search Bar**: Allows users to input search criteria.
- **Search Button**: Initiates the search based on the criteria entered in the search bar.

**Student Listing**:
- **Student ID**: Displays the unique identification number of the student.
- **Student Name**: Shows the full name of the student.
- **If Choose my course**: Checkbox indicating if the student has chosen the user's course.

**Student Details Section**:
- **Student Name**: Input field for the student's full name.
- **Student ID**: Input field for the student's unique identification number.
- **Student GPA**: Input field for the student's Grade Point Average.
- **View Button**: Allows users to view detailed information about the student.
- **Information Label**: A label that informs users they can only view details about their own students.

#### 5.MyProfileJPanel

**Personal Information**:
- **Professor ID**: Displays the unique identification number of the professor.
- **Professor Name**: Shows the full name of the professor.
- **Professor Language**: Indicates the language proficiency or preferred language of the professor.
- 
**Courses Taught**:
- **Course Name**: Lists the name of the courses taught by the professor.
- **Course Time**: Shows the scheduled time for each course.
- **Course Rating**: Provides the average rating or feedback score given to the course by students.
- 
**Rating and Region**:
- **Professor Rate**: Displays the overall rating or feedback score given to the professor by students.
- **Professor Region**: Indicates the geographical region or campus location where the professor is based.

**Login Credentials**:
- **Username**: Shows the username used by the professor to log into the system.
- **Professor Password**: Input field for the professor's password.

**Action Button**:
- **Save**: Button to save any changes or updates made to the profile.

---

#### 6.RankingJPanel
- **My Profile Page:**
  - **Professor's Personal Details**: Contains fields for professor ID, name, preferred language, region (possibly the teaching region or campus), username, and password. 
    - *Note*: Displaying raw passwords is a security concern. This should be hidden and replaced with a 'Change Password' option.
  - **Courses Table**: Displays courses taught by the professor, along with course region and rating.

- **Ranking Page:**
  - This section would showcase professor rankings based on metrics like course feedback, possibly student feedback, or other KPIs. There's a column for professor name, score, and course rankings. A "View" button suggests a more detailed breakdown when clicked.

### **Student WorkArea**:

**1. Course Page:**
- Displays a list of courses the student is currently enrolled in, with details like Course ID, Course Name, Professor, Course Status, and Score.
- Provides an option to filter courses based on various criteria like Semester, Professor's Name, Language, Region, and Course Topic.
- Also has fields to view more detailed information about each course, such as Course Location, Begin and End Time, and more.

**2. Registration Page:**
- A student can search for courses based on criteria like Course Name, Professor's Name, Type, Language, and Region.
- Detailed course information is displayed below the search bar.
- The student has an option to enroll in a course.

**3. My Student Profile Page:**
- Displays the student's information, including Student ID and Name.
- Lists all courses the student is enrolled in, with information about the course, professor, semester, and score.
- There's a section to update personal details such as the username and password.

**4. Graduation Page:**
- Provides information on the student's graduation status.
- States that a student needs to complete eight courses before graduation.
- Contains a button to check graduation status and another to apply for graduation.

**5. Transcript Page:**
- Displays a list of courses the student has taken, with the corresponding score and semester.
- Provides a GPA score.

---


## 6. Overall Assessment of the Digital Educational Platform

1. **User Interface (UI) Design:** The design is simplistic and straightforward. The use of tabs and sections makes it easy for students, professors, employee to navigate through their profiles and perform necessary tasks. 

2. **Functionality:** The platform seems to offer essential functions required by students and professors:
   - **Manage Courses**:Professor can create, pubblish, edit and delete courses, courses details.
   - **My Schedule**:Choose your semester and directly show all informarion you need, eeven add to your Calender.
   - **Manage Student**:Through entering keywords to search for students, display student informations.
   - **Course Registration**: Students can view available courses, course details, and enroll in them.
   - **Profile Management**: Personal information, courses taken, and other relevant data can be viewed and edited.
   - **Graduation Status**: This gives students an idea of their progress towards degree completion.
   - **Transcript**: It provides an organized view of grades from different semesters.
   - **Rate**:This section would showcase professor rankings based on metrics like course feedback, possibly student feedback, or other KPIs.

3. **Language and Region Customization:** The platform appears to consider language and regional preferences for both courses and professors, which can be beneficial for international students or those seeking courses in specific languages.

**Opinion on Future Digital Educational Platforms:**

If designed and implemented effectively, digital educational platforms can have a significant positive impact on making education more accessible and affordable.

1. **Accessibility:** 
   - **Geographic Barriers**: Digital platforms remove geographic barriers, allowing students from remote areas to access quality education.
   - **Flexibility**: They cater to different learning paces and schedules, benefiting working students or those with other commitments.
   - **Diverse Offerings**: Online platforms can host a plethora of courses from various fields, giving students a wider range of options.

2. **Affordability:** 
   - **Reduced Costs**: There are fewer overhead costs associated with digital platforms compared to traditional educational settings, potentially leading to reduced tuition fees.
   - **Resource Sharing**: E-books, online journals, and shared resources can reduce the cost of textbooks and materials.

3. **Inclusivity for the Less Fortunate:** 
   - **Scholarships & Discounts**: Online platforms can provide scholarships or discounted courses for students from less privileged backgrounds.
   - **Free Courses**: Many platforms offer free courses, ensuring that finances are not a barrier to learning.
   - **Micro-Credits**: Some platforms allow students to take small, modular courses and accumulate credits over time, making education more modular and manageable.

However, challenges exist:

1. **Digital Divide**: Not everyone has access to stable internet and digital devices. Efforts must be made to bridge this gap.
2. **Quality Control**: Ensuring the quality of online education and preventing dilution of standards is crucial.
3. **Personal Interaction**: Physical classroom interactions have their benefits in terms of networking, hands-on experiences, and soft skill development. Hybrid models can be a solution.

In conclusion, while digital educational platforms show great promise in democratizing access to education, careful design, and thoughtful implementation are crucial. With strategic efforts, they can indeed make education more accessible and affordable to the less fortunate.

---

## 6. Conclusion


In the rapidly evolving landscape of education, the envisioned digital educational platform stands as a beacon of innovation and decentralization, aiming to revolutionize the traditional paradigms of learning. By placing the professor at the core of the educational experience, this system not only celebrates the individual talents and expertise of educators but also democratizes access to quality education on a global scale.

This platform's decentralized nature ensures that knowledge is not confined within the walls of institutions but flows freely, harnessed and directed by the professors themselves. They are empowered to curate their curriculum, ensuring that students receive content that is both up-to-date and aligned with the educator's passion and expertise.

The reputation index serves as a vital tool, ensuring transparency and quality assurance. It empowers students to make informed decisions, fostering a competitive environment that rewards excellence in teaching. Moreover, by allowing professors to operate remotely, the platform ensures that geographic boundaries no longer limit education. Students, regardless of their location, can access world-class expertise and diverse perspectives.

Furthermore, the platform's compatibility with various devices makes education truly omnipresent, ensuring that learning can occur anytime, anywhere, breaking down traditional barriers and creating a more inclusive environment.

By necessitating that students engage with multiple professors worldwide to earn their degree, the system promotes a holistic and diversified learning experience, enriching students with varied perspectives and expertise.

In amalgamation with the earlier discussed operating system, this digital platform has the potential to usher in a new era of education – one that is more equitable, accessible, and focused on lifelong learning. Through its visionary approach, it underscores the belief that improving global education standards is not just the responsibility of institutions but also of individuals. By harnessing the power of technology and the internet, we are on the brink of creating an ecosystem where quality education is not a privilege but a right accessible to all.

---

