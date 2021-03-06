package employee.com;

/*
 * Models a manager that receives a salary
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

class DepartmentManager extends Manager {

    private String department;
    private EmployeeValidationService employeeValidationService;
    private final int DEPT_MIN_LENGTH = 4;
    private final double EXECUTIVE_BONUS_RATE = 0.1;

    DepartmentManager(String employeeId, String name, String address, String dob, String ppsNo, double salary, String department) {
        super(employeeId, name, address, dob, ppsNo, salary);
        employeeValidationService = new EmployeeValidationService();
        setExecutiveBonusRate(EXECUTIVE_BONUS_RATE);
        setDepartment(department);
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = employeeValidationService.validate(department, DEPT_MIN_LENGTH, true, true);
    }
}

