package employee.com;

// Handles incoming JSON requests that update/change/get Employee entities and data

public class EmployeeController {

    private ManagerService managerService;
    private StaffService staffService;

    public EmployeeController() {
        this.managerService = new ManagerService();
        this.staffService = new StaffService();
    }

    // Register Employee
    public String registerEmployee(Employee employee, boolean isManager) {
        if (isManager) {
            return managerService.registerEmployee(employee);
        } else {
            return staffService.registerEmployee(employee);
        }
    }

    // Update Employee Details
    public String updateEmployeeDetails(Employee employee, boolean isManager) {
        if (isManager) {
            return managerService.updateEmployeeDetails(employee);
        } else {
            return staffService.updateEmployeeDetails(employee);
        }
    }

    // Get Employee Details
    public Employee getEmployeeDetails(String employeeId, boolean isManager) {
        if (isManager) {
            return managerService.getEmployeeDetails(employeeId);
        } else {
            return staffService.getEmployeeDetails(employeeId);
        }
    }

    // Delete Employee
    public String deleteEmployee(String employeeId, boolean isManager) {
        if (isManager) {
            return managerService.deleteEmployee(employeeId);
        } else {
            return staffService.deleteEmployee(employeeId);
        }
    }

}
