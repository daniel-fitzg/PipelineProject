package employee.com;

public class BasicPlusCommissionBasedEmployee extends CommissionBasedEmployee {

   private double basicWage;


    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        this.basicWage = basicWage;
    }

    @Override
    public double calculatePayment() {

        double payment = (getValueOfIndividualSales() * getCommissionRate()) + basicWage;

        return payment;
    }

}
