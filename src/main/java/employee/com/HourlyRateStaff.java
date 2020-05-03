/* Author: John Lawless
 *  Email: g00351835@gmit.ie
 *  Date: 28/April/2020
 *
 */

package employee.com;

public class HourlyRateStaff extends Employee implements DeductionsPayableToRevenue {

    private double hourlyRate;
    private double hoursWorked;
    private final double NORMAL_HOURS = 40;
    private final double OVERTIME_RATE = 1.5;
    private final double MINIMUM_WAGE = 10.50;
    private final double WEEKS_PER_MONTH = 4;


    public HourlyRateStaff(String employeeId, String name, String address, String dob, String ppsNo, double hourlyRate, double hoursWorked){
        super(employeeId, name, address, dob, ppsNo);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate < MINIMUM_WAGE){
            throw new IllegalArgumentException("€10.50/hr is minimum wage, " +
                    "hourly rate must be equal to or above this rate ");
        }else {
            this.hourlyRate = hourlyRate;
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked <= 0){
            throw new IllegalArgumentException("Hours worked cannot be less than/equal to 0");
        }else {
            this.hoursWorked = hoursWorked;
        }
    }

    @Override
    public double calculatePayment() {
        double basicPayment;
        double overtimePayment;
        double grossPayment;
        double netPayment;
        if(NORMAL_HOURS < hoursWorked){
            basicPayment = hourlyRate * NORMAL_HOURS;
            overtimePayment = (hoursWorked - NORMAL_HOURS) * (OVERTIME_RATE* hourlyRate);
            grossPayment = basicPayment + overtimePayment;
        }else {
            grossPayment  = hoursWorked * hourlyRate;
        }
        netPayment = grossPayment- deductionsPayableToRevenue(grossPayment);
        return netPayment;
    }


    @Override
    public double deductionsPayableToRevenue(double grossPayment) {
        double highRateOfTaxPayment;
        double lowRateTaxPayment;
        double uscPayment = Math.round(grossPayment*USC_DEDUCTION);
        double prsiPayment = Math.round(grossPayment*PRSI_DEDUCTION);
        if(grossPayment > LOW_RATE_TAX_CUT_OFF_PER_MONTH/WEEKS_PER_MONTH){
            highRateOfTaxPayment  = Math.round((grossPayment-(LOW_RATE_TAX_CUT_OFF_PER_MONTH/WEEKS_PER_MONTH))
                    *HIGH_RATE_OF_TAX);
            lowRateTaxPayment = Math.round(((LOW_RATE_TAX_CUT_OFF_PER_MONTH/WEEKS_PER_MONTH)-(TAX_CREDIT_PER_MONTH/WEEKS_PER_MONTH))
                    *LOW_RATE_OF_TAX);
        }else{
            highRateOfTaxPayment  = 0;
            lowRateTaxPayment = Math.round((grossPayment-(TAX_CREDIT_PER_MONTH/WEEKS_PER_MONTH))
                    *LOW_RATE_OF_TAX);
        }

        return highRateOfTaxPayment +lowRateTaxPayment+uscPayment+prsiPayment;
    }
}
