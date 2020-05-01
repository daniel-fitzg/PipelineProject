package employee.com;

import java.text.ParseException;

public class BasicPlusCommissionBasedStaff extends CommissionBasedStaff {

   private double basicWage;
   private final double MIN_BASIC_WAGE = 420;

    public BasicPlusCommissionBasedStaff(String employeeId, String name, String address, String dob, String ppsNo, double valueOfIndividualSales, double commissionRate, double basicWage) throws ParseException {
        super(employeeId, name, address, dob, ppsNo, valueOfIndividualSales, commissionRate);
        setBasicWage(basicWage);
    }

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        if(basicWage < MIN_BASIC_WAGE){
            throw new IllegalArgumentException("Basic wage cannot be less than €420 per week");
        }
        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {
        return (getValueOfIndividualSales() * getCommissionRate()) + basicWage;
    }

}
