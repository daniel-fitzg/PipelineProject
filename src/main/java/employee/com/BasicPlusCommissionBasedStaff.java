package employee.com;

/*
 * Models a staff employee that receives a basic wage and commission
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

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
            throw new IllegalArgumentException("Basic wage cannot be less than €" + String.format("%.0f", MIN_BASIC_WAGE_PER_MONTH) + " per month");
        }

        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {
        double grossPayment = (getValueOfIndividualSales() * getCommissionRate()) + basicWage;
        return Math.round(grossPayment- deductionsPayableToRevenue(grossPayment));
    }
}
