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

    @DisplayName("Testing calculate payment for Department Manager")
    @Test
    void testCalculatePayment() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        double expectedPayment = departmentManager.getSalary() + (departmentManager.getSalary() * departmentManager.getExecutiveBonusRate());

        assertEquals(expectedPayment, departmentManager.calculatePayment());
    }
}