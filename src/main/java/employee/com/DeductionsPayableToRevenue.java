package employee.com;

/*
 * Contributors:
 * Renan Moraes: g00353112@gmit.ie
 * John Lawless: g00351835@gmit.ie
 * Daniel Fitzgerald: g00216219@gmit.ie
 *
 * April/May 2020
 * */

interface DeductionsPayableToRevenue {
     double TAX_CREDIT_PER_MONTH = 10500/12;
     double LOW_RATE_TAX_CUT_OFF_PER_MONTH = 32800/12;
     double LOW_RATE_OF_TAX = 0.2;
     double HIGH_RATE_OF_TAX = 0.42;
     double PRSI_DEDUCTION = 0.075;
     double USC_DEDUCTION = 0.025;

     double deductionsPayableToRevenue(double grossPayment);
}
