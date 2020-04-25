package employee.com;

public class HourlyRateEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorked;
    private final double overtimeRate = hourlyRate *1.5;




    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {

        double payment;
        double basicPayment;
        double overtimePayment;

        if(hoursWorked > 40){
            basicPayment = hourlyRate * 40;
            overtimePayment = (hoursWorked - 40) * overtimeRate;
            payment = basicPayment + overtimePayment;
        }else
            payment = hoursWorked * hourlyRate;

        return payment;
    }
}
