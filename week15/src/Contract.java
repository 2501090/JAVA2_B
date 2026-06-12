public class Contract extends Employee {
    public Contract(String employeeID, String name, String hireDate) {
        super(employeeID, name, hireDate);
    }

    @Override
    public void calculatePay() {
        salary.baseSalary = 2000000; // 고정 기본급
        salary.calculateTaxAndNet();
    }

    @Override
    public int getSortGrade() { return 98; }

    @Override
    public String getPositionName() { return "계약직"; }
}