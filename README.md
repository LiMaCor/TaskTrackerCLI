# Task Tracker CLI Application
Simple command-line interface utility used to track and manage your tasks.

## Features included

+ Add tasks with a description
+ Update already existing task's descriptions
+ Delete tasks
+ Update task's status
+ List all tasks or by their status (`todo`, `in progress` or `done`)

## Installation

1. **Clone the repo**

```bash
git clone https://github.com/LiMaCor/TaskTrackerCLI.git
cd TaskTrackerCLI
```
2. **Compile the source code**
```bash
javac src/*
```
3. **Run the application**
```bash
java TaskTrackerCLI <command> [arguments]
```

## Usage

```bash
# Add a new task
java TaskTrackerCLI add "Go to swim at 08:00 pm"

# Update a task
java TaskTrackerCLI update 1 "Buy new Brandon Sanderson's book"

# Delete a task
java TaskTrackerCLI delete 1

# Marking a task as done
java TaskTrackerCLI mark-done 1

# Listing tasks
java TaskTrackerCLI list all
java TaskTrackerCLI list in-progress
```
