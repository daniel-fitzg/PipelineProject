import employee.com.EmployeeController;
import org.junit.jupiter.api.*;

public class EmployeeControllerTest {

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
    public void testRegisterEmployeeWithValidArgs() {

    }

    @Test
    public void testCreateEmployeeWithInvalid() {

    }
}
