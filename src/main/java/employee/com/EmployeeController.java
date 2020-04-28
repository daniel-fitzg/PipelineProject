package employee.com;

// Handles incoming JSON requests that update/change/get Employee entities and data

public class EmployeeController {

    ManagerService managerService;
    // TODO: StaffService here too

    public EmployeeController() {
        this.managerService = new ManagerService();
    }

    // Register Director
    public String registerDirector() {
        managerService.registerEmployee();
        return "";
    }

    // Update Director Details
    public String updateDirectorDetails() {
        managerService.updateEmployeeDetails();
        return "";
    }

    // Get Director Details
    public Employee getDirectorDetails() {
        return managerService.getEmployeeDetails();
    }

    // Delete Director
    public String deleteDirector() {
        managerService.deleteEmployee();
        return "";
    }

    // Register Department Manager
    public String registerDepartmentManager() {
        managerService.registerEmployee();
        return "";
    }

    // Update Department Manager Details
    public String updateDepartmentManagerDetails() {
        managerService.updateEmployeeDetails();
        return "";
    }

    // Get Department Manager Details
    public Employee getDepartmentManagerDetails() {
        return managerService.getEmployeeDetails();
    }

    // Delete Department Manager
    public String deleteDepartmentManager() {
        managerService.deleteEmployee();
        return "";
    }
}
