public class Staff extends Regular {
    public Staff(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override
    public int calculateTotalPay() {
        return calculateBasePay();
    }

    @Override
    public String getJobType() {
        return "정규직";
    }
}