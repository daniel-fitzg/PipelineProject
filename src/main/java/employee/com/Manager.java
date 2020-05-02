package employee.com;

import java.text.ParseException;

public abstract class Manager extends Employee {

    private double salary;
    private double executiveBonusRate;

    public Manager(String employeeId, String name, String address, String dob, String ppsNo, double salary){
        super(employeeId, name, address, dob, ppsNo);
        setSalary(salary);
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
