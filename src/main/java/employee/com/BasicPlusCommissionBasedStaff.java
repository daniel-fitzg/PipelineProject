package employee.com;

public class BasicPlusCommissionBasedStaff extends CommissionBasedStaff {

   private double basicWage;
   private final double MINBASICWAGE = 420;

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        if(basicWage < MINBASICWAGE){
            throw new IllegalArgumentException("Basic wage cannot be less than MINBASICWAGE ");
        }
        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {
        return (getValueOfIndividualSales() * getCommissionRate()) + basicWage;
    }

}
