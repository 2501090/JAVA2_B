public class Staff extends Regular {
    private int step;

    public Staff(String employeeID, String name, String hireDate, int grade, int step) {
        super(employeeID, name, hireDate, grade);
        this.step = step;
    }

    @Override
    public void calculatePay() {
        salary.baseSalary = getBaseSalaryByGrade();
        salary.stepAllowance = step * 100000;
        salary.calculateTaxAndNet();
    }

    @Override
    public String getPositionName() {
        if (grade == 5) return "과장";
        if (grade == 6) return "대리";
        return "사원";
    }

    public int getStep() { return step; }
}