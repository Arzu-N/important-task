# 🧠 Smart Task Prioritization System

## 📌 Core Idea
This project is a smart task management system where users add tasks, but the system automatically decides the priority order based on logic such as deadline and difficulty.

The system calculates a **priorityScore** for each task and ensures that the most important tasks are shown first.

---

## 🏗️ Entities

### 👤 User
- id
- username
- email

### 📋 Task
- id
- title
- description
- deadline
- difficulty (EASY, MEDIUM, HARD)
- createdAt
- priorityScore (double)
- status (UNDONE, DONE)
- user

---

## 🔗 API Endpoints

### ➕ Create Task
`POST /task/create`
- Creates a new task
- Required fields must be provided

---

### 📥 Get All Tasks
`GET /tasks`
- Returns all tasks for the user
- Sorted by `priorityScore`
- Includes security filtering per user

---

### 🔍 Get Task by ID
`GET /task/{id}`
- Returns a task by its ID

---

### 🎲 Get Random Task
`GET /task/random`
- Returns a random task from the user’s task list

---

### ❌ Delete Task
`DELETE /task/{id}`
- Deletes task by ID

---

## ⏱️ Scheduler
- Runs every 1 hour
- Recalculates `priorityScore` for all tasks

---

## 🧠 Business Logic (Core Intelligence)
Priority is calculated based on:

- 📅 Deadline proximity  
  - Closer deadline → higher priority
- 🔥 Difficulty level  
  - HARD > MEDIUM > EASY
- ⏳ Creation time (optional factor)

### Example idea:
- Task due tomorrow → high score
- HARD task → higher score
- Old undone tasks → gradually increase priority

---

## 🚀 Tech Stack (suggested)
- Java / Spring Boot
- Spring Scheduler
- Spring Data JPA
- REST API

---

## 🎯 Goal
To simulate an intelligent system that helps users focus on the most important tasks automatically instead of manually organizing them.
