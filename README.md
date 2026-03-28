# Employee CRUD Manager

> A console-based Java application for managing employee records.  
> Built as a multi-part assignment for an IT/Java programming course.

---

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Tech Stack](#tech-stack)
4. [Project Structure](#project-structure)
5. [Class Descriptions](#class-descriptions)
6. [Getting Started](#getting-started)
7. [How to Use](#how-to-use)
8. [Employee Fields](#employee-fields)
9. [Known Limitations](#known-limitations)
10. [Roadmap / Future Improvements](#roadmap--future-improvements)

---

## Overview

**Employee CRUD Manager** is a command-line Java application that lets you manage a company's
employee roster without a database. All data is kept in-memory in a dynamically resizing array
for the lifetime of the program.

The project was developed in stages as a practical assignment covering:
- Object-Oriented Programming fundamentals (classes, encapsulation, inheritance)
- Console I/O and user interaction
- CRUD operations (Create, Read, Update, Delete)
- Basic error handling

This repository contains **Part 1** of the project: the no-database version.

---

## Features

| # | Feature                              | Status |
|---|--------------------------------------|--------|
| 1 | Add a new employee                   | ✅ Done |
| 2 | Read all employees                   | ✅ Done |
| 3 | Read employee by name                | ✅ Done |
| 4 | Read employee by ID                  | ✅ Done |
| 5 | Edit any field of an employee by ID  | ✅ Done |
| 6 | Delete employee by ID                | ✅ Done |
| 7 | Delete employee by name              | ✅ Done |
| 8 | Dynamic array resize (50 % growth)   | ✅ Done |
| 9 | Input validation / error handling    | ✅ Done |
| 10| Auto-capitalize name / surname       | ✅ Done |

---

## Tech Stack

- **Language:** Java (SE 8+)
- **IDE:** IntelliJ IDEA
- **Build:** Manual `javac` / IntelliJ run configuration (no build tool required)
- **Dependencies:** None (standard Java library only)

---

## Project Structure

```
Project_Employee_CRUD/
├── README.md
└── noDataCrud/                         ← IntelliJ module (Part 1 – no database)
    └── src/
        └── com/step/
            ├── Main.java               ← Entry point
            ├── employee/
            │   └── Employee.java       ← Employee model (fields + getters/setters)
            ├── director/
            │   ├── Director.java       ← Core data store & CRUD logic
            │   └── ManageEmployee.java ← Orchestration layer (extends Director)
            └── menu/
                └── Menu.java           ← Console UI / menu system
```

---

## Class Descriptions

### `Main.java`
Entry point. Launches the main menu.

### `Employee.java`
Plain-old Java object representing a single employee.

| Field         | Type   | Notes                          |
|---------------|--------|--------------------------------|
| `Firstname`   | String | Auto-capitalized on input      |
| `Lastname`    | String | Auto-capitalized on input      |
| `Address`     | String |                                |
| `Telephone`   | String |                                |
| `DateOfBirth` | String | Free-form (e.g. `1995-06-15`)  |
| `Email`       | String |                                |
| `IDNP`        | String | National identity number       |

Provides standard getters and setters, plus `getCV()` to display all fields.

### `Director.java`
Owns the `Employee[]` array and provides all low-level operations:
- `createCompany()` – initializes the array with a user-defined capacity
- `addEmployee()` – adds to the next free slot, resizes if needed (× 1.5)
- `getAllEmployees()` – prints every non-null entry
- `getEmployee(String name)` / `getEmployee(int id)` – filtered display
- `setEditEmployee(int id)` – interactive field-by-field edit loop
- `removeEmployee(int id)` / `removeEmployee(String name)` – deletes and compacts the array

### `ManageEmployee.java`
Extends `Director`. Bridges the menu system with the data layer:
- `newEmployee()` – creates the company on first call, then adds
- `showEmployees(int selection)` – routes READ sub-menu choices
- `getEditEmployee(int selection)` – routes EDIT sub-menu choices
- `getDeleteEmployee(int selection)` – routes DELETE sub-menu choices

### `Menu.java`
Pure console UI. Each menu method clears the screen (10 blank lines), prints options,
reads a validated integer, and delegates to `ManageEmployee`. Invalid input is caught
and the menu is re-displayed.

---

## Getting Started

### Prerequisites

- **JDK 8** or later installed and on your `PATH`
- (Optional) IntelliJ IDEA for IDE-based run

### Compile & Run (command line)

```bash
# From the repository root
javac -d out $(find noDataCrud/src -name "*.java")
java -cp out com.step.Main
```

### Run from IntelliJ IDEA

1. Open the `noDataCrud` folder as an IntelliJ project.
2. Mark `noDataCrud/src` as **Sources Root**.
3. Run `com.step.Main`.

---

## How to Use

When you start the application you will see the **Main Menu**:

```
      |MAIN  MENU|
Choose from these choices
-------------------------
1 - Create employees
2 - Read employees
3 - Edit employees
4 - Delete employees
5 - Quit
INSERT--->
```

### Creating an employee

1. Choose **1** from the main menu.
2. Choose **1 – Add new Employee**.
3. On first use, enter the desired company capacity (e.g. `5`).
4. Fill in all seven fields when prompted.

### Reading employees

1. Choose **2** from the main menu.
2. Select:
   - **1** – list everyone
   - **2** – search by first name
   - **3** – search by numeric ID

### Editing an employee

1. Choose **3** from the main menu.
2. Choose **1 – MODIFY EMPLOYEE BY ID**.
3. Enter the employee's ID (shown during read operations).
4. A sub-menu lists all seven fields; pick the one to change and enter the new value.
5. Choose **8 – Exit** to finish editing.

### Deleting an employee

1. Choose **4** from the main menu.
2. Select:
   - **1** – delete by ID
   - **2** – delete by first name (removes *all* matches)

After deletion the remaining employees are compacted so IDs remain consecutive.

---

## Employee Fields

When adding or editing an employee you will be asked for:

| Prompt         | Example value        |
|----------------|----------------------|
| Name           | `John`               |
| Surname        | `Doe`                |
| Address        | `123 Main Street`    |
| Phone          | `+1 555 0100`        |
| Birthdate      | `1990-04-21`         |
| Email          | `john.doe@email.com` |
| IDNP           | `2004021012345`      |

> **Note:** First name and last name are automatically capitalized (first letter
> uppercase, rest lowercase) regardless of how you type them.

---

## Known Limitations

- **No persistence** – all data is lost when the program exits. A database (Part 2)
  will solve this.
- **Fixed String types** – phone, IDNP, and date fields are stored as plain strings
  with no format validation.
- **Array-based storage** – employee IDs shift after a deletion because the array is
  compacted. Do not rely on an ID staying the same across a session where deletions occur.
- **Single Scanner instance per class** – the console input works correctly for
  sequential use but is not thread-safe.

---

## Roadmap / Future Improvements

- [ ] **Part 2** – Add a relational database (MySQL / SQLite) as the data layer
- [ ] **Part 3** – Add a web front-end (Servlet/Spring MVC) or REST API
- [ ] Validate phone number and email formats with regular expressions
- [ ] Search / edit / delete by last name in addition to first name
- [ ] Export employee list to CSV
- [ ] Unit tests (JUnit)
- [ ] Replace raw arrays with `ArrayList<Employee>`

---

## License

This project was created as a course assignment. Feel free to use it for learning purposes.

