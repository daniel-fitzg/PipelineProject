package employee.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import java.text.ParseException;

class CommissionBasedStaffTest {



    @DisplayName("********Testing the CommissionBasedEmployee valid EmployeeID**********")
    @Test
    void testCommissionBasedStaffValidEmployeeId() {

        assertEquals("1234", EmployeeFactory.getValidCommissionBasedStaff().getEmployeeId());
    }

    @DisplayName("********Testing the CommissionBasedEmployee EmployeeID Zero**********")
    @Test
    void testCommissionBasedStaffEmployeeIdZero() {
        final String cannotBeZero = "Employee Id must have a minimum of two digits ";
        Exception zero = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setEmployeeId("0"));
        assertEquals(cannotBeZero, zero.getMessage());
    }

    @DisplayName("********Testing the CommissionBasedEmployee EmployeeID Not A Number**********")
    @Test
    void testCommissionBasedStaffEmployeeIdNotANumber() {
        final String mustBeNum = "EmployeeID is not a valid number";
        Exception notANum = assertThrows(NumberFormatException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setEmployeeId("AAA"));
        assertEquals(mustBeNum, notANum.getMessage());
    }

    @DisplayName("********Testing valid Employee name**********")
    @Test
    void testValidEmployeeName() {
        assertEquals("John Lawless", EmployeeFactory.getValidCommissionBasedStaff().getName());
    }

    @DisplayName("********Testing invalid Employee name**********")
    @Test
    void testInValidEmployeeName() {
        final String invalidName = "Employee name must be a minimum of four letters";
        Exception name = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setName("aa"));
        assertEquals(invalidName, name.getMessage());
    }

    @DisplayName("********Testing Employee valid address**********")
    @Test
    void testValidEmployeeAddress() {
        assertEquals("Main Street, Galway", EmployeeFactory.getValidCommissionBasedStaff().getAddress());
    }

    @DisplayName("********Testing Employee Invalid address**********")
    @Test
    void testInvalidEmployeeAddress() {
        final String invalidAddress = "Employee address cannot be empty";
        Exception address = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setAddress(""));
        assertEquals(invalidAddress, address.getMessage());
    }

    @DisplayName("********Testing Valid date of Birth")
    @Test
    void testValidDOBOfEmployee() throws ParseException {
        assertEquals("30/07/1996", EmployeeFactory.getValidCommissionBasedStaff().getDOB());
    }

    @DisplayName("********Testing invalid date of Birth")
    @Test
    void testInvalidDOBOfEmployee() throws ParseException {
        final String invalidDOB = "Employee date of birth is invalid";
        Exception age = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setDOB("30/07/2021"));
        assertEquals(invalidDOB, age.getMessage());
    }

    @DisplayName("********Testing Underage")
    @Test
    void testUnderAge() throws ParseException {
        final String toYoung= "Employee is under the MIN_AGE requirements";
        Exception underAge = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setDOB("30/07/2010"));
        assertEquals(toYoung, underAge.getMessage());
    }

    @DisplayName("********Testing valid PPS Number")
    @Test
    void testValidPPSNo() {
        assertEquals("1234567G", EmployeeFactory.getValidCommissionBasedStaff().getPpsNo());
    }

    @DisplayName("********Testing PPS Number length too short")
    @Test
    void testPPSNoLengthTooShort() {
        final String invalidPPSNo = "Employee PPS must fulfill the length requirements";
        Exception shortPPSNo = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setPpsNo("1234AA"));
        assertEquals(invalidPPSNo, shortPPSNo.getMessage());
    }


    @DisplayName("********Testing PPS Number format")
    @Test
    void testPPSNoLetters() {
        final String wrongPPSFormat = "Employee PPS must contain numbers and 1-2 letters";
        Exception wrongFormat = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setPpsNo("123456789"));
        assertEquals(wrongPPSFormat, wrongFormat.getMessage());

        wrongFormat = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setPpsNo("1234567AAA"));
        assertEquals(wrongPPSFormat, wrongFormat.getMessage());
    }

    @DisplayName("********Testing PPS Number no special characters or lowercase letters")
    @Test
    void testPPSNoSpecialChars() {
        final String specialChars = "Employee PPS must not contain special characters or lowercase letters";
        Exception wrongFormat = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.getValidCommissionBasedStaff().setPpsNo("123456%AA"));
        assertEquals(specialChars, wrongFormat.getMessage());
    }

    @DisplayName("********Testing Valid Commission Rate **********" )
    @Test
    void testValidCommissionRate() {
        assertEquals(0.1, EmployeeFactory.getValidCommissionBasedStaff().getCommissionRate());
    }

    @DisplayName("********Testing Invalid Commission Rate **********" )
    @Test
    void testInvalidCommissionRate() {
        final String invalidCommissionRate = "Commission rate must be greater than 0 and less than 20%";
        Exception commissionRateAbove = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setCommissionRate(0.27));
        assertEquals(invalidCommissionRate, commissionRateAbove.getMessage());

        Exception commissionRateZero = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setCommissionRate(0));
        assertEquals(invalidCommissionRate, commissionRateZero.getMessage());
    }

    @DisplayName("********Testing valid sales figure **********" )
    @Test
    void testValidSales() {
        assertEquals(20000, EmployeeFactory.getValidCommissionBasedStaff().getValueOfIndividualSales());
    }

    @DisplayName("********Testing sales cannot be zero **********" )
    @Test
    void testInvalidSales() {
        final String invalidValueOfSales = "Value of sales must be greater than 0";
        Exception ValueOfSalesBelowZero = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.getValidCommissionBasedStaff().setValueOfIndividualSales(0));
        assertEquals(invalidValueOfSales, ValueOfSalesBelowZero.getMessage());
    }

    @DisplayName("********Testing CalculatePayment ************")
    @Test
    void testCalculatePayment() {
        assertEquals(2000, EmployeeFactory.getValidCommissionBasedStaff().calculatePayment() );
    }
}