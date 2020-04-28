package employee.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee  {

    private int employeeId;
    private String name;
    private String address;
    private String dob;
    private String ppsNo;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if(employeeId == 0){
            throw new IllegalArgumentException("Employee Id cannot be 0");
        }
        else {
            this.employeeId = employeeId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 3){
            throw new IllegalArgumentException("Employee name must be a minimum of four letters");
        }
        else {
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null){
            throw new IllegalArgumentException("Employee address cannot be empty");
        }
        else {
            this.address = address;
        }
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) throws ParseException {
        Date today = new Date();
        Date dobEntered = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        if(dobEntered.compareTo(today) < 0){
            this.dob = dob;
        }else{
            throw new IllegalArgumentException("Employee date of birth is invalid");
        }
    }

    public String getPpsNo() {
        return ppsNo;
    }

    public void setPpsNo(String ppsNo) {
        int letterCount = 0;
        int numberCount = 0;
        for(int i=0; i<ppsNo.length();i++){
            char c = ppsNo.charAt(i);
            if (c >= 'A' && c <='Z' || c>='a' && c<='z' ){
                letterCount++;
            }
        }
        if (letterCount== 0 || letterCount > 2){
            throw new IllegalArgumentException("Employee PPS must contain numbers and 1-2 letters");
        }else {
            this.ppsNo = ppsNo;
        }
    }

    public abstract double calculatePayment();
}
