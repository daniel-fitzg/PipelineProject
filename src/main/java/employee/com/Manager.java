package employee.com;

public abstract class Manager extends Employee {

    private double salary;
    private double executiveBonusRate;

    Manager(String employeeId, String name, String address, String dob, String ppsNo, double salary){
        super(employeeId, name, address, dob, ppsNo);
        setSalary(salary);
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
         this.salary = salary;
    }

    double getExecutiveBonusRate() {
        return executiveBonusRate;
    }

    void setExecutiveBonusRate(double executiveBonusRate) {
        this.executiveBonusRate = executiveBonusRate;
    }

    @Override
    public double calculatePayment() {
        double salary = getSalary();
        double grossPayment = salary + (getExecutiveBonusRate() * salary);
        return grossPayment- deductionsPayableToRevenue(grossPayment);
    }
}
