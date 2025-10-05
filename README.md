Problem Statement
Build a simple Student Management System in Java where a user can add, view, search, update, and delete student records. The system should store student details in memory using an ArrayList and allow up to 8 students. It should use only functions (methods) and not databases or file storage.


Features & Functionalities


Add Student – Add a new student by entering ID, Name, Course, and Marks.

View Students – Display all students in a tabular format.

Search Student – Search for a student by ID or Name.

Update Student – Update the course or marks of an existing student.

Delete Student – Delete a student record using the student ID.

Exit – Exit the application safely.


Data Structure

Student List (ArrayList)

Each student is stored as an object containing:

ID, Name, Course, and Marks.


Example:
students = [
  {id: 1, name: "Ravi", course: "CS", marks: 85},
  {id: 2, name: "Priya", course: "ECE", marks: 92}
]



Menu Example
===== Student Management System =====
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Enter your choice:

