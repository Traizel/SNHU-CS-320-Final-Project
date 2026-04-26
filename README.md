# 📱 CS 320 Project One – Contact, Task, and Appointment Services

## 📌 Overview

This project was developed as part of my coursework in **Software Test, Automation, and Quality Assurance (CS 320)**. It demonstrates the design, implementation, and testing of core backend services for a mobile application.

The application includes three main services:

* **Contact Service**
* **Task Service**
* **Appointment Service**

Each service uses in-memory data structures and is fully validated through **JUnit unit testing** to ensure all requirements are met.

## Reflection

 Throughout this course, I learned that ensuring software is both functional and secure requires a structured and consistent testing approach. I focused heavily on unit testing using JUnit to validate that each component of my application behaved as expected. Writing tests alongside my code helped me catch errors early, especially with edge cases like invalid inputs or null values. I also reinforced security by validating inputs and enforcing constraints, such as limiting field lengths and preventing unauthorized updates (like immutable IDs). Combining these practices helped ensure that my software not only worked correctly but also handled unexpected situations safely.
 
 Interpreting user needs and translating them into code was another key skill I developed. I approached this by carefully analyzing requirements and breaking them down into smaller, testable features. For example, in the contact service project, I mapped each requirement (like adding, updating, or deleting contacts) into specific methods and corresponding test cases. This process helped me stay aligned with what the user actually needed rather than making assumptions. Writing tests based on requirements also acted as a form of validation, ensuring that the implementation matched expectations.

 When designing software, I’ve learned to prioritize simplicity, modularity, and maintainability. I structured my code using clear classes and responsibilities, such as separating the contact object from the contact service. This made the system easier to test and extend. I also followed an iterative approach, writing small pieces of functionality, testing them, and refining as needed. Overall, this course strengthened my ability to think like both a developer and a tester, ensuring that the software I build is reliable, well structured, and aligned with user requirements.

---

## 🎯 Objectives

* Implement object-oriented design in Java
* Apply software testing principles using JUnit
* Validate functional requirements through unit tests
* Ensure high code quality and reliability

---

## 🧩 Features

### 👤 Contact Service

* Add contacts with unique IDs (≤ 10 characters)
* Update:

  * First Name
  * Last Name
  * Phone Number (exactly 10 digits)
  * Address (≤ 30 characters)
* Delete contacts by ID

---

### 📝 Task Service

* Add tasks with unique IDs (≤ 10 characters)
* Update:

  * Name (≤ 20 characters)
  * Description (≤ 50 characters)
* Delete tasks by ID

---

### 📅 Appointment Service

* Add appointments with unique IDs (≤ 10 characters)
* Appointment date must be **in the future**
* Description limited to ≤ 50 characters
* Delete appointments by ID

---

## 🧪 Testing

This project includes comprehensive **JUnit 5 test cases** for:

* All data validation rules
* CRUD operations for each service
* Edge cases (null values, length limits, invalid inputs)

✔ All services are tested to meet project requirements
✔ Designed to achieve **80%+ code coverage**

---

## 🛠️ Technologies Used

* **Java**
* **JUnit 5**
* **Object-Oriented Programming (OOP)**
* **In-memory data structures**

---

## 📂 Project Structure

```
├── Contact.java
├── ContactService.java
├── ContactTest.java
├── ContactServiceTest.java
│
├── Task.java
├── TaskService.java
├── TaskTest.java
├── TaskServiceTest.java
│
├── Appointment.java
├── AppointmentService.java
├── AppointmentTest.java
├── AppointmentServiceTest.java
```

---

## 🚀 How to Run

### 1. Clone the repository

```
git clone https://github.com/Traizel/SNHU-CS-320-Final-Project.git
```

### 2. Open in your IDE

Recommended:

* IntelliJ IDEA
* Eclipse
* VS Code (with Java extensions)

### 3. Run Tests

Run all JUnit test files to verify functionality.

---

## 💡 Key Takeaways

* Reinforced importance of **input validation**
* Learned how to structure **testable code**
* Gained experience writing **unit tests before validation**
* Improved understanding of **software quality assurance practices**

---

## 👤 Author

**Tre Olson**

* Computer Science (Software Engineering) Student
* Content Creator & Developer

---

## 📜 License

This project is for educational and portfolio purposes.

