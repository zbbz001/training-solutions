package week14d04;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {

    public List<Employee> transformToUppercased(List<Employee> employees) {
        return employees.stream()
                .map(employee -> new Employee(employee.getName().toUpperCase()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        EmployeeTransformOperations transformers = new EmployeeTransformOperations();
        List<Employee> employees = transformers.transformToUppercased(List.of(
                new Employee("Cody Coder"),
                new Employee("John James Rambo")
        ));

        System.out.println(employees);
    }

}
