package employee.com;

/* Staff Class
 *
 * Renan Moraes
 * G00353112
 * 05/05/2020
 */

public abstract class Staff extends Employee {

    private double christmasBonusRate;
    private double sharedBonusRate;
    private final double MAX_SHARED_BONUS_RATE = 0.1;
    private final double MAX_CHRISTMAS_BONUS_RATE = 1.0;

    Staff(String employeeId, String name, String address, String dob, String ppsNo){
        super(employeeId, name, address, dob, ppsNo);
        setShareBonusRate(MAX_SHARED_BONUS_RATE);
        setChristmasBonus(MAX_CHRISTMAS_BONUS_RATE);
    }

    public double getChristmasBonusRate() {
        return christmasBonusRate;
    }

    public void setChristmasBonus(double christmasBonusRate) {
        if (christmasBonusRate <= 0 || sharedBonusRate >= MAX_CHRISTMAS_BONUS_RATE) {
            throw new IllegalArgumentException("Shared bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_CHRISTMAS_BONUS_RATE * 100)) + "%");
        }
        this.christmasBonusRate = christmasBonusRate;
    }

    public double getShareBonusRate() {
        return sharedBonusRate;
    }

    public void setShareBonusRate(double shareBonus) {
        if(sharedBonusRate <= 0 || sharedBonusRate >= MAX_SHARED_BONUS_RATE) {
            throw new IllegalArgumentException("Shared bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_SHARED_BONUS_RATE * 100)) + "%");
        }
        this.sharedBonusRate = shareBonus;
    }

    public abstract double calculateChristmasBonus(int totalWorkingDaysInAYear);
    public abstract double getMonthlyWage();

}
