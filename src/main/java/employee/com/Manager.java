package employee.com;

/*
 * Abstract class that is extended by Director and DepartmentManager classes
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

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
