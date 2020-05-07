package employee.com;

/*
* Handles incoming JSON requests that update/change/get Employee entities and data
*
* Contributors:
* Renan Moraes: g00353112@gmit.ie
* John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
*
* April/May 2020
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeController {

    private ManagerService managerService;
    private StaffService staffService;

    public EmployeeController() {
        this.managerService = new ManagerService();
        this.staffService = new StaffService();
    }

    public String registerManager(Employee employee) {
        return managerService.registerEmployee(employee);
    }

    public String registerStaff(Employee employee) {
        return staffService.registerEmployee(employee);
    }

    public String updateManagerDetails(Employee employee) {
        return managerService.updateEmployeeDetails(employee);
    }

    public String updateStaffDetails(Employee employee) {
        return staffService.updateEmployeeDetails(employee);
    }

    public Employee getManagerDetails(String employeeId) {
        return managerService.getEmployeeDetails(employeeId);
    }

    public Employee getStaffDetails(String employeeId) {
        return staffService.getEmployeeDetails(employeeId);
    }

    public List<Employee> getAllManagersDetails(){
        return managerService.getAllEmployeesDetails();
    }

    public List<Employee> getAllStaffDetails(){
        return staffService.getAllEmployeesDetails();
    }

    //Get All Employee Details
    public List<Employee> getAllEmployeeDetails(){
        List<Employee> totalEmployees = new ArrayList<>(staffService.getAllEmployeesDetails());
        totalEmployees.addAll(managerService.getAllEmployeesDetails());
        Collections.sort(totalEmployees);

        return totalEmployees;
    }

    // Delete Employee
    public String deleteManager(String employeeId) {
        return managerService.deleteEmployee(employeeId);
    }

    // Delete Employee
    public String deleteStaff(String employeeId) {
        return staffService.deleteEmployee(employeeId);
    }
}
