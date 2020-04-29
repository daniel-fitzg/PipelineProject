package employee.com;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicPlusCommissionBasedStaffTest extends CommissionBasedStaffTest {


    @DisplayName("********Testing valid basic wage********")
    @Test
    void setBasicWage() {
        assertEquals(470, createValidBasicPlusCommissionBasedEmployee().getBasicWage());
    }

    @DisplayName("********Testing Invalid basic wage********")
    @Test
    void testInvalidBasicWage() {
        final String underMinimumWage = "Basic wage cannot be less than MINBASICWAGE ";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () ->
                createValidBasicPlusCommissionBasedEmployee().setBasicWage(400));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing the payment calculation for basic plus commission staff********")
    @Test
    void testCalculatePayment() {
        assertEquals(2470, createValidBasicPlusCommissionBasedEmployee().calculatePayment());
    }

    public BasicPlusCommissionBasedStaff createValidBasicPlusCommissionBasedEmployee(){
        BasicPlusCommissionBasedStaff employee =new BasicPlusCommissionBasedStaff("1234",
                "John Lawless", "Main Street, Galway", "30/07/1996",
                "1234567G", 20000, 0.1, 470);
        return employee;

    }
}