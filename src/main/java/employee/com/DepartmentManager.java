package employee.com;

public class DepartmentManager extends Manager {

    private String department;

    public DepartmentManager(String employeeId, String name, String address, String DOB, String ppsNo, double salary, String department) {
        super(employeeId, name, address, DOB, ppsNo, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double calculatePayment() {
        return 0.0;
    }
}
