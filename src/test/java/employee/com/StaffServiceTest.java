package employee.com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/* Staff Service Test Class
 *
 * Renan Moraes
 * G00353112
 * 29/04/2020
 */
class StaffServiceTest {

    private StaffService staffService = new StaffService();

    @BeforeAll
    static void printStart(){
        System.out.println("Starting test for StaffService");
    }

    @AfterAll
    static void printComplete(){
        System.out.println("Test complete for StaffService");
    }

    @DisplayName("Testing register new staff employee")
    @Test
    void testRegisterStaffEmployee(){

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();

        assertEquals("SUCCESS", staffService.registerEmployee(commissionBasedStaff));
        // try duplication insertion for same employee in dataStorage
        assertEquals("FAILURE", staffService.registerEmployee(commissionBasedStaff));
    }

    @DisplayName("Testing delete staff employee")
    @Test
    void testDeleteStaffEmployee(){

        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();

        staffService.registerEmployee(basicPlusCommissionBasedStaff);

        assertEquals("SUCCESS", staffService.deleteEmployee(basicPlusCommissionBasedStaff.getEmployeeId()));
        //try delete a non-existent employee
        assertEquals("FAILURE", staffService.deleteEmployee(basicPlusCommissionBasedStaff.getEmployeeId()));
    }

    @DisplayName("Testing update staff employee")
    @Test
    void testUpdateStaffEmployee(){

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        staffService.registerEmployee(commissionBasedStaff);
        commissionBasedStaff.setDOB("18/11/1984");
        assertEquals("SUCCESS", staffService.updateEmployeeDetails(commissionBasedStaff));
        // try update non-existent employee in DataStorage
        assertEquals("FAILURE", staffService.updateEmployeeDetails(hourlyRateStaff));
    }

    @DisplayName("Testing get employee details")
    @Test
    void testGetEmployeeDetails(){

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        staffService.registerEmployee(commissionBasedStaff);

        assertEquals(commissionBasedStaff, staffService.getEmployeeDetails(commissionBasedStaff.getEmployeeId()));
        assertNull(staffService.getEmployeeDetails(hourlyRateStaff.getEmployeeId()));

    }

    @DisplayName("Testing get all employee details")
    @Test
    void testGetAllEmployeeDetails() {

        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        HourlyRateStaff hourlyRateStaff1 = EmployeeFactory.getValidHourlyRateStaffWithOvertime();

        staffService.registerEmployee(commissionBasedStaff);
        staffService.registerEmployee(basicPlusCommissionBasedStaff);
        staffService.registerEmployee(hourlyRateStaff);
        staffService.registerEmployee(hourlyRateStaff1);

        assertEquals(4, staffService.getAllEmployeesDetails().size());

    }

    @DisplayName("Testing get all employee details when database is empty")
    @Test
    void testGetAllEmployeeDetailsNull(){
        assertNull(staffService.getAllEmployeesDetails());
    }


}
