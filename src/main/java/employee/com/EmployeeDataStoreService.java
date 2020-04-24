package employee.com;

public class EmployeeDataStoreService {

    private DataStore dataStore;

    EmployeeDataStoreService() {
        dataStore = new DataStore();
    }

    public String storeEmployee() {
        dataStore.storeEmployee();
        return "";
    }
}
