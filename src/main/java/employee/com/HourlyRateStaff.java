package employee.com;

public class HourlyRateStaff extends Employee {

    private double hourlyRate;
    private double hoursWorked;
    private final double NORMALHOURS = 40;
    private final double overtimeRate = hourlyRate *1.5;



    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate < 10.50){
            throw new IllegalArgumentException("€10.50/hr is minimum wage, " +
                    "hourly rate must be equal to or above this rate ");
        }else {
            this.hourlyRate = hourlyRate;
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked <= 0){
            throw new IllegalArgumentException("Hours worked cannot be less than/ equal to 0");
        }else {
            this.hoursWorked = hoursWorked;
        }
    }

    @Override
    public double calculatePayment() {

        double payment;
        double basicPayment;
        double overtimePayment;

        if(hoursWorked > NORMALHOURS){
            basicPayment = hourlyRate * NORMALHOURS;
            overtimePayment = (hoursWorked - NORMALHOURS) * overtimeRate;
            payment = basicPayment + overtimePayment;
        }else {
            payment = hoursWorked * hourlyRate;
        }
        return payment;
    }
}
