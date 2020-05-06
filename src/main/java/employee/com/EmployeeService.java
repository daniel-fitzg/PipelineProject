package employee.com;

/*
 * Abstract service class that is extended by the ManagerService and StaffService classes
 *
 * Contributors:
 * Renan Moraes
 * John Lawless
 * Daniel Fitzgerald
 *
 * April/May 2020
 * */

import java.util.List;

public abstract class EmployeeService {

    EmployeeDataStoreService employeeDataStoreService;

    public abstract String registerEmployee(Employee employee);
    public abstract String deleteEmployee(String employeeId);
    public abstract String updateEmployeeDetails(Employee employee);
    public abstract Employee getEmployeeDetails(String employeeId);
    public abstract List<Employee> getAllEmployeesDetails();
}
