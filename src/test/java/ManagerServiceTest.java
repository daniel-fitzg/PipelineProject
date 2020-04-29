import employee.com.DepartmentManager;
import employee.com.Director;
import employee.com.ManagerService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    void testCalculateExecutiveBonusForDirector() {
        String employeeId = "0030";
        double executiveBonusRate = 0.3;
        double salary = 120000;

        Director director = new Director(employeeId, "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", salary, "Dublin");
        managerService.registerEmployee(director);

        Assertions.assertEquals(executiveBonusRate, director.getExecutiveBonusRate());
        Assertions.assertEquals(salary * executiveBonusRate, managerService.calculateExecutiveBonus(employeeId));
    }

    @Test
    void testCalculateExecutiveBonusForDepartmentManager() {
        String employeeId = "0031";
        double executiveBonusRate = 0.1;
        double salary = 30000;

        DepartmentManager departmentManager = new DepartmentManager(employeeId, "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", salary, "Dublin");
        managerService.registerEmployee(departmentManager);

        Assertions.assertEquals(executiveBonusRate, departmentManager.getExecutiveBonusRate());
        Assertions.assertEquals(salary * executiveBonusRate, managerService.calculateExecutiveBonus(employeeId));
    }

    @Test
    void testCalculateExecutiveBonusWhenManagerNotPresentInStorage() {
        String employeeId = "0032";

        Assertions.assertNull(managerService.getEmployeeDetails(employeeId));
        Assertions.assertThrows(NullPointerException.class, () -> {
            managerService.calculateExecutiveBonus(employeeId);
        });
    }
}
