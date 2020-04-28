package employee.com;

public abstract class EmployeeService {

    EmployeeDataStoreService employeeDataStoreService;
    ValidationService validationService;

    public abstract String registerEmployee(Employee employee);
    public abstract String deleteEmployee(String employeeId);
    public abstract String updateEmployeeDetails(Employee employee);
    public abstract Employee getEmployeeDetails(String employeeId);
}
