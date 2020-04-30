import employee.com.DepartmentManager;
import employee.com.Director;
import employee.com.StaffService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Staff Service Test Class
*
* Renan Moraes
* G00353112
* 29/04/2020
*/
public class StaffServiceTest {

    private StaffService staffService = new StaffService();

    @BeforeAll
    static void printStart(){
        System.out.println("Starting test for StaffService");
    }

    @AfterAll
    static void printComplete(){
        System.out.println("Test complete for StaffService");
    }

    @DisplayName("Testing register new staff employee")
    @Test
    void testRegisterStaffEmployee(){
        // TODO: Replace with methods to return objects for the Staff classes - after John's merge
        Director director = EmployeeFactory.getValidDirector();

        assertEquals("SUCCESS", staffService.registerEmployee(director));
        // try duplication insertion for same employee in dataStorage
        assertEquals("FAILURE", staffService.registerEmployee(director));
    }

    @DisplayName("Testing delete staff employee")
    @Test
    void testDeleteStaffEmployee(){
        // TODO: Replace with methods to return objects for the Staff classes - after John's merge
        Director director = EmployeeFactory.getValidDirector();

        staffService.registerEmployee(director);

        assertEquals("SUCCESS", staffService.deleteEmployee(director.getEmployeeId()));
        //try delete a non-existent employee
        assertEquals("FAILURE", staffService.deleteEmployee(director.getEmployeeId()));
    }

    @DisplayName("Testing update staff employee")
    @Test
    void testUpdateStaffEmployee(){
        // TODO: Replace with methods to return objects for the Staff classes - after John's merge
        Director director = EmployeeFactory.getValidDirector();
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        staffService.registerEmployee(director);
        director.setDOB("18-11-1984");

        assertEquals("SUCCESS", staffService.updateEmployeeDetails(director));
        // try update non-existent employee in DataStorage
        assertEquals("FAILURE", staffService.updateEmployeeDetails(departmentManager));
    }

    @DisplayName("Testing get employee details")
    @Test
    void testGetEmployeeDetails(){
        // TODO: Replace with methods to return objects for the Staff classes - after John's merge
        Director director = EmployeeFactory.getValidDirector();
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        staffService.registerEmployee(director);

        assertEquals(director, staffService.getEmployeeDetails(director.getEmployeeId()));
        assertNull(staffService.getEmployeeDetails(departmentManager.getEmployeeId()));

    }


}
