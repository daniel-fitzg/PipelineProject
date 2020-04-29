package employee.com;

public class ManagerService extends EmployeeService {

    public ManagerService() {
        employeeDataStoreService = new EmployeeDataStoreService();
        validationService = new ValidationService();
    }

    @Override
    public String registerEmployee(Employee employee) {
        // TODO: validation needs to happen here
//        if (validationService.validateEmployee(employee)) {
//            return employeeDataStoreService.registerEmployee();
//        }
//
//        return "FAILURE";

        return employeeDataStoreService.registerEmployee(employee);
    }

    @Override
    public String deleteEmployee(String employeeId) {
        return employeeDataStoreService.deleteEmployee(employeeId);
    }

    @Override
    public String updateEmployeeDetails(Employee employee) {
        // TODO: validation needs to happen here
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
