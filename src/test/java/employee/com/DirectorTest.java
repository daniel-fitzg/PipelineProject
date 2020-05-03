package employee.com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for Director");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for Director");
    }

    /*@DisplayName("Testing calculate payment for Director")
    @Test
    void testCalculatePayment() {
        Director director = EmployeeFactory.getValidDirector();
        double expectedPayment = director.getSalary() + (director.getSalary() * director.getExecutiveBonusRate());

        assertEquals(expectedPayment, director.calculatePayment());
    }*/
}