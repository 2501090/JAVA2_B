public class Executive extends Regular {
    public Executive(String employeeID, String name, String hireDate, int grade, int performanceBonus, int stockOption) {
        super(employeeID, name, hireDate, grade);
        this.salary.performanceBonus = performanceBonus;
        this.salary.stockOption = stockOption;
    }

    @Override
    public void calculatePay() {
        salary.baseSalary = getBaseSalaryByGrade();
        salary.calculateTaxAndNet();
    }

    @Override
    public String getPositionName() {
        return (grade == 1) ? "상무" : "이사";
    }
}