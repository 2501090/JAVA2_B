public abstract class Regular extends Employee {
    protected int grade;
    protected int step;

    public Regular(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name);
        this.grade = grade;
        this.step = step;
    }

    @Override
    public int calculateBasePay() {
        return PAY_TABLE[step - 1][grade - 1];
    }

    @Override
    public String getGradeStep() {
        return grade + "급-" + step + "호";
    }
}