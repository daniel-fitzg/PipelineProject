package employee.com;

public abstract class Employee  {

    private String employeeId;
    private String name;
    private String Address;
    private String DOB;
    private String ppsNo;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPpsNo() {
        return ppsNo;
    }

    public void setPpsNo(String ppsNo) {
        this.ppsNo = ppsNo;
    }

    public abstract double calculatePayment();
}
