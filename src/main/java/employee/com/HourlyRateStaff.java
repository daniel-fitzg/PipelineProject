/* Author: John Lawless
 *  Email: g00351835@gmit.ie
 *  Date: 28/April/2020
 *
 */

package employee.com;

public class HourlyRateStaff extends Employee {

    private double hourlyRate;
    private double hoursWorked;
    private final double NORMAL_HOURS = 40;
    private final double OVERTIME_RATE = 1.5;
    private final double MINIMUM_WAGE = 10.50;

    public HourlyRateStaff(String employeeId, String name, String address, String dob, String ppsNo, double hourlyRate, double hoursWorked){
        super(employeeId, name, address, dob, ppsNo);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate < MINIMUM_WAGE){
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
            throw new IllegalArgumentException("Hours worked cannot be less than/equal to 0");
        }else {
            this.hoursWorked = hoursWorked;
        }
    }

    @Override
    public double calculatePayment() {
        double basicPayment;
        double overtimePayment;
        if(NORMAL_HOURS < hoursWorked){
            basicPayment = hourlyRate * NORMAL_HOURS;
            overtimePayment = (hoursWorked - NORMAL_HOURS) * (OVERTIME_RATE* hourlyRate);
            return basicPayment + overtimePayment;
        }else {
            return hoursWorked * hourlyRate;
        }
    }
}
