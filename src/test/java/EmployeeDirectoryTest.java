
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.serjeypyzin.Employee;
import ru.serjeypyzin.EmployeeDirectory;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmployeeDirectoryTest {

    private EmployeeDirectory directory;

    @BeforeEach
    void setUp() {
        directory = new EmployeeDirectory();
        Employee employee1 = new Employee("Иванов Иван", "123456789", 5);
        Employee employee2 = new Employee("Петров Петр", "987654321", 10);
        directory.addedNewEmployeeToEmployeeDirectory(employee1);
        directory.addedNewEmployeeToEmployeeDirectory(employee2);
    }

    @Test
    void testFindEmployeeByServiceNumber() {
        Employee foundEmployee = directory.findEmployeeByServicesNumber(directory.getEmployees(), 1);
        assertNotNull(foundEmployee);
        assertEquals("Иванов Иван", foundEmployee.getEmployeeName());
    }

    @Test
    void testFindEmployeeByNonexistentServiceNumber() {
        Employee foundEmployee = directory.findEmployeeByServicesNumber(directory.getEmployees(), 3);
        assertNull(foundEmployee);
    }

    @Test
    void testFindEmployeeByWorkExperience() {
        List<Employee> foundEmployees = directory.findEmployeeByWorkExperience(directory.getEmployees(), 5);
        assertEquals(1, foundEmployees.size());
        assertEquals("Иванов Иван", foundEmployees.get(0).getEmployeeName());
    }

    @Test
    void testFindEmployeeByNonexistentWorkExperience() {
        List<Employee> foundEmployees = directory.findEmployeeByWorkExperience(directory.getEmployees(), 15);
        assertEquals(0, foundEmployees.size());
    }

    @Test
    void testFindPhoneNumbersByEmployeeName() {
        List<String> phoneNumbers = directory.findPhoneNumbersByEmployeeName(directory.getEmployees(), "Иванов Иван");
        assertEquals(1, phoneNumbers.size());
        assertEquals("123456789", phoneNumbers.get(0));
    }

    @Test
    void testFindPhoneNumbersByNonexistentEmployeeName() {
        List<String> phoneNumbers = directory.findPhoneNumbersByEmployeeName(directory.getEmployees(), "Сидоров Сидор");
        assertEquals(0, phoneNumbers.size());
    }
}
