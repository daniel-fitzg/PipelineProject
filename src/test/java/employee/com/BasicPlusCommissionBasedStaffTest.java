/* Author: John Lawless
 *  Email: g00351835@gmit.ie
 *  Date: 28/April/2020
 *
 */

package employee.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicPlusCommissionBasedStaffTest {


    @DisplayName("********Testing valid basic wage********")
    @Test
    void setBasicWage() {
        assertEquals(1690, EmployeeFactory.getValidBasicPlusCommissionBasedStaff().getBasicWage());
    }

    @DisplayName("********Testing Invalid basic wage********")
    @Test
    void testInvalidBasicWage() {
        final String underMinimumWage = "Basic wage cannot be less than €1680.0 per month";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidBasicPlusCommissionBasedStaff().setBasicWage(1580));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing the payment calculation for basic plus commission staff********")
    @Test
    void testCalculatePayment() {
        assertEquals(2547.00, EmployeeFactory.getValidBasicPlusCommissionBasedStaff().calculatePayment());
    }
}