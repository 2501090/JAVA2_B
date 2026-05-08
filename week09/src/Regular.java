abstract class Regular extends Employee {
    private int grade;
    private int step;

    public Regular(String name, Date birthday, String employeeId, int step, int grade) {
        super(name, birthday, employeeId);
        this.step = step;
        this.grade = grade;
    }

    @Override
    public int basicSalary() {
        return salary[grade][step];
    }

    @Override
    public int bonus() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d급-%d호 %2d %,6d원 %,9d원 %,9d원 %,9d원",
                super.toString(), grade, step, 0, basicSalary(), 0, tax(), gross());
    }
}
