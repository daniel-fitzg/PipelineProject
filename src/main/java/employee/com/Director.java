package employee.com;

public class Director extends Manager {

    private String region;
    private final double EXECUTIVE_BONUS_RATE = 0.3;


    public Director(String employeeId, String name, String address, String dob, String ppsNo, double salary, String region){
        super(employeeId, name, address, dob, ppsNo, salary);
        setExecutiveBonusRate(EXECUTIVE_BONUS_RATE);
        setRegion(region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public double calculatePayment() {
        double salary = getSalary();

        return salary + (getExecutiveBonusRate() * salary);
    }
}
