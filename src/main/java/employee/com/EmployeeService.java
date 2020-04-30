package employee.com;

public abstract class EmployeeService {

    EmployeeDataStoreService employeeDataStoreService;

    public abstract String registerEmployee(Employee employee);
    public abstract String deleteEmployee(String employeeId);
    public abstract String updateEmployeeDetails(Employee employee);
    public abstract Employee getEmployeeDetails(String employeeId);
}
