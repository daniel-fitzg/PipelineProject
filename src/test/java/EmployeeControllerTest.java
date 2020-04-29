import employee.com.*;
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

    @DisplayName("Testing registration of valid Manager instances")
    @Test
    void testRegisterEmployeeManager() {
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(getValidDirector(), true));
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(getValidDepartmentManager(), true));
    }

    @DisplayName("Testing duplicate registration of valid Manager instances")
    @Test
    void testRegisterDuplicateEmployeeManager() {
         Director director = getValidDirector();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(director, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(director, true));

        DepartmentManager departmentManager = getValidDepartmentManager();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(departmentManager, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(departmentManager, true));
    }

    @DisplayName("Testing valid update of Director details")
    @Test
    void testUpdateEmployeeDirectorDetails() {
        Director director = getValidDirector();
        Assertions.assertEquals("Galway", director.getAddress());
        Assertions.assertEquals("Dublin", director.getRegion());

        employeeController.registerEmployee(director, true);

        director.setAddress("Sligo");
        director.setRegion("Connaught");

        Assertions.assertEquals("SUCCESS", employeeController.updateEmployeeDetails(director, true));

        Director returnedEmployee = (Director) employeeController.getEmployeeDetails(director.getEmployeeId(), true);
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Connaught", returnedEmployee.getRegion());
    }

    @DisplayName("Testing valid update of Department Manager details")
    @Test
    void testUpdateEmployeeDepartmentManagerDetails() {
        DepartmentManager departmentManager = getValidDepartmentManager();
        Assertions.assertEquals("Wexford", departmentManager.getAddress());
        Assertions.assertEquals("Grocery", departmentManager.getDepartment());

        employeeController.registerEmployee(departmentManager, true);

        departmentManager.setAddress("Sligo");
        departmentManager.setDepartment("Hardware");

        Assertions.assertEquals("SUCCESS", employeeController.updateEmployeeDetails(departmentManager, true));

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true);
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Hardware", returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Director not present in the database")
    @Test
    void testUpdateEmployeeDirectorDetailsWhenNotPresentInStorage() {
        Director director = getValidDirector();

        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(director, true));
    }

    @DisplayName("Testing update failure when Department Manager not present in the database")
    @Test
    void testUpdateEmployeeDepartmentManagerDetailsWhenNotPresentInStorage() {
        DepartmentManager departmentManager = getValidDepartmentManager();

        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(departmentManager, true));
    }

    @DisplayName("Testing get Employee details for Director instance")
    @Test
    void testGetEmployeeDirectorDetails() {
        Director director = getValidDirector();
        employeeController.registerEmployee(director, true);

        Director returnedEmployee = (Director) employeeController.getEmployeeDetails(director.getEmployeeId(), true);
        Assertions.assertEquals(director.getName(), returnedEmployee.getName());
        Assertions.assertEquals(director.getRegion(), returnedEmployee.getRegion());
    }

    @DisplayName("Testing get Employee details for Department Manager instance")
    @Test
    void testGetEmployeeDepartmentManagerDetails() {
        DepartmentManager departmentManager = getValidDepartmentManager();
        employeeController.registerEmployee(departmentManager, true);

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true);
        Assertions.assertEquals(departmentManager.getName(), returnedEmployee.getName());
        Assertions.assertEquals(departmentManager.getDepartment(), returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Manager instances not present in the database")
    @Test
    void testGetEmployeeDetailsWhenManagerNotPresentInStorage() {
        Director director = getValidDirector();
        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));

        DepartmentManager departmentManager = getValidDepartmentManager();
        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Director")
    @Test
    void testDeleteEmployeeDirector() {
        Director director = getValidDirector();
        employeeController.registerEmployee(director, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(director.getEmployeeId(), true));
        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Department Manager")
    @Test
    void testDeleteEmployeeDepartmentManager() {
        DepartmentManager departmentManager = getValidDepartmentManager();
        employeeController.registerEmployee(departmentManager, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(departmentManager.getEmployeeId(), true));
        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Director when not present in the database")
    @Test
    void testDeleteEmployeeDirectorWhenNotPresentInStorage() {
        Director director = getValidDirector();

        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(director.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Department Manager when not present in the database")
    @Test
    void testDeleteEmployeeDepartmentManagerWhenNotPresentInStorage() {
        DepartmentManager departmentManager = getValidDepartmentManager();

        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(departmentManager.getEmployeeId(), true));
    }

    private Director getValidDirector() {
        return new Director("0001", "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
    }

    private DepartmentManager getValidDepartmentManager() {
        return new DepartmentManager("0002", "Mike Lam", "Wexford", "01/02/1983",
                "1426794W", 43000, "Grocery");
    }

}
