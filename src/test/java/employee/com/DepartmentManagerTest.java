package employee.com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentManagerTest {

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for Department Manager");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for Department Manager");
    }

    @DisplayName("Testing validation of setDepartment method")
    @Test
    void testValidateSetDepartment() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        assertEquals("Grocery", departmentManager.getDepartment());

        departmentManager.setDepartment("Hardware");
        assertEquals("Hardware", departmentManager.getDepartment());
    }

    @DisplayName("Testing validation of setDepartment method with invalid argument")
    @Test
    void testValidateSetDepartmentWithInvalidArg() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { departmentManager.setDepartment(""); });
        assertEquals("Empty String", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { departmentManager.setDepartment("Ha"); });
        assertEquals("String doesn't meet minimum length requirement", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { departmentManager.setDepartment("Hardware9"); });
        assertEquals("String contains numbers", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { departmentManager.setDepartment("Hardwa*re"); });
        assertEquals("String contains special characters", exception.getMessage());
    }
}