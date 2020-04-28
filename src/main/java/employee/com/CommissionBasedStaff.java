package employee.com;

public class CommissionBasedStaff extends Employee {

    private double valueOfIndividualSales;
    private double commissionRate;
    private double MAXCOMMISSIONRATE = 0.20;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if(commissionRate <= 0 || commissionRate >= MAXCOMMISSIONRATE){
            throw new IllegalArgumentException("Commission rate must be greater than 0 and less than MAXCOMMISSIONRATE");
        }else {
            this.commissionRate = commissionRate;
        }
    }

    public double getValueOfIndividualSales() {
        return valueOfIndividualSales;
    }

    public void setValueOfIndividualSales(double valueOfSales) {
        if(valueOfSales<=0){
            throw new IllegalArgumentException("Value of sales must be greater than 0");
        }else {
            this.valueOfIndividualSales = valueOfSales;
        }
    }

    @Override
    public double calculatePayment() {
        return valueOfIndividualSales * commissionRate;
    }
}
