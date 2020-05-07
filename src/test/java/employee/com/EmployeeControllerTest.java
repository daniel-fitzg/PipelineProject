package employee.com;

import org.junit.jupiter.api.*;

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
    void testRegisterEmployeeManager() {
        Assertions.assertEquals("SUCCESS", employeeController.registerManager(EmployeeFactory.getValidDirector()));
        Assertions.assertEquals("SUCCESS", employeeController.registerManager(EmployeeFactory.getValidDepartmentManager()));
    }

    @DisplayName("Testing duplicate registration of valid Manager instances")
    @Test
    void testRegisterDuplicateEmployeeManager() {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertEquals("SUCCESS", employeeController.registerManager(director));
        Assertions.assertEquals("FAILURE", employeeController.registerManager(director));

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertEquals("SUCCESS", employeeController.registerManager(departmentManager));
        Assertions.assertEquals("FAILURE", employeeController.registerManager(departmentManager));
    }

    @DisplayName("Testing valid update of Director details")
    @Test
    void testUpdateEmployeeDirectorDetails() {
        Director director = EmployeeFactory.getValidDirector();
        Assertions.assertEquals("Galway", director.getAddress());
        Assertions.assertEquals("Dublin", director.getRegion());

        employeeController.registerManager(director);

        director.setAddress("Sligo");
        director.setRegion("Connaught");

        Assertions.assertEquals("SUCCESS", employeeController.updateManagerDetails(director));

        Director returnedEmployee = (Director) employeeController.getManagerDetails(director.getEmployeeId());
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Connaught", returnedEmployee.getRegion());
    }

    @DisplayName("Testing valid update of Department Manager details")
    @Test
    void testUpdateEmployeeDepartmentManagerDetails() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Assertions.assertEquals("Wexford", departmentManager.getAddress());
        Assertions.assertEquals("Grocery", departmentManager.getDepartment());

        employeeController.registerManager(departmentManager);

        departmentManager.setAddress("Sligo");
        departmentManager.setDepartment("Hardware");

        Assertions.assertEquals("SUCCESS", employeeController.updateManagerDetails(departmentManager));

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getManagerDetails(departmentManager.getEmployeeId());
        Assertions.assertEquals("Sligo", returnedEmployee.getAddress());
        Assertions.assertEquals("Hardware", returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Director not present in the database")
    @Test
    void testUpdateEmployeeDirectorDetailsWhenNotPresentInStorage() {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertNull(employeeController.getManagerDetails(director.getEmployeeId()));
        Assertions.assertEquals("FAILURE", employeeController.updateManagerDetails(director));
    }

    @DisplayName("Testing update failure when Department Manager not present in the database")
    @Test
    void testUpdateEmployeeDepartmentManagerDetailsWhenNotPresentInStorage() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertNull(employeeController.getManagerDetails(departmentManager.getEmployeeId()));
        Assertions.assertEquals("FAILURE", employeeController.updateManagerDetails(departmentManager));
    }

    @DisplayName("Testing get Employee details for Director instance")
    @Test
    void testGetEmployeeDirectorDetails() {
        Director director = EmployeeFactory.getValidDirector();
        employeeController.registerManager(director);

        Director returnedEmployee = (Director) employeeController.getManagerDetails(director.getEmployeeId());
        Assertions.assertEquals(director.getName(), returnedEmployee.getName());
        Assertions.assertEquals(director.getRegion(), returnedEmployee.getRegion());
    }

    @DisplayName("Testing get Employee details for Department Manager instance")
    @Test
    void testGetEmployeeDepartmentManagerDetails() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        employeeController.registerManager(departmentManager);

        DepartmentManager returnedEmployee = (DepartmentManager) employeeController.getManagerDetails(departmentManager.getEmployeeId());
        Assertions.assertEquals(departmentManager.getName(), returnedEmployee.getName());
        Assertions.assertEquals(departmentManager.getDepartment(), returnedEmployee.getDepartment());
    }

    @DisplayName("Testing update failure when Manager instances not present in the database")
    @Test
    void testGetEmployeeDetailsWhenManagerNotPresentInStorage() {
        Director director = EmployeeFactory.getValidDirector();
        Assertions.assertNull(employeeController.getManagerDetails(director.getEmployeeId()));

        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Assertions.assertNull(employeeController.getManagerDetails(departmentManager.getEmployeeId()));
    }

    @DisplayName("Testing deletion of Director")
    @Test
    void testDeleteEmployeeDirector() {
        Director director = EmployeeFactory.getValidDirector();
        employeeController.registerManager(director);

        Assertions.assertEquals("SUCCESS", employeeController.deleteManager(director.getEmployeeId()));
        Assertions.assertNull(employeeController.getManagerDetails(director.getEmployeeId()));
    }

    @DisplayName("Testing deletion of Department Manager")
    @Test
    void testDeleteEmployeeDepartmentManager() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        employeeController.registerManager(departmentManager);

        Assertions.assertEquals("SUCCESS", employeeController.deleteManager(departmentManager.getEmployeeId()));
        Assertions.assertNull(employeeController.getManagerDetails(departmentManager.getEmployeeId()));
    }

    @DisplayName("Testing deletion of Director when not present in the database")
    @Test
    void testDeleteEmployeeDirectorWhenNotPresentInStorage() {
        Director director = EmployeeFactory.getValidDirector();

        Assertions.assertNull(employeeController.getManagerDetails(director.getEmployeeId()));
        Assertions.assertEquals("FAILURE", employeeController.deleteManager(director.getEmployeeId()));
    }

    @DisplayName("Testing deletion of Department Manager when not present in the database")
    @Test
    void testDeleteEmployeeDepartmentManagerWhenNotPresentInStorage() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();

        Assertions.assertNull(employeeController.getManagerDetails(departmentManager.getEmployeeId()));
        Assertions.assertEquals("FAILURE", employeeController.deleteManager(departmentManager.getEmployeeId()));
    }

    @DisplayName("Testing get all managers stored in the database")
    @Test
    void testGetAllManagersStoredInTheDatabase() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Director director = EmployeeFactory.getValidDirector();

        employeeController.registerManager(departmentManager);
        employeeController.registerManager(director);

        Assertions.assertEquals(2, employeeController.getAllManagersDetails().size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("0001", employeeController.getAllManagersDetails().get(0).getEmployeeId());
    }


    @DisplayName("Testing registration of valid Staff")
    @Test
    void testRegisterStaffEmployee() {
        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(EmployeeFactory.getValidHourlyRateStaff()));
        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(EmployeeFactory.getValidCommissionBasedStaff()));
        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(EmployeeFactory.getValidBasicPlusCommissionBasedStaff()));
        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(EmployeeFactory.getValidHourlyRateStaffWithOvertime()));
    }

    @DisplayName("Testing duplicate registration of valid Staff instances")
    @Test
    void testRegisterDuplicateStaffEmployee() {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(commissionBasedStaff));
        Assertions.assertEquals("FAILURE", employeeController.registerStaff(commissionBasedStaff));

        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(basicPlusCommissionBasedStaff));
        Assertions.assertEquals("FAILURE", employeeController.registerStaff(basicPlusCommissionBasedStaff));

        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        Assertions.assertEquals("SUCCESS", employeeController.registerStaff(hourlyRateStaff));
        Assertions.assertEquals("FAILURE", employeeController.registerStaff(hourlyRateStaff));
    }

    @DisplayName("Testing get Staff Employee details ")
    @Test
    void testGetStaffEmployeeDetails() {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        employeeController.registerStaff(commissionBasedStaff);

        CommissionBasedStaff returnedEmployee = (CommissionBasedStaff) employeeController.getStaffDetails(commissionBasedStaff.getEmployeeId());
        Assertions.assertEquals(commissionBasedStaff.getName(), returnedEmployee.getName());
        Assertions.assertEquals(commissionBasedStaff.getCommissionRate(), returnedEmployee.getCommissionRate());
    }

    @DisplayName("Testing valid update of Staff details")
    @Test
    void testUpdateStaffEmployeeDetails() {
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        Assertions.assertEquals("Main Street, Dublin", hourlyRateStaff.getAddress());
        Assertions.assertEquals(11.50, hourlyRateStaff.getHourlyRate());

        employeeController.registerStaff(hourlyRateStaff);

        hourlyRateStaff.setAddress("Tuam");
        hourlyRateStaff.setHourlyRate(15.50);

        Assertions.assertEquals("SUCCESS", employeeController.updateStaffDetails(hourlyRateStaff));

        HourlyRateStaff returnedEmployee = (HourlyRateStaff) employeeController.getStaffDetails(hourlyRateStaff.getEmployeeId());
        Assertions.assertEquals("Tuam", returnedEmployee.getAddress());
        Assertions.assertEquals(15.50, returnedEmployee.getHourlyRate());
    }

    @DisplayName("Testing update failure when Staff is not present in the database")
    @Test
    void testGetStaffEmployeeDetailsWhenNotPresentInStorage() {
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        Assertions.assertNull(employeeController.getStaffDetails(basicPlusCommissionBasedStaff.getEmployeeId()));
    }

    @DisplayName("Testing get all staffs stored in the database")
    @Test
    void testGetAllStaffsStoredInTheDatabase() {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        employeeController.registerStaff(commissionBasedStaff);
        employeeController.registerStaff(basicPlusCommissionBasedStaff);
        employeeController.registerStaff(hourlyRateStaff);

        Assertions.assertEquals(3, employeeController.getAllStaffDetails().size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("1111", employeeController.getAllStaffDetails().get(0).getEmployeeId());
    }
    @DisplayName("Testing deletion of Staff Employee")
    @Test
    void testDeleteStaffEmployee() {
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();
        employeeController.registerStaff(hourlyRateStaff);

        Assertions.assertEquals("SUCCESS", employeeController.deleteStaff(hourlyRateStaff.getEmployeeId()));
        Assertions.assertNull(employeeController.getStaffDetails(hourlyRateStaff.getEmployeeId()));
    }

    @DisplayName("Testing deletion of Staff when not present in the database")
    @Test
    void testDeleteStaffEmployeeWhenNotPresentInStorage() {
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();

        Assertions.assertNull(employeeController.getStaffDetails(commissionBasedStaff.getEmployeeId()));
        Assertions.assertEquals("FAILURE", employeeController.deleteStaff(commissionBasedStaff.getEmployeeId()));
    }


    @DisplayName("Testing get all employees stored in the database")
    @Test
    void testGetAllEmployeesStoredInTheDatabase() {
        DepartmentManager departmentManager = EmployeeFactory.getValidDepartmentManager();
        Director director = EmployeeFactory.getValidDirector();
        CommissionBasedStaff commissionBasedStaff = EmployeeFactory.getValidCommissionBasedStaff();
        BasicPlusCommissionBasedStaff basicPlusCommissionBasedStaff = EmployeeFactory.getValidBasicPlusCommissionBasedStaff();
        HourlyRateStaff hourlyRateStaff = EmployeeFactory.getValidHourlyRateStaff();

        employeeController.registerManager(departmentManager);
        employeeController.registerManager(director);
        employeeController.registerStaff(commissionBasedStaff);
        employeeController.registerStaff(basicPlusCommissionBasedStaff);
        employeeController.registerStaff(hourlyRateStaff);

        Assertions.assertEquals(5, employeeController.getAllEmployeeDetails().size());
        //Test with list is sorted by employee id
        Assertions.assertEquals("0001", employeeController.getAllEmployeeDetails().get(0).getEmployeeId());
    }
}