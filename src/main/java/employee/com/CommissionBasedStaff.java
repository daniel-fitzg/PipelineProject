/* Author: John Lawless
 *  Email: g00351835@gmit.ie
 *  Date: 28/April/2020
 *
 */

package employee.com;

public class CommissionBasedStaff extends Staff {

    private double valueOfIndividualSales;
    private double commissionRate;
    private double MAX_COMMISSION_RATE = 0.20;

    CommissionBasedStaff(String employeeId, String name, String address, String dob, String ppsNo, double valueOfIndividualSales, double commissionRate) {
        super(employeeId, name, address, dob, ppsNo);
        setValueOfIndividualSales(valueOfIndividualSales);
        setCommissionRate(commissionRate);
    }

    double getCommissionRate() {
        return commissionRate;
    }

    void setCommissionRate(double commissionRate) {
        if(commissionRate <= 0 || commissionRate >= MAX_COMMISSION_RATE) {
            throw new IllegalArgumentException("Commission rate must be greater than 0 and less than " +
                    String.format("%.0f", (MAX_COMMISSION_RATE * 100)) + "%");
        }else {
            this.commissionRate = commissionRate;
        }
    }

    double getValueOfIndividualSales() {
        return valueOfIndividualSales;
    }

    void setValueOfIndividualSales(double valueOfSales) {
        if(valueOfSales <= 0){
            throw new IllegalArgumentException("Value of sales must be greater than 0");
        }else {
            this.valueOfIndividualSales = valueOfSales;
        }
    }

      @Override
    public double calculatePayment() {
        double grossPayment = Math.round(valueOfIndividualSales * commissionRate);
        return grossPayment - deductionsPayableToRevenue(grossPayment);
    }

    @Override
    public double calculateChristmasBonus(int totalWorkingDaysInAYear) {

        double christmasBonus = getChristmasBonusRate() *
                (valueOfIndividualSales * commissionRate) / TOTAL_DAYS_IN_A_YEAR * totalWorkingDaysInAYear;

        return Math.round(christmasBonus - deductionsPayableToRevenue(christmasBonus));
    }

    @Override
    public double getMonthlyWage() {
        return Math.round(calculatePayment());
    }

}
