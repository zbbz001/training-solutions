package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private static final String NAME_SEPARATOR = " ";
    private List<Employee> employeeList;
    private List<Project> projectList;
    private Map<String, List<TimeSheetItem>> timeSheetItems = new HashMap<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        employeeList = readEmployeesFile(employeesFile);
        projectList = readProjectsFile(projectsFile);
    }

    private List<Project> readProjectsFile(InputStream projectsFile) {
        List<Project> projects = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("The projects's file cannot read!");
        }

        return projects;
    }

    private List<Employee> readEmployeesFile(InputStream employeesFile) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(employeesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addNameToList(employees, line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("The employees's file cannot read!");
        }

        return employees;
    }

    private void addNameToList(List<Employee> employees, String line) {
        String[] parts = line.split(NAME_SEPARATOR);
        if (parts.length != 2) {
            throw new IllegalArgumentException("The employee's name format is incorrect!");
        }

        employees.add(new Employee(parts[0], parts[1]));
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        String employeeName = employee.getName();
        if (!timeSheetItems.containsKey(employeeName)) {
            timeSheetItems.put(employeeName, new ArrayList<>());
        }

        timeSheetItems.get(employeeName).add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        if (!timeSheetItems.containsKey(employeeName)) {
            throw new IllegalArgumentException("The employee cannot exist: " + employeeName);
        }

        List<ReportLine> report = initialReport();

        for (TimeSheetItem timeSheetItem : timeSheetItems.get(employeeName)) {
            if (timeSheetItem.getBeginDate().getYear() == year && timeSheetItem.getBeginDate().getMonthValue() == month) {
                addToReport(report, timeSheetItem);
            }
        }

        return report;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> report = calculateProjectByNameYearMonth(employeeName, year, month);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            int sumTime = 0;
            StringBuilder sb = new StringBuilder(employeeName);
            sb.append("\t" + year);
            sb.append(String.format("-%02d", month));
            sb.append("\t<<sumTime>>\n");

            for (ReportLine reportLine : report) {
                if (reportLine.getTime() != 0) {
                    sb.append(reportLine.getProject().getName());
                    sb.append("\t" + reportLine.getTime());
                    sb.append("\n");
                    sumTime += reportLine.getTime();
                }
            }

            writer.write(sb.toString().replace("<<sumTime>>", String.valueOf(sumTime)));

        } catch (IOException e) {
            throw new IllegalStateException("The file cannot write!");
        }
    }

    private void addToReport(List<ReportLine> reportLines, TimeSheetItem timeSheetItem) {
        for (ReportLine reportLine : reportLines) {
            if (reportLine.getProject().getName().equals(timeSheetItem.getProject().getName())) {
                reportLine.addTime(timeSheetItem.hoursBetweenDates());
            }
        }
    }

    private List<ReportLine> initialReport() {
        List<ReportLine> report = new ArrayList<>();

        for (Project project : projectList) {
            report.add(new ReportLine(project, 0L));
        }

        return report;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projectList);
    }
}
