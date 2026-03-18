# 🚀 API Automation Framework

## 🌟 Overview

A robust, scalable, and production-ready **API Automation Testing Framework** built using modern best practices in test automation.

This project demonstrates how to design clean, maintainable, and reusable API tests using a layered architecture approach — similar to what is used in real-world enterprise environments.

---

## 🛠️ Tech Stack

* ☕ Java
* 🔗 Rest Assured
* 🧪 TestNG
* 📦 Maven
* 📊 Allure Reports

---

## 🧱 Architecture Design

The framework follows **clean architecture principles** to ensure separation of concerns:

### 🔹 Service Layer

Encapsulates all API requests (GET, POST, PUT, DELETE), keeping test logic clean and reusable.

### 🔹 POJO Models

Maps API responses into Java objects for type-safe validation and better readability.

### 🔹 Request Body Models

Reusable classes for building request payloads dynamically.

### 🔹 Test Layer

Contains well-structured and independent test cases using TestNG.

### 🔹 Utilities

Helper classes for response parsing, data handling, and common operations.

---

## 📁 Project Structure

```
src
 ├── main
 │   └── java
 │       ├── bodyClasses
 │       ├── responseClasses
 │       └── utils
 │
 ├── test
 │   └── java
 │       ├── base
 │       ├── properties
 │       ├── services
 │       └── tests
 │
 └── resources
     └── allure-results
```

---

## ✨ Key Features

✔ Clean and scalable architecture
✔ Reusable API service layer
✔ Strong validation using POJOs
✔ Centralized configuration
✔ Test execution via TestNG XML
✔ Rich reporting with Allure

---

## ▶️ How to Run Tests

### Using TestNG

* Right click on `testng.xml` → Run

### Using Maven

```bash
mvn clean test
```

---

## 📊 Allure Reporting

Generate and view reports:

```bash
allure serve target/allure-results
```

---

## 🎯 Design Decisions

* **Service Layer** ensures reusability and clean test cases
* **POJO Models** provide type safety and reduce runtime errors
* **Separation of Concerns** improves maintainability

---

## 🚀 Future Enhancements

* Logging integration (Log4j)
* Retry mechanism for flaky tests
* Data-driven testing
* CI/CD integration (GitHub Actions / Jenkins)

---

## 👨‍💻 Author

mostafa alashry

---

## ⭐ Final Note

This project reflects real-world API automation practices and can serve as a strong foundation for enterprise-level testing frameworks.
