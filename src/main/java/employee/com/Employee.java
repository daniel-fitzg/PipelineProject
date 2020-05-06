package employee.com;

/*
 * Models an abstract employee object that is extended by every other employee-type class
 *
 * Contributors:
 * Renan Moraes
 * John Lawless
 * Daniel Fitzgerald
 *
 * April/May 2020
 * */

public abstract class Employee implements Comparable<Employee>, DeductionsPayableToRevenue {

    private String employeeId;
    private String name;
    private String address;
    private String dob;
    private String ppsNo;
    private EmployeeValidationService employeeValidationService = new EmployeeValidationService();


    public Employee(String employeeId, String name, String address, String dob, String ppsNo) {
        setEmployeeId(employeeId);
        setName(name);
        setAddress(address);
        setDOB(dob);
        setPpsNo(ppsNo);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeValidationService.checkEmployeeIdValidity(employeeId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = employeeValidationService.checkEmployeeNameValidity(name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
       this.address = employeeValidationService.checkEmployeeAddressValidity(address);
    }

    String getDOB() { return dob; }

    void setDOB(String dob) {
        this.dob = employeeValidationService.checkDOBValidity(dob);
    }

    String getPpsNo() {
        return ppsNo;
    }

    void setPpsNo(String ppsNo) {
        this.ppsNo = employeeValidationService.checkPPSNoValidity(ppsNo);
    }

    // override equals and hashCode
    @Override
    public int compareTo(Employee employee) {
        return (Integer.parseInt(this.employeeId) - Integer.parseInt(employee.getEmployeeId()));
    }

    public abstract double calculatePayment();

    @Override
    public double deductionsPayableToRevenue(double grossPayment) {
        double highRateTaxPayment;
        double lowRateTaxPayment;
        double uscPayment = Math.round(grossPayment * USC_DEDUCTION);
        double prsiPayment = Math.round(grossPayment * PRSI_DEDUCTION);

        if(grossPayment > LOW_RATE_TAX_CUT_OFF_PER_MONTH) {
            highRateTaxPayment = Math.round((grossPayment - (LOW_RATE_TAX_CUT_OFF_PER_MONTH)) * HIGH_RATE_OF_TAX);
            lowRateTaxPayment = Math.round(((LOW_RATE_TAX_CUT_OFF_PER_MONTH) - (TAX_CREDIT_PER_MONTH)) * LOW_RATE_OF_TAX);
        } else {
            highRateTaxPayment = 0;
            lowRateTaxPayment = Math.round((grossPayment - (TAX_CREDIT_PER_MONTH)) * LOW_RATE_OF_TAX);
        }

        return highRateTaxPayment + lowRateTaxPayment+uscPayment + prsiPayment;
    }
}
