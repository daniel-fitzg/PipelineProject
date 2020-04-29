package employee.com;

public abstract class Manager extends Employee {

    private double salary;
    private double executiveBonusRate;

    Manager(String employeeId, String name, String address, String DOB, String ppsNo, double salary) {
        super(employeeId, name, address, DOB, ppsNo);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
         this.salary = salary;
    }

    public double getExecutiveBonusRate() {
        return executiveBonusRate;
    }

    public void setExecutiveBonusRate(double executiveBonusRate) {
        this.executiveBonusRate = executiveBonusRate;
    }
}
