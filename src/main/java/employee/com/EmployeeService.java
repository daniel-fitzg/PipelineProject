package employee.com;

public abstract class EmployeeService {

    private EmployeeDataStoreService employeeDataStoreService;

    public abstract String registerEmployee();
    public abstract String deleteEmployee();
    public abstract String updateEmployeeDetails();
    public abstract Employee getEmployeeDetails();
}
