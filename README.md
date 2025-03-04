# Task Manager

## Features
- Create new tasks
- Read task details by ID
- Update task name, description, status, or deadline
- Delete a task
- List all tasks

## Project Structure
```
└── umarlypoeta-taskmanager/
    ├── TaskManager.iml
    └── src/
        ├── Main.java                 # Main application class
        ├── STATUS.java               # Enum storing task statuses
        ├── TASK_MODIFY_CHOICE.java   # Enum for task modification options
        ├── Task.java                 # Class representing a task
        └── Task_Manager.java         # Class managing tasks
```

## Requirements
- Java 8 or later

## How to Run
1. Clone the repository or download the project files.
2. Open a terminal in the `umarlypoeta-taskmanager` directory.
3. Compile the code:
   ```sh
   javac src/*.java -d out
   ```
4. Run the application:
   ```sh
   java -cp out Main
   ```

## Example Usage
```
Task Manager Menu:
1. Create Task
2. Read Task
3. Update Task
4. Delete Task
5. List Tasks
6. Exit
Choose an option: 
```

## Author
umarlypoeta

