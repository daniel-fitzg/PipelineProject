package employee.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class HourlyRateStaffTest {

    @DisplayName("********Testing valid hourly rate ")
    @Test
    void testValidHourlyRate() throws ParseException {
        assertEquals(11.50, EmployeeFactory.getValidHourlyRateStaff().getHourlyRate());
    }

    @DisplayName("********Testing invalid hourly rate ")
    @Test
    void testInvalidHourlyRate() {
        final String underMinimumWage = "€10.50/hr is minimum wage, " +
                "hourly rate must be equal to or above this rate ";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidHourlyRateStaff().setHourlyRate(10.00));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing valid hours worked ")
    @Test
    void testValidHoursWorked() throws ParseException {
        assertEquals(40, EmployeeFactory.getValidHourlyRateStaff().getHoursWorked());
    }

    @DisplayName("********Testing invalid hours worked ")
    @Test
    void testInvalidHoursWorked() {
        final String underMinimumHours = "Hours worked cannot be less than/equal to 0";
        Exception noHoursWorked = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidHourlyRateStaff().setHoursWorked(0));
        assertEquals(underMinimumHours, noHoursWorked.getMessage());
    }

    @DisplayName("********Testing payment calculation up to 40 hours********")
    @Test
    void testCalculatePaymentUpToFortyHours() throws ParseException {
        assertEquals(460.00, EmployeeFactory.getValidHourlyRateStaff().calculatePayment());
    }

    @DisplayName("********Testing payment calculation over 40 hours********")
    @Test
    void testCalculatePaymentOverFortyHours() throws ParseException {
        assertEquals(537.50, EmployeeFactory.getValidHourlyRateStaffWithOvertime().calculatePayment());
    }
}


