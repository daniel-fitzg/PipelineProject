package employee.com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static employee.com.EmployeeFactory.getValidCommissionBasedStaff;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StaffTest {

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for Staff");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for Staff");
    }

    @DisplayName("Testing get christmas bonus rate")
    @Test
    void testGetChristmasBonusRate() {

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        assertEquals(1.0, hourlyRateStaff.getChristmasBonusRate());
    }

    @DisplayName("Testing get shared profit bonus rate")
    @Test
    void testGetSharedProfitBonusRate() {

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        assertEquals(0.1, commissionBasedStaff.getSharedProfitBonusRate());
    }

    @DisplayName("Testing set christmas bonus rate")
    @Test
    void testSetChristmasBonusRate() {

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        assertEquals(1.0, hourlyRateStaff.getChristmasBonusRate());
        hourlyRateStaff.setChristmasBonusRate(0.8);
        assertEquals(0.8, hourlyRateStaff.getChristmasBonusRate());
    }

    @DisplayName("Testing set shared profit bonus rate")
    @Test
    void testSetSharedProfitBonusRate() {

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        assertEquals(0.1, commissionBasedStaff.getSharedProfitBonusRate());
        commissionBasedStaff.setSharedProfitBonusRate(0.05);
        assertEquals(0.05, commissionBasedStaff.getSharedProfitBonusRate());
    }

    @DisplayName("Testing set invalid christmas bonus rate")
    @Test
    void testSetInvalidChristmasBonusRate() {

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
               hourlyRateStaff.setChristmasBonusRate(1.27));
        assertEquals("Christmas bonus rate must be greater than 0 and less than 100%",
                exception.getMessage());
    }

    @DisplayName("Testing set invalid shared profit bonus rate ")
    @Test
    void testSetInvalidSharedProfitBonusRate() {

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                commissionBasedStaff.setSharedProfitBonusRate(0.27));
         assertEquals("Shared profit bonus rate must be greater than 0 and less than 10%",
                 exception.getMessage());
    }

    @DisplayName("Testing set christmas bonus rate less than zero")
    @Test
    void testSetChristmasBonusRateLessThanZero() {

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                hourlyRateStaff.setChristmasBonusRate(-0.1));
        assertEquals("Christmas bonus rate must be greater than 0 and less than 100%",
                exception.getMessage());
    }

    @DisplayName("Testing set shared profit bonus rate less than zero")
    @Test
    void testSetSharedProfitBonusRateLessThanZero() {

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                commissionBasedStaff.setSharedProfitBonusRate(-0.1));
        assertEquals("Shared profit bonus rate must be greater than 0 and less than 10%",
                exception.getMessage());
    }
}
