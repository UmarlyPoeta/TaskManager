
import java.time.DateTimeException;
import java.time.LocalDate;


public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate deadline;
    private STATUS status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {

        this.deadline = checkDate(deadline);
    }

    private LocalDate checkDate(LocalDate date){
        if (date.isBefore(LocalDate.now()))
        {
            throw new DateTimeException("Date is after now");
        }

        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(STATUS status) {
        this.status = checkStatus(status);
    }

    private STATUS checkStatus(STATUS status){
        for (STATUS s : STATUS.values())
        {
            if (status == s)
            {
                return s;
            }
        }
        throw new EnumConstantNotPresentException(STATUS.class, status.toString());
    }

}
