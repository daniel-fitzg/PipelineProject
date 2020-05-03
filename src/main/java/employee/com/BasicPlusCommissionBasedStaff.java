/* Author: John Lawless
*  Email: g00351835@gmit.ie
*  Date: 28/April/2020
*
*/
package employee.com;

public class BasicPlusCommissionBasedStaff extends CommissionBasedStaff {

   private double basicWage;
   private final double MIN_BASIC_WAGE_PER_MONTH = 1680;

   BasicPlusCommissionBasedStaff(String employeeId, String name, String address, String dob, String ppsNo, double valueOfIndividualSales, double commissionRate, double basicWage) {
        super(employeeId, name, address, dob, ppsNo, valueOfIndividualSales, commissionRate);
        setBasicWage(basicWage);
    }

    double getBasicWage() {
        return basicWage;
    }

    void setBasicWage(double basicWage) {
        if(basicWage < MIN_BASIC_WAGE_PER_MONTH){
            throw new IllegalArgumentException("Basic wage cannot be less than €" + MIN_BASIC_WAGE_PER_MONTH + " per month");
        }

        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {
        double grossPayment = (getValueOfIndividualSales() * getCommissionRate()) + basicWage;
        return Math.round(grossPayment- deductionsPayableToRevenue(grossPayment));
    }
}
