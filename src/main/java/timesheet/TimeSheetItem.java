package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSheetItem {
    private Employee employee;
    private Project project;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (!beginDate.toLocalDate().equals(endDate.toLocalDate())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            throw new IllegalArgumentException("The begin and the end date is not the same day! begin:"
                    + beginDate.format(formatter)
                    + " end: "
                    + endDate.format(formatter));
        }

        if (beginDate.isAfter(endDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            throw new IllegalArgumentException("The begin date is after than the end date! begin:"
                    + beginDate.format(formatter)
                    + " end: "
                    + endDate.format(formatter));
        }

        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
