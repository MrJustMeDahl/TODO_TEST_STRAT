package org.example.unit;
import org.example.Task;
import org.example.ToDoList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void newTask(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2024, 12, 31));
        assertEquals("Test Task", task.getTitle());
        assertEquals("Testing", task.getCategory());
        assertEquals(LocalDate.of(2024, 12, 31), task.getDeadline());
        assertFalse(task.isCompleted());
    }
    @Test
    void updateTask(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2024, 12, 31));
        task.updateTask("Updated Task", "Updated Category", LocalDate.of(2025, 1, 1));
        assertEquals("Updated Task", task.getTitle());
        assertEquals("Updated Category", task.getCategory());
        assertEquals(LocalDate.of(2025, 1, 1), task.getDeadline());
    }
    @Test
    void deleteTask(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2024, 12, 31));
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task);
        assertEquals(1, toDoList.getTasks().size());
        toDoList.deleteTask(0);
        assertEquals(0, toDoList.getTasks().size());

    }

    @Test
    void deleteTaskInvalidIndex(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2024, 12, 31));
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task);
        assertEquals(1, toDoList.getTasks().size());
        boolean result = toDoList.deleteTask(1);
        assertFalse(result);
        assertEquals(1, toDoList.getTasks().size());
        result = toDoList.deleteTask(-1);
        assertFalse(result);
        assertEquals(1, toDoList.getTasks().size());
        result = toDoList.deleteTask(0);
        assertTrue(result);
        assertEquals(0, toDoList.getTasks().size());
    }

    @Test
    void markCompleted(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2024, 12, 31));
        task.markCompleted();
        assertTrue(task.isCompleted());
    }
    @Test
    void showTasks(){
        Task task = new Task("Test Task", "Testing", LocalDate.of(2025, 02, 11));
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task);
        List<Task> testList = toDoList.showTasks();
        assertNotNull(testList);
        assertEquals(1, testList.size());
        assertEquals("Test Task", testList.get(0).getTitle());
        assertEquals("Testing", testList.get(0).getCategory());
        assertEquals(LocalDate.of(2025, 02, 11), testList.get(0).getDeadline());
    }
}


//1. Add Task
//2. Update Task
//3. Delete Task
//4. Mark Task Completed
//5. Show Tasks
//6. Exit


//    public Task(String title, String category, LocalDate deadline) {
//        this.title = title;
//        this.category = category;
//        this.deadline = deadline;
//        this.completed = false;
//    }