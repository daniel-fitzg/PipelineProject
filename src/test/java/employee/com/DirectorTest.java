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

    @DisplayName("Testing validation of setRegion method")
    @Test
    void testValidateSetRegion() {
        Director director = EmployeeFactory.getValidDirector();
        assertEquals("Dublin", director.getRegion());

        director.setRegion("Cork");
        assertEquals("Cork", director.getRegion());
    }

    @DisplayName("Testing validation of setRegion method with invalid argument")
    @Test
    void testValidateSetRegionWithInvalidArg() {
        Director director = EmployeeFactory.getValidDirector();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { director.setRegion(""); });
        assertEquals("Empty String", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { director.setRegion("Cor"); });
        assertEquals("String doesn't meet minimum length requirement", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { director.setRegion("Cork9"); });
        assertEquals("String contains numbers", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { director.setRegion("Cor*k"); });
        assertEquals("String contains special characters", exception.getMessage());
    }
}