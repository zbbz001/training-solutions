package week12d05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeFilterTest {

    @Test
    public void employeeFilterTest() {
        EmployeeFilter ef = new EmployeeFilter();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, 2, "Cody Coder", List.of("programming", "teamwork", "flexibility")));
        employeeList.add(new Employee(40, 10, "John James Rambo", List.of("creativity")));
        employeeList.add(new Employee(88, 7, "Mickey Mouse", List.of("programming", "creativity")));

        assertEquals(1, ef.countSeniorDevs(employeeList).size());
        assertEquals("Mickey Mouse", ef.countSeniorDevs(employeeList).get(0).getName());
    }
}