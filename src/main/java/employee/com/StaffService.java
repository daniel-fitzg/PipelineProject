package employee.com;

public class StaffService extends EmployeeService {

    public StaffService() {
        employeeDataStoreService = new EmployeeDataStoreService();
        validationService = new ValidationService();
    }

    @Override
    public String registerEmployee(Employee employee) {
        return employeeDataStoreService.registerEmployee(employee);
    }

    @Override
    public String deleteEmployee(String employeeId) {
        return employeeDataStoreService.deleteEmployee(employeeId);
    }

    @Override
    public String updateEmployeeDetails(Employee employee) {
        return employeeDataStoreService.updateEmployeeDetails(employee);
    }

    @Override
    public Employee getEmployeeDetails(String employeeId) {
        return employeeDataStoreService.getEmployeeDetails(employeeId);
    }

}
