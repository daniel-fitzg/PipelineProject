package employee.com;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public abstract class Employee  {

    private String employeeId;
    private String name;
    private String address;
    private String dob;
    private String ppsNo;
    private final int EMPLOYEE_ID_MIN_LEN= 2;
    private final int PPS_NOT_MIN_LEN = 8;
    private final int MIN_AGE = 16;
    private final int MIN_NAME_LENGTH = 3;

    public Employee(String employeeId, String name, String address, String dob, String ppsNo) {
        setEmployeeId(employeeId);
        setName(name);
        setAddress(address);
        try {
            setDOB(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setPpsNo(ppsNo);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if(employeeId.length() < EMPLOYEE_ID_MIN_LEN ){
            throw new IllegalArgumentException("Employee Id must have a minimum of two digits ");
        }
        else {
            try{
                Integer.parseInt(employeeId);
                this.employeeId = employeeId;
            }catch(NumberFormatException e){
                throw new NumberFormatException("EmployeeID is not a valid number");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() <= MIN_NAME_LENGTH){
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
        if(address.equals("")){
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
           checkDOBValidity(dobEntered, dob);
        }else{
            throw new IllegalArgumentException("Employee date of birth is invalid");
        }
    }

    public String getPpsNo() {
        return ppsNo;
    }

    public void setPpsNo(String ppsNo) {
        if (ppsNo.length() < PPS_NOT_MIN_LEN) {
            throw new IllegalArgumentException("Employee PPS must fulfill the length requirements");
        } else{
           checkPPSNoValidity(ppsNo);
        }
    }

    public void checkDOBValidity(Date dobEntered, String dob){
        Calendar c = Calendar.getInstance();
        c.setTime(dobEntered);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate localdate = LocalDate.of(year, month, date);
        LocalDate thisDay = LocalDate.now();
        Period diff1 = Period.between(localdate, thisDay);
        if(diff1.getYears()< MIN_AGE){
            throw new IllegalArgumentException("Employee is under the MIN_AGE requirements");
        }else{
            this.dob = dob;
        }
    }

    public void checkPPSNoValidity(String ppsNo){
        int letterCount = 0;
        int numberCount = 0;
        for (int i = 0; i < ppsNo.length(); i++) {
            char c = ppsNo.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                letterCount++;
            }else if(c >='0' && c<='9'){
                numberCount++;
            }else{
                throw new IllegalArgumentException("Employee PPS must not contain special characters or lowercase letters");
            }
        }
        if (letterCount == 0 || letterCount > 2) {
            throw new IllegalArgumentException("Employee PPS must contain numbers and 1-2 letters");
        }else{
            this.ppsNo = ppsNo;
        }
    }


    public abstract double calculatePayment();
}
