package employee.com;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicPlusCommissionBasedStaffTest extends CommissionBasedStaffTest {

   private BasicPlusCommissionBasedStaff employee;

    @DisplayName("********Testing the setBasicWage method********")
    @Test
    void setBasicWage() {
        employee = new BasicPlusCommissionBasedStaff();
        employee.setBasicWage(455);
        assertEquals(455, employee.getBasicWage());
        final String underMinimumWage = "Basic wage cannot be less than MINBASICWAGE ";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () -> employee.setBasicWage(400));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing the payment calculation for basic plus commission staff********")
    @Test
    void testCalculatePayment() {
        employee = new BasicPlusCommissionBasedStaff();
        employee.setBasicWage(455);
        employee.setValueOfIndividualSales(20000);
        employee.setCommissionRate(0.05);
        assertEquals(1455, employee.calculatePayment());
    }
}