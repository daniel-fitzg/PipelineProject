import employee.com.EmployeeController;
import employee.com.StaffService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
* Staff Service Test Class
*
* Renan Moraes
* G00353112
* 29/04/2020
* */
public class StaffServiceTest {

    private StaffService staffServicer = new StaffService();

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

    }

    @DisplayName("Testing delete staff employee")
    @Test
    void testDeleteStaffEmployee(){

    }

    @DisplayName("Testing update staff employee")
    @Test
    void testUpdateStaffEmployee(){

    }

    @DisplayName("Testing get employee details")
    @Test
    void testGetEmployeeDetails(){

    }


}
