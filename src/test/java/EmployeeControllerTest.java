import employee.com.DepartmentManager;
import employee.com.Director;
import employee.com.Employee;
import employee.com.EmployeeController;
import org.junit.jupiter.api.*;

class EmployeeControllerTest {

    private EmployeeController employeeController = new EmployeeController();

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for EmployeeController");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for EmployeeController");
    }

    @Test
    void testRegisterEmployeeDirector() {
        Director director = new Director("0001", "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(director, true));
    }

    @Test
    void testRegisterDuplicateEmployeeDirector() {
        Director director = new Director("0009", "Lisa Duffy", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(director, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(director, true));
    }

    @Test
    void testRegisterEmployeeDepartmentManager() {
        DepartmentManager departmentManager = new DepartmentManager("0002", "Mike Lam", "Wexford", "01/02/1983",
                "1426794W", 43000, "Grocery");

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(departmentManager, true));
    }

    @Test
    void testRegisterDuplicateEmployeeDepartmentManager() {
        Director director = new Director("0010", "Lisa Duffy", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(director, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(director, true));
    }

    @Test
    void testUpdateEmployeeDirectorDetails() {
        String employeeId = "0003";
        String newEmployeeAddress = "Sligo";

        // Create new Director
        Director director = new Director(employeeId, "Mary Flynn", "Kerry", "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.registerEmployee(director, true);

        // Update address of Director
        director = new Director(employeeId, "Mary Flynn", newEmployeeAddress, "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.updateEmployeeDetails(director, true);

        Assertions.assertEquals(newEmployeeAddress, employeeController.getEmployeeDetails(employeeId, true).getAddress());
    }

    @Test
    void testUpdateEmployeeDirectorDetailsWhenNotPresentInStorage() {
        Director director = new Director("0011", "Mary Flynn", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");

        // Assert that Director is not present in the DB
        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        // Assert that update failed
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(director, true));
    }

    @Test
    void testUpdateEmployeeDepartmentManager() {
        String employeeId = "0004";
        String newEmployeeAddress = "Belfast";

        // Create new Department Manager
        Director director = new Director(employeeId, "Bob Mitchell", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.registerEmployee(director, true);

        // Update address of Department Manager
        director = new Director(employeeId, "Bob Mitchell", newEmployeeAddress, "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.updateEmployeeDetails(director, true);

        Assertions.assertEquals(newEmployeeAddress, employeeController.getEmployeeDetails(employeeId, true).getAddress());
    }

    @Test
    void testUpdateEmployeeDepartmentManagerDetailsWhenNotPresentInStorage() {
        DepartmentManager departmentManager = new DepartmentManager("0012", "Agatha Moore", "Offaly", "21/04/1978",
                "4858697A", 120000, "Dublin");

        // Assert that Department Manager is not present in the DB
        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        // Assert that update failed
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(departmentManager, true));
    }


    @Test
    void testGetEmployeeDirectorDetails() {
        String employeeId = "0005";
        String employeeName = "John Hannon";

        Director director = new Director(employeeId, employeeName, "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.registerEmployee(director, true);

        Employee returnedEmployee = employeeController.getEmployeeDetails(employeeId, true);
        Assertions.assertEquals(employeeName, returnedEmployee.getName());
    }

    @Test
    void testGetEmployeeDepartmentManagerDetails() {
        String employeeId = "0006";
        String employeeName = "Mary Roberts";

        DepartmentManager departmentManager = new DepartmentManager(employeeId, employeeName, "Wexford", "01/02/1983",
                "1426794W", 43000, "Grocery");
        employeeController.registerEmployee(departmentManager, true);

        Employee returnedEmployee = employeeController.getEmployeeDetails(employeeId, true);
        Assertions.assertEquals(employeeName, returnedEmployee.getName());
    }

    @Test
    void testDeleteEmployeeDirector() {
        String employeeId = "0007";

        Director director = new Director(employeeId, "Liam Sweeney", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.registerEmployee(director, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(employeeId, true));
        Assertions.assertNull(employeeController.getEmployeeDetails(employeeId, true));
    }

    @Test
    void testDeleteEmployeeDirectorWhenNotPresentInStorage() {
        String employeeId = "0013";

        Director director = new Director(employeeId, "Lance McGuigan", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");

        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(employeeId, true));
    }

    @Test
    void testDeleteEmployeeDepartmentManager() {
        String employeeId = "0008";

        DepartmentManager departmentManager = new DepartmentManager(employeeId, "Mark Lyons", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
        employeeController.registerEmployee(departmentManager, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(employeeId, true));
        Assertions.assertNull(employeeController.getEmployeeDetails(employeeId, true));
    }

    @Test
    void testDeleteEmployeeDepartmentManagerWhenNotPresentInStorage() {
        String employeeId = "0014";

        DepartmentManager departmentManager = new DepartmentManager(employeeId, "Sarah Webb", "Clare", "21/04/1978",
                "4858697A", 20000, "Dublin");

        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(employeeId, true));
    }
}
