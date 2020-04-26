package employee.com;

public abstract class Employee  {

    private String employeeId;
    private String name;
    private String address;
    private String DOB;
    private String ppsNo;

    Employee(String employeeId, String name, String address, String DOB, String ppsNo) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.DOB = DOB;
        this.ppsNo = ppsNo;
    }

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
        return address;
    }

    public void setAddress(String address) {
        address = address;
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
