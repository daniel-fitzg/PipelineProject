package employee.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import java.text.ParseException;

public class CommissionBasedStaffTest {


   private CommissionBasedStaff employee;

    @DisplayName("********Testing the CommissionBasedEmployee get and set setEmployeeID**********")
    @Test
    void testCommissionBasedStaffSetEmployeeId(){
        employee = new CommissionBasedStaff();
        employee.setEmployeeId("1245");
        assertEquals("1245", employee.getEmployeeId());
        final String cannotBeZero = "Employee Id must have a minimum of two digits ";
        Exception zero = assertThrows(IllegalArgumentException.class,()->employee.setEmployeeId("0"));
        assertEquals(cannotBeZero, zero.getMessage());
        final String mustBeNum = "EmployeeID is not a valid number";
        Exception notANum = assertThrows(NumberFormatException.class,()->employee.setEmployeeId("AAA"));
        assertEquals(mustBeNum, notANum.getMessage());
    }

    @DisplayName("********Testing the CommissionBasedEmployee get and set name**********")
    @Test
    void testGetSetNameOfEmployee() {
        employee = new CommissionBasedStaff();
        employee.setName("John Lawless");
        assertEquals("John Lawless", employee.getName());
        final String invalidName = "Employee name must be a minimum of four letters";
        Exception name = assertThrows(IllegalArgumentException.class,()->employee.setName("aa"));
        assertEquals(invalidName, name.getMessage());
    }

    @DisplayName("********Testing the CommissionBasedEmployee get and set address**********")
    @Test
    void testGetSetAddressOfEmployee() {
        employee = new CommissionBasedStaff();
        employee.setAddress("Main Street");
        assertEquals("Main Street", employee.getAddress());
        final String invalidAddress = "Employee address cannot be empty";
        Exception address = assertThrows(IllegalArgumentException.class,()->employee.setAddress(""));
        assertEquals(invalidAddress, address.getMessage());
    }

    @DisplayName("********Testing the get and set for date of Birth")
    @Test
    void testGetAndSetDOBOfEmployee() throws ParseException {
        employee = new CommissionBasedStaff();
        employee.setDOB("30/7/1970");
        assertEquals("30/7/1970", employee.getDOB());
        final String invalidDOB= "Employee date of birth is invalid";
        Exception age = assertThrows(IllegalArgumentException.class,()->employee.setDOB("30/07/2021"));
        assertEquals(invalidDOB, age.getMessage());
        final String toYoung= "Employee is under the MINAGE requirements";
        Exception underAge = assertThrows(IllegalArgumentException.class,()->employee.setDOB("30/07/2010"));
        assertEquals(toYoung, underAge.getMessage());
    }

    @DisplayName("********Testing the get and set for PPS Number")
    @Test
    void testGetAndSetPPSNo() {
        employee = new CommissionBasedStaff();
        employee.setPpsNo("1234567A");
        assertEquals("1234567A", employee.getPpsNo());
        employee.setPpsNo("1234567BC");
        assertEquals("1234567BC", employee.getPpsNo());
        final String invalidPPSNo= "Employee PPS must fulfill the PPSNOMINLEN requirements";
        Exception shortPPSNo = assertThrows(IllegalArgumentException.class,()->employee.setPpsNo("1234AA"));
        assertEquals(invalidPPSNo, shortPPSNo.getMessage());
        final String wrongPPSFormat= "Employee PPS must contain numbers and 1-2 letters";
        Exception wrongFormat = assertThrows(IllegalArgumentException.class,()->employee.setPpsNo("123456789"));
        assertEquals(wrongPPSFormat, wrongFormat.getMessage());
        wrongFormat = assertThrows(IllegalArgumentException.class,()->employee.setPpsNo("1234567AAA"));
        assertEquals(wrongPPSFormat, wrongFormat.getMessage());
        final String specialChars = "Employee PPS must not contain special characters or lowercase letters";
        wrongFormat = assertThrows(IllegalArgumentException.class,()->employee.setPpsNo("123456%AA"));
        assertEquals(specialChars, wrongFormat.getMessage());
    }

    @DisplayName("********Testing the get and set SetCommission Rate **********" )
    @Test
    void testGetSetCommissionRate() {
        employee = new CommissionBasedStaff();
        employee.setCommissionRate(0.15);
        assertEquals(0.15, employee.getCommissionRate());
        final String invalidCommissionRate = "Commission rate must be greater than 0 and less than MAXCOMMISSIONRATE";
        Exception commissionRateAbove = assertThrows(IllegalArgumentException.class, () -> employee.setCommissionRate(0.27));
        assertEquals(invalidCommissionRate, commissionRateAbove.getMessage());
        Exception commissionRateZero = assertThrows(IllegalArgumentException.class, () -> employee.setCommissionRate(0));
        assertEquals(invalidCommissionRate, commissionRateZero.getMessage());
    }

    @DisplayName("********Testing the get and set SetValueOfIndividualSales **********" )
    @Test
    void testGetSetValueOfIndividualSales() {
        employee = new CommissionBasedStaff();
        employee.setValueOfIndividualSales(54000);
        assertEquals(54000, employee.getValueOfIndividualSales());
        final String invalidValueOfSales = "Value of sales must be greater than 0";
        Exception ValueOfSalesBelowZero = assertThrows(IllegalArgumentException.class, () -> employee.setValueOfIndividualSales(0));
        assertEquals(invalidValueOfSales, ValueOfSalesBelowZero.getMessage());
    }

    @DisplayName("********Testing CalculatePayment ************")
    @Test
    void testCalculatePayment() {
        employee = new CommissionBasedStaff();
        employee.setValueOfIndividualSales(20000);
        employee.setCommissionRate(0.10);
        assertEquals(2000, employee.calculatePayment() );
    }
}