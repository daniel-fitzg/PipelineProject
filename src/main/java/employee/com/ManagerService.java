package employee.com;

public class ManagerService extends EmployeeService {

    public ManagerService() {
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

    public double calculateExecutiveBonus(String employeeId) {
        Manager manager = (Manager) employeeDataStoreService.getEmployeeDetails(employeeId);

        return manager.getSalary() * manager.getExecutiveBonusRate();
    }
}
