package employee.com;

/*
 * Models a manager that receives a salary
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

class Director extends Manager {

    private String region;
    private EmployeeValidationService employeeValidationService;

    private final double EXECUTIVE_BONUS_RATE = 0.3;
    private final int REGION_MIN_LENGTH = 4;

    Director(String employeeId, String name, String address, String dob, String ppsNo, double salary, String region){
        super(employeeId, name, address, dob, ppsNo, salary);
        employeeValidationService = new EmployeeValidationService();
        setExecutiveBonusRate(EXECUTIVE_BONUS_RATE);
        setRegion(region);
    }

    String getRegion() {
        return region;
    }

    void setRegion(String region) {
        this.region = employeeValidationService.validate(region, REGION_MIN_LENGTH, true, true);
    }
}
