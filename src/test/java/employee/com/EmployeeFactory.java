package employee.com;

/*
 * Used for testing purposes - returns Employee objects rather than manual entry for the test
 * */

import java.text.ParseException;

class EmployeeFactory {

    static Director getValidDirector() throws ParseException {
        return new Director("0001", "Jacob O'Leary", "Galway", "21/04/1978",
                "4858697A", 120000, "Dublin");
    }

    static DepartmentManager getValidDepartmentManager() throws ParseException {
        return new DepartmentManager("0002", "Mike Lam", "Wexford", "01/02/1983",
                "1426794W", 43000, "Grocery");
    }

    static CommissionBasedStaff getValidCommissionBasedStaff() throws ParseException {
        return new CommissionBasedStaff("1234", "John Lawless", "Main Street, Galway",
                "30/07/1996", "1234567G", 20000, 0.1);
    }

    static CommissionBasedStaff getInvalidEmployeDOBFormat() throws ParseException {
        return new CommissionBasedStaff("1234", "John Lawless", "Main Street, Galway",
                "30-7-1996", "1234567G", 20000, 0.1);
    }

    static BasicPlusCommissionBasedStaff getValidBasicPlusCommissionBasedStaff() throws ParseException {
        return new BasicPlusCommissionBasedStaff("5678", "Michael Finn", "Main Street, Limerick ",
                "30/07/1996", "1239967G", 20000, 0.1, 470);
    }

    static HourlyRateStaff getValidHourlyRateStaff() throws ParseException {
        return new HourlyRateStaff("1111", "Mary O'keffe", "Main Street, Dublin", "30/07/1986",
                "1774567G", 11.50, 40);
    }

    static HourlyRateStaff getValidHourlyRateStaffWithOvertime() throws ParseException {
        return new HourlyRateStaff("2222", "Aiofe McNamara", "Main Street, Cork", "30/07/1992",
                "1234887G", 12.50, 42);
    }
}