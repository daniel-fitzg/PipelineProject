package employee.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyRateStaffTest {

    @DisplayName("********Testing valid hourly rate ")
    @Test
    void testValidHourlyRate() {
        assertEquals(11.50, createValidHourlyRateEmployee().getHourlyRate());
    }

    @DisplayName("********Testing invalid hourly rate ")
    @Test
    void testInvalidHourlyRate() {
        final String underMinimumWage = "€10.50/hr is minimum wage, " +
                "hourly rate must be equal to or above this rate ";
        Exception minimumWage = assertThrows(IllegalArgumentException.class, () ->
                createValidHourlyRateEmployee().setHourlyRate(10.00));
        assertEquals(underMinimumWage, minimumWage.getMessage());
    }

    @DisplayName("********Testing valid hours worked ")
    @Test
    void testValidHoursWorked() {
        assertEquals(40, createValidHourlyRateEmployee().getHoursWorked());
    }

    @DisplayName("********Testing invalid hours worked ")
    @Test
    void testInvalidHoursWorked() {
        final String underMinimumHours = "Hours worked cannot be less than/equal to 0";
        Exception noHoursWorked = assertThrows(IllegalArgumentException.class, () ->
                createValidHourlyRateEmployee().setHoursWorked(0));
        assertEquals(underMinimumHours, noHoursWorked.getMessage());
    }

    @DisplayName("********Testing payment calculation up to 40 hours********")
    @Test
    void testCalculatePaymentUpToFortyHours() {
        assertEquals(460.00, createValidHourlyRateEmployee().calculatePayment());
    }

    @DisplayName("********Testing payment calculation over 40 hours********")
    @Test
    void testCalculatePaymentOverFortyHours() {
        assertEquals(537.50, createValidHourlyRateEmployeeWithOvertime().calculatePayment());
    }

    //create a valid hourly rate employee
    public HourlyRateStaff createValidHourlyRateEmployee(){
        HourlyRateStaff employee =  new HourlyRateStaff("1234",
                "John Lawless", "Main Street, Galway", "30/07/1996",
                "1234567G", 11.50, 40);
        return employee;
    }

    //create a valid hourly rate employee with overtime
    public HourlyRateStaff createValidHourlyRateEmployeeWithOvertime(){
        HourlyRateStaff employee =  new HourlyRateStaff("1234",
                "John Lawless", "Main Street, Galway", "30/07/1996",
                "1234567G", 12.50, 42);
        return employee;
    }


}


