package employee.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class CommissionBasedStaffTest {


    CommissionBasedStaff employee;

    @DisplayName("********Testing the CommissionBasedEmployee get and set setEmployeeID**********")
    @Test
    void testCommissionBasedEmployeeSetEmployeeId(){
        employee = new CommissionBasedStaff();
        employee.setEmployeeId(1245);
        assertEquals(1245, employee.getEmployeeId());
        final String cannotBeZero = "Employee Id cannot be 0";
        Exception zero = assertThrows(IllegalArgumentException.class,()->employee.setEmployeeId(0));
        assertEquals(cannotBeZero, zero.getMessage());
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

    @DisplayName("********Testing the get and set SetCommission Rate **********" )
    @Test
    void testGetSetCommissionRate() {
        employee = new CommissionBasedStaff();
        employee.setCommissionRate(0.15);
        assertEquals(0.15, employee.getCommissionRate());
        final String invalidCommissionRate = "Commission rate must be greater than 0 and less than 20%";
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