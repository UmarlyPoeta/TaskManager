import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task_Manager taskManager = new Task_Manager();

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. Read Task");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. List Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task status (TO_DO, IN_PROGRESS, COMPLETED): ");
                    STATUS status = STATUS.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter task deadline (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    taskManager.create(name, description, status, date);
                    break;
                case 2:
                    System.out.print("Enter task ID: ");
                    int readId = scanner.nextInt();
                    taskManager.Read(readId);
                    break;
                case 3:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter update type (NAME, DESCRIPTION, STATUS, DEADLINE): ");
                    TASK_MODIFY_CHOICE choiceType = TASK_MODIFY_CHOICE.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    taskManager.Update(updateId, choiceType, newValue);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.Delete(deleteId);
                    break;
                case 5:
                    taskManager.List();
                    break;
                case 6:
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
