package employee.com;

import java.util.List;

public class StaffService extends EmployeeService {

    StaffService() {
        employeeDataStoreService = new EmployeeDataStoreService();
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
    @Override
    public List<Employee> getAllEmployeesDetails() {
        return employeeDataStoreService.getAllEmployeesDetails();
    }

}
