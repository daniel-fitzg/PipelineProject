package employee.com;

import employee.com.DepartmentManager;
import employee.com.Director;

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

    // TODO: Methods to return objects for the Staff classes - after John's merge
}