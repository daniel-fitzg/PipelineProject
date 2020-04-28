package employee.com;

public class StaffService extends EmployeeService {

    StaffService() {
        employeeDataStoreService = new EmployeeDataStoreService();
        validationService = new ValidationService();
    }

    @Override
    public String registerEmployee() {
        return "";
    }

    @Override
    public String deleteEmployee() {
        return "";
    }

    @Override
    public String updateEmployeeDetails() {
        return "";
    }

    @Override
    public Employee getEmployeeDetails() {
        // TODO change to staff employee after John's PR is merged
        return new DepartmentManager();
    }

}
