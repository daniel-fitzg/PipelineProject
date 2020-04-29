package employee.com;

public class StaffService extends EmployeeService {

    public StaffService() {
        employeeDataStoreService = new EmployeeDataStoreService();
        validationService = new ValidationService();
    }

    @Override
    public String registerEmployee(Employee employee) {
        return employeeDataStoreService.registerEmployee(employee);
    }

    @Override
    public String deleteEmployee(String employeeId) {
        return "";
    }

    @Override
    public String updateEmployeeDetails(Employee employee) {
        // TODO: validation needs to happen here
        return "";
    }

    @Override
    public Employee getEmployeeDetails(String employeeId) {
        // TODO change to staff employee after John's PR is merged
        return new Director("9416", "Jacob O'Leary", "Galway", "21-04-1978",
                "4858697A", 120000, "Dublin");
    }

}
