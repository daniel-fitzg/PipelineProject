package employee.com;

public class DirectorService extends EmployeeService {

    private EmployeeDataStoreService employeeDataStoreService;
    private ValidationService validationService;


    DirectorService() {
        employeeDataStoreService = new EmployeeDataStoreService();
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
    public Director getEmployeeDetails() {
        return new Director();
    }
}
