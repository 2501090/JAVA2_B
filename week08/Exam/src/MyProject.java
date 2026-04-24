public interface MyProject {
    int[][] PAY_TABLE = {
            {2600000, 2800000, 3100000, 3400000, 3800000},
            {2650000, 2860000, 3170000, 3480000, 3890000},
            {2700000, 2920000, 3240000, 3560000, 3980000},
            {2750000, 2980000, 3310000, 3640000, 4070000},
            {2800000, 3040000, 3380000, 3720000, 4160000}
    };

    int calculateBasePay();
    int calculateTotalPay();

    default int getTaxAmount(int targetPay) {
        if (targetPay <= 2000000) return (int)(targetPay * 0.066);
        else if (targetPay <= 4000000) return (int)(targetPay * 0.073);
        else return (int)(targetPay * 0.085);
    }
}