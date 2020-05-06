package employee.com;

/*
 * Models a staff employee that receives an hourly rate wage
 *
 * Contributors:
 * Renan Moraes
 * John Lawless
 * Daniel Fitzgerald
 *
 * April/May 2020
 * */

public class HourlyRateStaff extends Staff implements DeductionsPayableToRevenue {

    private double hourlyRate;
    private double hoursWorked;
    private final double NORMAL_HOURS = 40;
    private final double OVERTIME_RATE = 1.5;
    private final double MINIMUM_WAGE = 10.50;
    private final double WEEKS_PER_MONTH = 4;


    HourlyRateStaff(String employeeId, String name, String address, String dob, String ppsNo, double hourlyRate, double hoursWorked){
        super(employeeId, name, address, dob, ppsNo);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    double getHourlyRate() {
        return hourlyRate;
    }

    void setHourlyRate(double hourlyRate) {
        if(hourlyRate < MINIMUM_WAGE) {
            throw new IllegalArgumentException("€" + String.format("%.2f", MINIMUM_WAGE) + "/hr is minimum wage, hourly rate must be equal to or above this rate ");
        } else {
            this.hourlyRate = hourlyRate;
        }
    }

    double getHoursWorked() {
        return hoursWorked;
    }

    void setHoursWorked(double hoursWorked) {
        if(hoursWorked <= 0){
            throw new IllegalArgumentException("Hours worked cannot be less than/equal to 0");
        } else {
            this.hoursWorked = hoursWorked;
        }
    }

    @Override
    public double calculatePayment() {
        double basicPayment;
        double overtimePayment;
        double grossPayment;

        if(NORMAL_HOURS < hoursWorked){
            basicPayment = hourlyRate * NORMAL_HOURS;
            overtimePayment = (hoursWorked - NORMAL_HOURS) * (OVERTIME_RATE * hourlyRate);
            grossPayment = basicPayment + overtimePayment;
        } else {
            grossPayment  = hoursWorked * hourlyRate;
        }

        return grossPayment- deductionsPayableToRevenue(grossPayment);
    }

    @Override
    public double deductionsPayableToRevenue(double grossPayment) {
        double highRateTaxPayment;
        double lowRateTaxPayment;
        double uscPayment = Math.round(grossPayment * USC_DEDUCTION);
        double prsiPayment = Math.round(grossPayment * PRSI_DEDUCTION);

        if(grossPayment > LOW_RATE_TAX_CUT_OFF_PER_MONTH / WEEKS_PER_MONTH) {
            highRateTaxPayment = Math.round((grossPayment - (LOW_RATE_TAX_CUT_OFF_PER_MONTH / WEEKS_PER_MONTH)) * HIGH_RATE_OF_TAX);
            lowRateTaxPayment = Math.round(((LOW_RATE_TAX_CUT_OFF_PER_MONTH / WEEKS_PER_MONTH) - (TAX_CREDIT_PER_MONTH/WEEKS_PER_MONTH)) * LOW_RATE_OF_TAX);
        } else {
            highRateTaxPayment = 0;
            lowRateTaxPayment = Math.round((grossPayment - (TAX_CREDIT_PER_MONTH / WEEKS_PER_MONTH)) * LOW_RATE_OF_TAX);
        }

        return highRateTaxPayment + lowRateTaxPayment+uscPayment + prsiPayment;
    }

    @Override
    public double calculateChristmasBonus(int totalWorkingDaysInAYear) {
        double christmasBonus =  getChristmasBonusRate() *
                (hoursWorked * hourlyRate)/TOTAL_DAYS_IN_A_YEAR * totalWorkingDaysInAYear;
        return christmasBonus - deductionsPayableToRevenue(christmasBonus);
    }

    @Override
    public double getMonthlyWage() {
        return Math.round(calculatePayment());
    }

}
