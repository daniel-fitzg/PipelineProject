package employee.com;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private static Map<String, Employee> employeesStorage = new HashMap<>();

    String registerEmployee(Employee employee) {
        if (employeesStorage.containsValue(employee)) {
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
        if(!employeesStorage.containsKey(employeeId)){
            throw new IllegalArgumentException("Employee register not found!");
        }else {
            return employeesStorage.get(employeeId);
        }
    }

    String deleteEmployee(String employeeId) {
        if (employeesStorage.containsKey(employeeId)) {
            employeesStorage.remove(employeeId);

            return "SUCCESS";
        }

        return "FAILURE";
    }
}
