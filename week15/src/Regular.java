public abstract class Regular extends Employee {
    protected int grade;

    public Regular(String employeeID, String name, String hireDate, int grade) {
        super(employeeID, name, hireDate);
        this.grade = grade;
    }

    protected int getBaseSalaryByGrade() {
        switch (grade) {
            case 1: return 6000000; // 상무
            case 2: return 5000000; // 이사
            case 3: return 4589000; // 부장
            case 4: return 3689000; // 차장
            case 5: return 3235000; // 과장
            case 6: return 2589000; // 대리
            case 7: return 2123000; // 사원
            default: return 0;
        }
    }

    @Override
    public int getSortGrade() { return this.grade; }
}