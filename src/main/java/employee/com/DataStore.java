package employee.com;

/*
 * Mocks a database class that will store employee objects
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

import java.util.*;

class DataStore {

    // Non-static allows simplification of tests as fewer unique Employee objects are needed in the test classes
    // For each test run employeesStorage will not contain any previous data
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
        if (employeesStorage.containsKey(employeeId)) {
            return employeesStorage.get(employeeId);
        }
        return null;
    }

    String deleteEmployee(String employeeId) {
        if (employeesStorage.containsKey(employeeId)) {
            employeesStorage.remove(employeeId);

            return "SUCCESS";
        }

        return "FAILURE";
    }

    List<Employee> getAllEmployeesDetails(){
        if(!employeesStorage.isEmpty()){
            List<Employee> employeeList = new ArrayList<>(employeesStorage.values());
            Collections.sort(employeeList);

            return employeeList;
        }
        return null;
    }
}
