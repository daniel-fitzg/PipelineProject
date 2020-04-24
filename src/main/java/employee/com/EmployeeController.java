package employee.com;

// Handles incoming JSON requests that update/change/get Employee entities and data

public class EmployeeController {

    DirectorService directorService;
    DepartmentManagerService departmentManagerService;

    public EmployeeController() {
        this.directorService = new DirectorService();
        this.departmentManagerService = new DepartmentManagerService();
    }

    // Register Director
    public String registerDirector() {
        // Register Director
        directorService.registerEmployee();
        return "";
    }

    // Update Director Details
    public String updateDirectorDetails() {
        directorService.updateEmployeeDetails();
        return "";
    }

    // Get Director Details
    public Employee getDirectorDetails() {
        return directorService.getEmployeeDetails();
    }

    // Delete Director
    public String deleteDirector() {
        directorService.deleteEmployee();
        return "";
    }

    // Register Department Manager
    public String registerDepartmentManager() {
        departmentManagerService.registerEmployee();
        return "";
    }

    // Update Department Manager Details
    public String updateDepartmentManagerDetails() {
        departmentManagerService.updateEmployeeDetails();
        return "";
    }

    // Get Department Manager Details
    public Employee getDepartmentManagerDetails() {
        return departmentManagerService.getEmployeeDetails();
    }

    // Delete Department Manager
    public String deleteDepartmentManager() {
        departmentManagerService.deleteEmployee();
        return "";
    }
}
