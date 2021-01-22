package week12d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSkillLevel() > 2 && employee.getSkills().contains("programming")) {
                employeeList.add(employee);
            }
        }


        return employeeList;
    }
}
