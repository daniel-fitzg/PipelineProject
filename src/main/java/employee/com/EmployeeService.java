package employee.com;

import java.util.List;

public abstract class EmployeeService {

    EmployeeDataStoreService employeeDataStoreService;

    public abstract String registerEmployee(Employee employee);
    public abstract String deleteEmployee(String employeeId);
    public abstract String updateEmployeeDetails(Employee employee);
    public abstract Employee getEmployeeDetails(String employeeId);
    public abstract List<Employee> getAllEmployeesDetails();
}
