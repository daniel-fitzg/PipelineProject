package employee.com;

/*
 * Abstract class that is extended by CommissionBasedStaff, BasicPlusCommissionBasedStaff, HourlyRateStaff
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

public abstract class Staff extends Employee {

    private double christmasBonusRate;
    private double sharedProfitBonusRate;
    private final double MAX_SHARED_BONUS_RATE = 0.1;
    private final double MAX_CHRISTMAS_BONUS_RATE = 1.0;
    final int TOTAL_DAYS_IN_A_YEAR = 365;

    Staff(String employeeId, String name, String address, String dob, String ppsNo){
        super(employeeId, name, address, dob, ppsNo);
        setSharedProfitBonusRate(MAX_SHARED_BONUS_RATE);
        setChristmasBonusRate(MAX_CHRISTMAS_BONUS_RATE);
    }

    double getChristmasBonusRate() {
        return christmasBonusRate;
    }

    void setChristmasBonusRate(double christmasBonusRate) {
        if (christmasBonusRate < 0 || christmasBonusRate > MAX_CHRISTMAS_BONUS_RATE) {
            throw new IllegalArgumentException("Christmas bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_CHRISTMAS_BONUS_RATE * 100)) + "%");
        }
        this.christmasBonusRate = christmasBonusRate;
    }

    double getSharedProfitBonusRate() {
        return sharedProfitBonusRate;
    }

    void setSharedProfitBonusRate(double sharedProfitBonusRate) {
        if(sharedProfitBonusRate < 0 || sharedProfitBonusRate > MAX_SHARED_BONUS_RATE) {
            throw new IllegalArgumentException("Shared profit bonus rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_SHARED_BONUS_RATE * 100)) + "%");
        }
        this.sharedProfitBonusRate = sharedProfitBonusRate;
    }

    public abstract double calculateChristmasBonus(int totalWorkingDaysInAYear);
    public abstract double getMonthlyWage();

}
