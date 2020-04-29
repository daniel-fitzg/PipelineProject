package employee.com;

public class Director extends Manager {

    private String region;
    private final double EXECUTIVE_BONUS_RATE = 0.3;

    public Director(String employeeId, String name, String address, String DOB, String ppsNo, double salary, String region) {
        super(employeeId, name, address, DOB, ppsNo, salary);
        setExecutiveBonusRate(EXECUTIVE_BONUS_RATE);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public double calculatePayment() {
        return 0.0;
    }
}
