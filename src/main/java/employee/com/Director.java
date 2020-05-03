package employee.com;

class Director extends Manager {

    private String region;
    private EmployeeValidationService employeeValidationService;
    private final double EXECUTIVE_BONUS_RATE = 0.3;

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
        this.region = employeeValidationService.validate(region);
    }
}
