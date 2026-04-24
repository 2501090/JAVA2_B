public class Manager extends Regular {

    public Manager(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override public int getIncentive() { return calculateTotalPay() - super.calculateBasePay(); }
    @Override public String getJobType() { return "점장직"; }

    @Override
    public int calculateTotalPay() {
        int basePay = super.calculateBasePay();
        double allowanceRate = 0.0;

        if (basePay <= 1800000) {
            allowanceRate = 0.06;
        } else if (basePay <= 2400000) {
            allowanceRate = 0.05;
        } else {
            allowanceRate = 0.04;
        }

        return basePay + (int)(basePay * allowanceRate);
    }
}