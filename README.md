# API Automation Framework

## Overview

A clean and scalable API automation framework built with modern Java testing tools and a layered design that keeps the test suite readable, reusable, and easy to grow.

This project shows how to structure API tests in a way that feels close to real-world team practices, with a clear separation between test logic, API services, models, and utilities.

---

## Tech Stack

- Java
- Rest Assured
- TestNG
- Maven
- Allure Reports

---

## Architecture Design

The framework follows a layered approach to keep responsibilities clear:

### Service Layer

Encapsulates API requests and keeps request-building logic out of the tests.

### POJO Models

Maps API responses into Java objects for cleaner assertions and better readability.

### Request Body Models

Provides reusable payload objects for request data.

### Test Layer

Organizes tests by API domain so the suite is easier to navigate and maintain.

### Utilities

Handles shared helpers such as response conversion, test data reading, and configuration loading.

---

## Project Structure

```text
src
|-- main
|   |-- java
|   |   |-- bodyClasses
|   |   |-- responseClasses
|   |   `-- utils
|   `-- resources
|       `-- userData.json
`-- test
    |-- java
    |   |-- base
    |   |-- services
    |   `-- tests
    |       |-- authentication
    |       |   `-- LoginTests.java
    |       |-- brands
    |       |   `-- BrandTests.java
    |       |-- products
    |       |   |-- ProductListingTests.java
    |       |   `-- ProductSearchTests.java
    |       `-- users
    |           |-- AccountManagementTests.java
    |           `-- UserDetailsTests.java
    `-- resources
        `-- properties
            `-- environment.properties
```

---

## Test Modules

- `authentication`: login and login validation scenarios
- `users`: account creation, update, deletion, and user details coverage
- `products`: product listing and product search scenarios
- `brands`: brand listing and invalid method coverage

---

## Key Features

- Clean layered architecture
- Domain-based test organization
- Reusable API service layer
- Strong validation through POJO models
- Centralized test configuration
- Test execution through TestNG XML
- Allure reporting support

---

## How to Run Tests

### Using TestNG

- Right-click `testng.xml` and run the suite from your IDE

### Using Maven

```bash
mvn test
```

---

## Allure Reporting

After running the tests, generate and open the report with:

```bash
allure serve allure-results
```

---

## Design Decisions

- The service layer keeps request logic reusable and separate from assertions
- Domain-based test packages make the suite easier to scale as more APIs are added
- POJO models improve readability and make response validation safer
- Shared utilities keep common parsing and configuration logic centralized

---

## Future Enhancements

- Logging integration
- Retry support for unstable environments
- More data-driven coverage
- CI/CD integration with GitHub Actions or Jenkins

---

## Author

mostafa alashry

---

## Final Note

This project is structured to feel clean, practical, and interview-ready while still staying lightweight and easy to extend.
