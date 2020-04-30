package employee.com;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicPlusCommissionBasedStaffTest {


    @DisplayName("********Testing valid basic wage********")
    @Test
    void setBasicWage() {
        assertEquals(470, EmployeeFactory.getValidBasicPlusCommissionBasedStaff().getBasicWage());
    }

    @DisplayName("********Testing Invalid basic wage********")
    @Test
    void testInvalidBasicWage() {
        final String underMinimumWage = "Basic wage cannot be less than €420 per week";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidBasicPlusCommissionBasedStaff().setBasicWage(400));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing the payment calculation for basic plus commission staff********")
    @Test
    void testCalculatePayment() {
        assertEquals(2470, EmployeeFactory.getValidBasicPlusCommissionBasedStaff().calculatePayment());
    }
}