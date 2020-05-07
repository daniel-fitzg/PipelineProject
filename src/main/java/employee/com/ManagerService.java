package employee.com;

/*
 * Service class used to service the Director and DepartmentManager classes
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

import java.util.List;

public class ManagerService extends EmployeeService {

    ManagerService() {
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

    double calculateExecutiveBonus(String employeeId) {
        Manager manager = (Manager) employeeDataStoreService.getEmployeeDetails(employeeId);

        return manager.getSalary() * manager.getExecutiveBonusRate();
    }
}
