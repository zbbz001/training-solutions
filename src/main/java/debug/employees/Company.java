package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public static void main(String[] args) {
        Company company = new Company(new ArrayList<>());

        company.addEmployee(new Employee("Cody Coder", 1988));
        company.addEmployee(new Employee("Donald Duck", 1962));
        company.addEmployee(new Employee("Sam Sung", 1991));
        company.addEmployee(new Employee("John James Rambo", 1947));

        Employee employeeSearch = company.findEmployeeByName("John James Rambo");


        System.out.println(employeeSearch.getName() + " (" + employeeSearch.getYearOfBirth() + ")");

        System.out.println(company.listEmployeeNames());

    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeByName(String name) {
        for(Employee employee:employees) {
            if(employee.getName().equals(name)) {

                return employee;
            }
        }

        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> employeeNames = new ArrayList<>();

        for(Employee employee:employees) {
            employeeNames.add(employee.getName());
        }

        return employeeNames;
    }
}
