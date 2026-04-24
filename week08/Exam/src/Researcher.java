public class Researcher extends Regular {
    private static final int RESEARCH_ALLOWANCE = 300000;

    public Researcher(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override
    public int calculateTotalPay() {
        return calculateBasePay() + RESEARCH_ALLOWANCE;
    }

    @Override
    public int calculateTax() {
        return getTaxAmount(calculateBasePay());
    }

    @Override public int getIncentive() { return RESEARCH_ALLOWANCE; }
    @Override public String getJobType() { return "연구직"; }
}