package employee.com;

public class CommissionBasedEmployee extends Employee {

    private double valueOfIndividualSales;
    private double commissionRate;



    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getValueOfIndividualSales() {
        return valueOfIndividualSales;
    }

    public void setValueOfIndividualSales(double valueOfSales) {
        this.valueOfIndividualSales = valueOfSales;
    }

    @Override
    public double calculatePayment() {
        double payment = valueOfIndividualSales * commissionRate;

        return payment;
    }
}
