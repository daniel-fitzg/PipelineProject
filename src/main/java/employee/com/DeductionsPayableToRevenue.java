package employee.com;

interface DeductionsPayableToRevenue {
     final static double TAX_CREDIT_PER_MONTH = 10500/12;
     final static double LOW_RATE_TAX_CUT_OFF_PER_MONTH = 32800/12;
     final static double LOW_RATE_OF_TAX = 0.2;
     final static double HIGH_RATE_OF_TAX = 0.42;
     final static double PRSI_DEDUCTION = 0.075;
     final static double USC_DEDUCTION = 0.025;

    public double deductionsPayableToRevenue(double grossPayment);
}
