package employee.com;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    // Non-static allows simplification of tests as fewer unique Employee objects are needed in the test classes
    private Map<String, Employee> employeesStorage = new HashMap<>();

    String registerEmployee(Employee employee) {
        if (employeesStorage.containsKey(employee.getEmployeeId())) {
            return "FAILURE";
        }

        employeesStorage.put(employee.getEmployeeId(), employee);
        return "SUCCESS";
    }

    String updateEmployeeDetails(Employee employee) {
        String employeeId = employee.getEmployeeId();

        if (employeesStorage.containsKey(employeeId)) {
            employeesStorage.remove(employeeId);
            employeesStorage.put(employeeId, employee);

            return "SUCCESS";
        }

        return "FAILURE";
    }

    Employee getEmployeeDetails(String employeeId) {
        return employeesStorage.get(employeeId);
    }

    String deleteEmployee(String employeeId) {
        if (employeesStorage.containsKey(employeeId)) {
            employeesStorage.remove(employeeId);

            return "SUCCESS";
        }

        return "FAILURE";
    }
}
