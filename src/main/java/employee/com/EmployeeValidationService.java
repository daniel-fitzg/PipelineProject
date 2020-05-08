package employee.com;

/*
 * Provides validation of the possible inputs that the system can expect
 *
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

class EmployeeValidationService {

   private final int MIN_AGE = 16;
   private final int EMPLOYEE_ID_MIN_LEN= 2;
   private final int PPS_NOT_MIN_LEN = 8;
   private final int MIN_NAME_LENGTH = 3;

   String checkEmployeeIdValidity(String employeeId) {
       if(employeeId.length() < EMPLOYEE_ID_MIN_LEN) {
           throw new IllegalArgumentException("Employee Id must have a minimum of " + EMPLOYEE_ID_MIN_LEN + " digits");
       } else {
           try {
               Integer.parseInt(employeeId);

               return employeeId;
           } catch (NumberFormatException e){
               return  null;
           }
       }
   }

   String checkEmployeeNameValidity(String name) {
       if(name.length() <= MIN_NAME_LENGTH) {
           throw new IllegalArgumentException("Employee name must be a minimum of four letters");
       }
       else {
           return name;
       }
   }

   String checkEmployeeAddressValidity(String address) {
       if(address.equals("")) {
           throw new IllegalArgumentException("Employee address cannot be empty");
       } else {
           return address;
       }
   }

/*
* The following method checks the validity of the Employee's date of birth
* the date of birth must be in the format of dd/MM/yyyy
* if cannot be parsed in this format the code throws a ParseException
* which is caught in the try/catch block
* and dob is set to null
* If dobEntered is not null
* we compare it to the present local date
* This check shows if the employee is over 16 years old
* and if the date entered is valid/not in the future
* */

    String checkDOBValidity(String dob) {
        Date today = new Date();
        Date dobEntered;

        try {
            dobEntered = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (ParseException e) {
            dobEntered = null;
        }

        if(dobEntered != null) {
            if(dobEntered.compareTo(today) < 0) {
                Calendar calendarInstance = Calendar.getInstance();
                calendarInstance.setTime(dobEntered);
                int year = calendarInstance.get(Calendar.YEAR);
                int month = calendarInstance.get(Calendar.MONTH) + 1;
                int date = calendarInstance.get(Calendar.DATE);
                LocalDate localdate = LocalDate.of(year, month, date);
                LocalDate thisDay = LocalDate.now();
                Period diff1 = Period.between(localdate, thisDay);

                if(diff1.getYears() < MIN_AGE) {
                    throw new IllegalArgumentException("Employee is under the MIN_AGE requirements");
                } else {
                    return dob;
                }
            } else {
                throw new IllegalArgumentException("Employee date of birth is invalid");
            }
        } else {
            return null;
        }
    }

/*
* The following method checks the PPS for the following:
* 1. That the PPS conforms to the required length
* 2. That the PPS contains at least one letter
*    but not more than two letters
*    Each character in the PPs is checked and counted
* 3. Checks for special characters in the PPs
*    Special characters are not allowed */

    String checkPPSNoValidity(String ppsNo) {
        if (ppsNo.length() < PPS_NOT_MIN_LEN) {
            throw new IllegalArgumentException("Employee PPS must fulfill the length requirements");
        } else {
            int letterCount = 0;
            int numberCount = 0;

            for (int i = 0; i < ppsNo.length(); i++) {
                char charaterInPPS = ppsNo.charAt(i);
                if (charaterInPPS >= 'A' && charaterInPPS <= 'Z') {
                    letterCount++;
                } else if (charaterInPPS >= '0' && charaterInPPS <= '9') {
                    numberCount++;
                } else {
                    throw new IllegalArgumentException("Employee PPS must not contain special characters or lowercase letters");
                }
            }

            if (letterCount == 0 || letterCount > 2 || numberCount == 0) {
                throw new IllegalArgumentException("Employee PPS must contain numbers and 1-2 letters");
            } else {
                return ppsNo;
            }
        }
    }

    String validate(String stringToValidate, final int MIN_LENGTH, boolean checkForNumbers, boolean checkForSpecialCharacters) {
       if (stringToValidate.equals("")) {
           throw new IllegalArgumentException("Empty String");
       }

       if (stringToValidate.length() < MIN_LENGTH) {
           throw new IllegalArgumentException("String doesn't meet minimum length requirement");
       }

       if (checkForNumbers) {
           if (!validateStringDoesNotContainNumbers(stringToValidate)) {
               throw new IllegalArgumentException("String contains numbers");
           }
       }

       if (checkForSpecialCharacters) {
           if (!validateStringDoesNotContainSpecialCharacters(stringToValidate)) {
               throw new IllegalArgumentException("String contains special characters");
           }
       }

       return stringToValidate;
    }

    private boolean validateStringDoesNotContainNumbers(String stringToValidate) {
        char character;

        for (int i = 0; i < stringToValidate.length(); i++) {
            character = stringToValidate.charAt(i);

            if (character >= '0' && character <= '9') {
                return false;
            }
        }

        return true;
    }

    private boolean validateStringDoesNotContainSpecialCharacters(String stringToValidate) {
        char character;

        for (int i = 0; i < stringToValidate.length(); i++) {
            character = stringToValidate.charAt(i);

            if (!(character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z')) {
                return false;
            }
        }

        return true;
    }
}
