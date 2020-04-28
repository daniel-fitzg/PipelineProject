package employee.com;

public abstract class EmployeeService {

    EmployeeDataStoreService employeeDataStoreService;
    ValidationService validationService;

    public abstract String registerEmployee();
    public abstract String deleteEmployee();
    public abstract String updateEmployeeDetails();
    public abstract Employee getEmployeeDetails();
}
