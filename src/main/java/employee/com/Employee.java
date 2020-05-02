/* Author: John Lawless
*  Collaboration: Danny Fitzgerald and
* RENAN Leite De Moraes
*  Email: g00351835@gmit.ie
*  Date: 28/April/2020
*
 */

package employee.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee implements Comparable<Employee>  {

    private String employeeId;
    private String name;
    private String address;
    private String dob;
    private String ppsNo;
    EmployeeValidationService employeeValidationService =
            new EmployeeValidationService();


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

    public String getDOB() { return dob; }

    public void setDOB(String dob) {
        this.dob = employeeValidationService.checkDOBValidity(dob);
    }

    public String getPpsNo() {
        return ppsNo;
    }

    public void setPpsNo(String ppsNo) {
        this.ppsNo = employeeValidationService.checkPPSNoValidity(ppsNo);
    }

    // override equals and hashCode
    @Override
    public int compareTo(Employee employee) {
        return (Integer.parseInt(this.employeeId) - Integer.parseInt(employee.getEmployeeId()));
    }


    public abstract double calculatePayment();
}
