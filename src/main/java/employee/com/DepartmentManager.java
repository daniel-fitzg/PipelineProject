package employee.com;

class DepartmentManager extends Manager {

    private String department;
    private final double EXECUTIVE_BONUS_RATE = 0.1;

    DepartmentManager(String employeeId, String name, String address, String dob, String ppsNo, double salary, String department) {
        super(employeeId, name, address, dob, ppsNo, salary);
        setExecutiveBonusRate(EXECUTIVE_BONUS_RATE);
        setDepartment(department);
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

}

