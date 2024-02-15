import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void viewTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
        }
    }

    public void saveTasksToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.println(task.getDescription());
            }
            System.out.println("Tasks saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            tasks.clear(); // Clear existing tasks
            while (scanner.hasNextLine()) {
                String description = scanner.nextLine();
                tasks.add(new Task(description));
            }
            System.out.println("Tasks loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}

public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Save Tasks to File");
            System.out.println("4. Load Tasks from File");
            System.out.println("5. Exit");
            System.out.println("6. Read the file");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(new Task(description));
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    toDoList.saveTasksToFile(saveFilename);
                    break;
                case 4:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    toDoList.loadTasksFromFile(loadFilename);
                    break;
                case 5:
                    System.out.println("Exit program.");
                    System.exit(0);
                case 6:
                    System.out.print("Enter filename to read: ");
                    String readFilename = scanner.nextLine();
                    toDoList.loadTasksFromFile(readFilename);
                    break;
                default:
                    System.out.println("Choice is invalid. Please try again after sometime.");
            }
        }
    }
}
