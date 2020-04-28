package employee.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyRateStaffTest {

    private HourlyRateStaff employee;

    @DisplayName("********Testing get and set hourly rate ")
    @Test
    void testGetAndSetHourlyRate() {
        employee = new HourlyRateStaff();
        employee.setHourlyRate(11.50);
        assertEquals(11.50, employee.getHourlyRate());
        final String underMinimumWage = "€10.50/hr is minimum wage, " +
                "hourly rate must be equal to or above this rate ";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () -> employee.setHourlyRate(10.00));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @Test
    void testGetAndSetHoursWorked() {
        employee = new HourlyRateStaff();
        employee.setHoursWorked(40);
        assertEquals(40, employee.getHoursWorked());
        final String underMinimumHours = "Hours worked cannot be less than/equal to 0";
        Exception noHoursWorked = assertThrows(IllegalArgumentException.class, () -> employee.setHoursWorked(0));
        assertEquals(underMinimumHours, noHoursWorked.getMessage());
    }

    @DisplayName("********Testing payment calculation for hourly rate staff********")
    @Test
    void testCalculatePayment() {
        employee = new HourlyRateStaff();
        employee.setHourlyRate(12.50);
        employee.setHoursWorked(42);
        assertEquals(537.50, employee.calculatePayment());
        employee.setHourlyRate(12.50);
        employee.setHoursWorked(40);
        assertEquals(500.00, employee.calculatePayment());
    }
}


