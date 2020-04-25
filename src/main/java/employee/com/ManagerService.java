package employee.com;

public class ManagerService extends EmployeeService {

    private EmployeeDataStoreService employeeDataStoreService;
    private ValidationService validationService;

    ManagerService() {
        employeeDataStoreService = new EmployeeDataStoreService();
        validationService = new ValidationService();
    }

    @Override
    public String registerEmployee() {
        if (validationService.validateEmployee()) {
            employeeDataStoreService.storeEmployee();
        }

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
        return new DepartmentManager();
    }
}
