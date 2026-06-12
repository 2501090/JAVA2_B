public class Manager extends Regular {
    private int step;

    public Manager(String employeeID, String name, String hireDate, int grade, int step) {
        super(employeeID, name, hireDate, grade);
        this.step = step;
    }

    @Override
    public void calculatePay() {
        salary.baseSalary = getBaseSalaryByGrade();
        salary.stepAllowance = step * 150000; // 호봉당 15만원
        salary.managementBonus = (int) ((salary.baseSalary * 0.1) / 1000) * 1000;
        salary.calculateTaxAndNet();
    }

    @Override
    public String getPositionName() {
        return (grade == 3) ? "부장" : "차장";
    }

    public int getStep() { return step; }
}