import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;


public class Task_Manager {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private static int id = 1;

    public void create(String name, String description, STATUS status, String date)
    {
        Task task = new Task();
        task.setId(id);
        id++;
        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);

        while (true)
        {
            try
            {
                task.setDeadline(formatDeadline(date));
                break;
            }
            catch (DateTimeParseException e)
            {
                Scanner scanner;
                scanner = new Scanner(System.in);
                date = scanner.nextLine();
                scanner.close();
            }
        }

        tasks.add(task);
    }

    public void Read(int id)
    {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                found = true;
                System.out.println("\n");
                System.out.println("Name: " + task.getName());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Status: " + task.getStatus());
                System.out.println("Deadline: " + task.getDeadline());
                System.out.println("\n");
            }

        }

        if (!found)
        {
            System.out.println("No such task found");
        }
    }

    public void Update(int id, TASK_MODIFY_CHOICE choice, String new_value)
    {
        for (Task task : tasks)
        {
            if (task.getId() == id)
            {
                switch (choice)
                {
                    case NAME:
                        try
                        {
                            task.setName(new_value);
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error updating task name, invalid value");
                        }
                        break;
                    case DESCRIPTION:
                        try
                        {
                            task.setDescription(new_value);
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error updating task description, invalid value");
                        }
                        break;
                    case STATUS:
                        try
                        {
                            STATUS newStatus = getStatusFromString(new_value);
                            task.setStatus(newStatus);
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error updating task status, invalid value");
                        }
                        break;
                    case DEADLINE:
                        try
                        {
                            LocalDate newDeadLine = LocalDate.parse(new_value);
                            task.setDeadline(newDeadLine);
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error updating task deadline, invalid value");
                        }
                        break;
                }
            }
        }
    }

    public void Delete(int id)
    {
        try
        {
            tasks.removeIf(task -> task.getId() == id);
        }
        catch (Exception e)
        {
            System.out.println("Error deleting task, invalid value");
        }

    }

    public void List()
    {
        for (Task task : tasks)
        {
            System.out.println("Tasks:\n");
            System.out.println("Id: " + task.getId());
            System.out.println("Name: " + task.getName());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("\n");
        }
    }


    private STATUS getStatusFromString(String status)
    {
        return switch (status) {
            case "TO_DO" -> STATUS.TO_DO;
            case "IN_PROGRESS" -> STATUS.IN_PROGRESS;
            case "COMPLETED" -> STATUS.COMPLETED;
            default -> throw new EnumConstantNotPresentException(STATUS.class, status);
        };
    }

    private LocalDate formatDeadline(String date) {
        try
        {
            return LocalDate.parse(date);
        }
        catch (DateTimeParseException e)
        {
            throw new DateTimeParseException("Invalid date", date, 0);
        }
    }
}
