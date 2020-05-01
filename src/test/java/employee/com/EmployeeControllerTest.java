package employee.com;

import org.junit.jupiter.api.*;

import java.text.ParseException;

// TODO
/*
 * Every test in this class must be repeated, but instead of Director or Department Manager objects it should be for the three staff objects
 * There are already 13 tests in this class, so this means that there will be about 20 more tests that must go into this class after the staff
 * classes are merged to master.
 *
 * If we still think that there should be more code and tests, we could add this functionality to the app:
 * - Get employee based on address, name etc...
 * - Get list of all employees
 * - Get list of all managers
 * - Get list of all staff
 *
 * BUT PLEASE CHECK WITH THE TEAM IF YOU WANT TO ADD ANY MORE FUNCTIONALITY!
 *
 * There are plenty of things we could do, but only if it is necessary i.e we need more code to make up the requirement
 * */

class EmployeeControllerTest {

    private EmployeeController employeeController = new EmployeeController();

    @BeforeAll
    static void printStart() {
        System.out.println("Starting tests for EmployeeController");
    }

    @AfterAll
    static void printComplete() {
        System.out.println("Tests complete for EmployeeController");
    }

    @DisplayName("Testing registration of valid Manager instances")
    @Test
    void testRegisterEmployeeManager() throws ParseException {
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidDirector(), true));
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidDepartmentManager(), true));
    }

    @DisplayName("Testing duplicate registration of valid Manager instances")
    @Test
    void testRegisterDuplicateEmployeeManager() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(director, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(director, true));

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(departmentManager, true));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(departmentManager, true));
    }

    @DisplayName("Testing valid update of Director details")
    @Test
    void testUpdateEmployeeDirectorDetails() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();
        Assertions.assertEquals("Galway", director.getAddress());
        Assertions.assertEquals("Dublin", director.getRegion());

        employeeController.registerEmployee(director, true);

        director.setAddress("Sligo");
        director.setRegion("Connaught");

        Assertions.assertEquals("SUCCESS", employeeController.updateEmployeeDetails(director, true));

        Director returnedEmployee = (Director) employeeController.getEmployeeDetails(director.getEmployeeId(), true);
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Connaught", returnedEmployee.getRegion());
    }

    @DisplayName("Testing valid update of Department Manager details")
    @Test
    void testUpdateEmployeeDepartmentManagerDetails() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Assertions.assertEquals("Wexford", departmentManager.getAddress());
        Assertions.assertEquals("Grocery", departmentManager.getDepartment());

        employeeController.registerEmployee(departmentManager, true);

        departmentManager.setAddress("Sligo");
        departmentManager.setDepartment("Hardware");

        Assertions.assertEquals("SUCCESS", employeeController.updateEmployeeDetails(departmentManager, true));

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true);
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Hardware", returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Director not present in the database")
    @Test
    void testUpdateEmployeeDirectorDetailsWhenNotPresentInStorage() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(director, true));
    }

    @DisplayName("Testing update failure when Department Manager not present in the database")
    @Test
    void testUpdateEmployeeDepartmentManagerDetailsWhenNotPresentInStorage() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.updateEmployeeDetails(departmentManager, true));
    }

    @DisplayName("Testing get Employee details for Director instance")
    @Test
    void testGetEmployeeDirectorDetails() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();
        employeeController.registerEmployee(director, true);

        Director returnedEmployee = (Director) employeeController.getEmployeeDetails(director.getEmployeeId(), true);
        Assertions.assertEquals(director.getName(), returnedEmployee.getName());
        Assertions.assertEquals(director.getRegion(), returnedEmployee.getRegion());
    }

    @DisplayName("Testing get Employee details for Department Manager instance")
    @Test
    void testGetEmployeeDepartmentManagerDetails() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        employeeController.registerEmployee(departmentManager, true);

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true);
        Assertions.assertEquals(departmentManager.getName(), returnedEmployee.getName());
        Assertions.assertEquals(departmentManager.getDepartment(), returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Manager instances not present in the database")
    @Test
    void testGetEmployeeDetailsWhenManagerNotPresentInStorage() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();
        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Director")
    @Test
    void testDeleteEmployeeDirector() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();
        employeeController.registerEmployee(director, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(director.getEmployeeId(), true));
        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Department Manager")
    @Test
    void testDeleteEmployeeDepartmentManager() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        employeeController.registerEmployee(departmentManager, true);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(departmentManager.getEmployeeId(), true));
        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Director when not present in the database")
    @Test
    void testDeleteEmployeeDirectorWhenNotPresentInStorage() throws ParseException {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertNull(employeeController.getEmployeeDetails(director.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(director.getEmployeeId(), true));
    }

    @DisplayName("Testing deletion of Department Manager when not present in the database")
    @Test
    void testDeleteEmployeeDepartmentManagerWhenNotPresentInStorage() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertNull(employeeController.getEmployeeDetails(departmentManager.getEmployeeId(), true));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(departmentManager.getEmployeeId(), true));
    }

    @DisplayName("Testing get all managers stored in the database")
    @Test
    void testGetAllManagersStoredInTheDatabase() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Director director = EmployeeFactory.getValidDirector();

        employeeController.registerEmployee(departmentManager, true);
        employeeController.registerEmployee(director, true);

        Assertions.assertEquals(2, employeeController.getAllEmployeeDetails(true).size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("0001", employeeController.getAllEmployeeDetails(true).get(0).getEmployeeId());
    }


    @DisplayName("Testing registration of valid Staff")
    @Test
    void testRegisterStaffEmployee() throws ParseException {
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidHourlyRateStaff(), false));
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidCommissionBasedStaff(), false));
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidBasicPlusCommissionBasedStaff(), false));
        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(EmployeeFactory.getValidHourlyRateStaffWithOvertime(), false));
    }

    @DisplayName("Testing duplicate registration of valid Staff instances")
    @Test
    void testRegisterDuplicateStaffEmployee() throws ParseException {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(commissionBasedStaff, false));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(commissionBasedStaff, false));

        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(basicPlusCommissionBasedStaff, false));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(basicPlusCommissionBasedStaff, false));

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerEmployee(hourlyRateStaff, false));
        Assertions.assertEquals("FAILURE", employeeController.registerEmployee(hourlyRateStaff, false));
    }

    @DisplayName("Testing get Staff Employee details ")
    @Test
    void testGetStaffEmployeeDetails() throws ParseException {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        employeeController.registerEmployee(commissionBasedStaff, false);

        CommissionBasedStaff returnedEmployee = (CommissionBasedStaff) employeeController.getEmployeeDetails(commissionBasedStaff.getEmployeeId(), false);
        Assertions.assertEquals(commissionBasedStaff.getName(), returnedEmployee.getName());
        Assertions.assertEquals(commissionBasedStaff.getCommissionRate(), returnedEmployee.getCommissionRate());
    }

    @DisplayName("Testing valid update of Staff details")
    @Test
    void testUpdateStaffEmployeeDetails() throws ParseException {
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        Assertions.assertEquals("Main Street, Dublin", hourlyRateStaff.getAddress());
        Assertions.assertEquals(11.50, hourlyRateStaff.getHourlyRate());

        employeeController.registerEmployee(hourlyRateStaff, false);

        hourlyRateStaff.setAddress("Tuam");
        hourlyRateStaff.setHourlyRate(15.50);

        Assertions.assertEquals("SUCCESS", employeeController.updateEmployeeDetails(hourlyRateStaff, false));

        HourlyRateStaff returnedEmployee = (HourlyRateStaff) employeeController.getEmployeeDetails(hourlyRateStaff.getEmployeeId(), false);
        Assertions.assertEquals("Tuam", returnedEmployee.getAddress());
        Assertions.assertEquals(15.50, returnedEmployee.getHourlyRate());
    }

    @DisplayName("Testing update failure when Staff is not present in the database")
    @Test
    void testGetStaffEmployeeDetailsWhenNotPresentInStorage() throws ParseException {
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        Assertions.assertNull(employeeController.getEmployeeDetails(basicPlusCommissionBasedStaff.getEmployeeId(), false));
    }

    @DisplayName("Testing get all staffs stored in the database")
    @Test
    void testGetAllStaffsStoredInTheDatabase() throws ParseException {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        employeeController.registerEmployee(commissionBasedStaff, false);
        employeeController.registerEmployee(basicPlusCommissionBasedStaff, false);
        employeeController.registerEmployee(hourlyRateStaff, false);

        Assertions.assertEquals(3, employeeController.getAllEmployeeDetails(false).size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("1111", employeeController.getAllEmployeeDetails(false).get(0).getEmployeeId());
    }
    @DisplayName("Testing deletion of Staff Employee")
    @Test
    void testDeleteStaffEmployee() throws ParseException {
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        employeeController.registerEmployee(hourlyRateStaff, false);

        Assertions.assertEquals("SUCCESS", employeeController.deleteEmployee(hourlyRateStaff.getEmployeeId(), false));
        Assertions.assertNull(employeeController.getEmployeeDetails(hourlyRateStaff.getEmployeeId(), false));
    }

    @DisplayName("Testing deletion of Staff when not present in the database")
    @Test
    void testDeleteStaffEmployeeWhenNotPresentInStorage() throws ParseException {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();

        Assertions.assertNull(employeeController.getEmployeeDetails(commissionBasedStaff.getEmployeeId(), false));
        Assertions.assertEquals("FAILURE", employeeController.deleteEmployee(commissionBasedStaff.getEmployeeId(), false));
    }


    @DisplayName("Testing get all employees stored in the database")
    @Test
    void testGetAllEmployeesStoredInTheDatabase() throws ParseException {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Director director = EmployeeFactory.getValidDirector();
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        employeeController.registerEmployee(departmentManager, true);
        employeeController.registerEmployee(director, true);
        employeeController.registerEmployee(commissionBasedStaff, false);
        employeeController.registerEmployee(basicPlusCommissionBasedStaff, false);
        employeeController.registerEmployee(hourlyRateStaff, false);

        Assertions.assertEquals(5, employeeController.getAllEmployeeDetails().size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("0001", employeeController.getAllEmployeeDetails().get(0).getEmployeeId());


    }
}