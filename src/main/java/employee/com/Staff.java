package employee.com;

/* Staff Class
 *
 * Renan Moraes
 * G00353112
 * 05/05/2020
 */

public abstract class Staff extends Employee {

    private double christmasBonusRate;
    private double sharedProfitBonusRate;
    private final double MAX_SHARED_BONUS_RATE = 0.1;
    private final double MAX_CHRISTMAS_BONUS_RATE = 1.0;
    final int TOTAL_DAYS_IN_A_YEAR = 365;

    Staff(String employeeId, String name, String address, String dob, String ppsNo){
        super(employeeId, name, address, dob, ppsNo);
        //setSharedProfitBonusRate(MAX_SHARED_BONUS_RATE);
        //setChristmasBonusRate(MAX_CHRISTMAS_BONUS_RATE);
    }

    public double getChristmasBonusRate() {
        return christmasBonusRate;
    }

    public void setChristmasBonusRate(double christmasBonusRate) {
        if (christmasBonusRate <= 0 || sharedProfitBonusRate >= MAX_CHRISTMAS_BONUS_RATE) {
            throw new IllegalArgumentException("Shared bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_CHRISTMAS_BONUS_RATE * 100)) + "%");
        }
        this.christmasBonusRate = christmasBonusRate;
    }

    public double getSharedProfitBonusRate() {
        return sharedProfitBonusRate;
    }

    public void setSharedProfitBonusRate(double shareBonus) {
        if(sharedProfitBonusRate <= 0 || sharedProfitBonusRate >= MAX_SHARED_BONUS_RATE) {
            throw new IllegalArgumentException("Shared bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_SHARED_BONUS_RATE * 100)) + "%");
        }
        this.sharedProfitBonusRate = shareBonus;
    }

    public abstract double calculateChristmasBonus(int totalWorkingDaysInAYear);
    public abstract double getMonthlyWage();

}
