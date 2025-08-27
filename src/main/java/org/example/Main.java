package org.example;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\n1. Add Task\n2. Update Task\n3. Delete Task\n4. Mark Task Completed\n5. Show Tasks\n6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter deadline (yyyy-mm-dd): ");
                    LocalDate deadline = LocalDate.parse(scanner.nextLine());
                    toDoList.addTask(new Task(title, category, deadline));
                    break;
                case 2:
                    toDoList.showTasks();
                    System.out.print("Enter task index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New title: ");
                    title = scanner.nextLine();
                    System.out.print("New category: ");
                    category = scanner.nextLine();
                    System.out.print("New deadline (yyyy-mm-dd): ");
                    deadline = LocalDate.parse(scanner.nextLine());
                    toDoList.updateTask(updateIndex, title, category, deadline);
                    break;
                case 3:
                    toDoList.showTasks();
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    toDoList.deleteTask(deleteIndex);
                    break;
                case 4:
                    toDoList.showTasks();
                    System.out.print("Enter task index to mark completed: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.markTaskCompleted(completeIndex);
                    break;
                case 5:
                    toDoList.showTasks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}