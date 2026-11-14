# Java Library Management System

A console-based application built in Java to manage a simple library catalog. This project was developed to apply and demonstrate core **Object-Oriented Programming (OOP)** principles.

## Description

This application allows a user to add different types of media (Books and Magazines) to a library catalog, view the catalog, and interact with a terminal-based menu. It is designed to showcase clean architecture using Java's core features.

## Object-Oriented Programming (OOP) Concepts Used

This project is a practical implementation of the following concepts:
*   **Abstraction:** Used an `abstract class` (`Element`) to define a general template for all items in the library.
*   **Inheritance:** Created specialized classes (`Livre` and `Magazine`) that inherit from the base `Element` class, reusing common attributes like `id` and `titre`.
*   **Encapsulation:** All attributes in the classes are set to `private` to protect the data, with access provided through public methods.
*   **Polymorphism:** The `afficherDetails()` method is overridden in child classes. The main loop uses a generic `Element` reference to call the correct specific method automatically.
*   **Collections:** Utilized Java's `ArrayList` to dynamically store and manage an unlimited number of library items.

## Tech Stack

*   **Language:** Java (JDK 11 or higher recommended)
*   **Interface:** Command Line Interface (CLI)

## Installation & Usage

1. **Compile the Java file:**
  a.Open your terminal in the project directory and run:
   ```bash
   javac LibrarySystem.java
  b.Run the application:
   ```bash
   java LibrarySystem


