package employee.com;

/*
* Used for testing purposes - returns Employee objects rather than manual entry for the test
* */

class EmployeeFactory {

    static Director getValidDirector() {
        return new Director("0001", "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
    }

    static DepartmentManager getValidDepartmentManager() {
        return new DepartmentManager("0002", "Mike Lam", "Wexford", "01/02/1983",
                "1426794W", 43000, "Grocery");
    }

    static CommissionBasedStaff getValidCommissionBasedStaff() {
        return new CommissionBasedStaff("1234", "John Lawless", "Main Street, Galway",
                "30/07/1996", "1234567G", 20000, 0.1);
    }

    static BasicPlusCommissionBasedStaff getValidBasicPlusCommissionBasedStaff() {
        return new BasicPlusCommissionBasedStaff("1234", "John Lawless", "Main Street, Galway",
                "30/07/1996", "1234567G", 20000, 0.1, 470);
    }

    static HourlyRateStaff getValidHourlyRateStaff() {
        return new HourlyRateStaff("1234", "John Lawless", "Main Street, Galway", "30/07/1996",
                "1234567G", 11.50, 40);
    }

    static HourlyRateStaff getValidHourlyRateStaffWithOvertime() {
        return new HourlyRateStaff("1234", "John Lawless", "Main Street, Galway", "30/07/1996",
                "1234567G", 12.50, 42);
    }
}