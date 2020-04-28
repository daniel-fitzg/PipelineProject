package employee.com;

class EmployeeDataStoreService {

    private DataStore dataStore;

    EmployeeDataStoreService() {
        dataStore = new DataStore();
    }

    String registerEmployee(Employee employee) {
        return dataStore.registerEmployee(employee);
    }

    String updateEmployeeDetails(Employee employee) {
        return dataStore.updateEmployeeDetails(employee);
    }

    Employee getEmployeeDetails(String employeeId) {
        return dataStore.getEmployeeDetails(employeeId);
    }

    String deleteEmployee(String employeeId) {
        return dataStore.deleteEmployee(employeeId);
    }
}
