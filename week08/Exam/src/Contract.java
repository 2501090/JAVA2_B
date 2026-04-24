public class Contract extends Employee {
    private final int FIXED_PAY = 2000000;

    public Contract(String employeeID, Date birthday, String name) {
        super(employeeID, birthday, name);
    }

    @Override
    public int calculateBasePay() {
        return FIXED_PAY;
    }

    @Override
    public int calculateTotalPay() {
        return calculateBasePay();
    }

    @Override public String getJobType() { return "계약직"; }
}