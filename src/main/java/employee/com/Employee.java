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
    private final int EMPLOYEEIDMINLEN= 2;
    private final int PPSNOMINLEN = 8;
    private final int MINAGE = 16;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if(employeeId.length() < EMPLOYEEIDMINLEN ){
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
        if(address == ""){
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
            Calendar c = Calendar.getInstance();
            c.setTime(dobEntered);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int date = c.get(Calendar.DATE);
            LocalDate localdate = LocalDate.of(year, month, date);
            LocalDate thisDay = LocalDate.now();
            Period diff1 = Period.between(localdate, thisDay);
            if(diff1.getYears()< MINAGE){
                throw new IllegalArgumentException("Employee is under the MINAGE requirements");
            }else{
                this.dob = dob;
            }
        }else{
            throw new IllegalArgumentException("Employee date of birth is invalid");
        }
    }

    public String getPpsNo() {
        return ppsNo;
    }

    public void setPpsNo(String ppsNo) {
        if (ppsNo.length() < PPSNOMINLEN) {
            throw new IllegalArgumentException("Employee PPS must fulfill the PPSNOMINLEN requirements");
        } else{
            int letterCount = 0;
            int numberCount = 0;
            for (int i = 0; i < ppsNo.length(); i++) {
                char c = ppsNo.charAt(i);
                if (c >= 'A' & c <= 'Z') {
                    letterCount++;
                }else if(c >='0' & c<='9'){
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
    }

    public abstract double calculatePayment();
}
