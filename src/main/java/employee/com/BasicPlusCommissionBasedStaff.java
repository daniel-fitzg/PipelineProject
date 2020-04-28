package employee.com;

public class BasicPlusCommissionBasedStaff extends CommissionBasedStaff {

   private double basicWage;

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        if(basicWage < 420){
            throw new IllegalArgumentException("Basic wage cannot be less than €420 a week ");
        }
        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {
        return (getValueOfIndividualSales() * getCommissionRate()) + basicWage;
    }

}
