package employee.com;

import org.junit.jupiter.api.*;

import static employee.com.EmployeeFactory.getValidCommissionBasedStaff;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerServiceTest {

    private ManagerService managerService = new ManagerService();

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for ManagerService");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for ManagerService");
    }

    @DisplayName("Testing calculate executive bonus for Director")
    @Test
    void testCalculateExecutiveBonusForDirector() {
        double executiveBonusRate = 0.3;

        Director director = EmployeeFactory.getValidDirector();
        managerService.registerEmployee(director);

        Assertions.assertEquals(executiveBonusRate, director.getExecutiveBonusRate());
        Assertions.assertEquals(director.getSalary() * executiveBonusRate, managerService.calculateExecutiveBonus(director.getEmployeeId()));
    }

    @DisplayName("Testing calculate executive bonus for Department Manager")
    @Test
    void testCalculateExecutiveBonusForDepartmentManager() {
        double executiveBonusRate = 0.1;

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        managerService.registerEmployee(departmentManager);

        Assertions.assertEquals(executiveBonusRate, departmentManager.getExecutiveBonusRate());
        Assertions.assertEquals(departmentManager.getSalary() * executiveBonusRate, managerService.calculateExecutiveBonus(departmentManager.getEmployeeId()));
    }

    @DisplayName("Testing calculate executive bonus for Manager when not stored in the database")
    @Test
    void testCalculateExecutiveBonusWhenManagerNotPresentInStorage() {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertNull(managerService.getEmployeeDetails(director.getEmployeeId()));
        Assertions.assertThrows(NullPointerException.class, () -> {
            managerService.calculateExecutiveBonus(director.getEmployeeId());
        });

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertNull(managerService.getEmployeeDetails(departmentManager.getEmployeeId()));
        Assertions.assertThrows(NullPointerException.class, () -> {
            managerService.calculateExecutiveBonus(departmentManager.getEmployeeId());
        });
    }

    @DisplayName("********Testing CalculatePayment for Department manager ************")
    @Test
    void testCalculatePaymentDepartmentmanager() {
        assertEquals(23479.00, EmployeeFactory.getValidDepartmentManager().calculatePayment() );
    }

    @DisplayName("********Testing CalculatePayment for Director ************")
    @Test
    void testCalculatePaymentDirector() {
        assertEquals(75656.00, EmployeeFactory.getValidDirector().calculatePayment() );
    }
}
