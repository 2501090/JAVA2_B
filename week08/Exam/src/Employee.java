public abstract class Employee extends Person implements MyProject {
    protected String employeeID;
    protected Date birthday;

    public Employee(String employeeID, Date birthday, String name) {
        super(name);
        this.employeeID = employeeID;
        this.birthday = birthday;
    }

    public int calculateTax() {
        return getTaxAmount(calculateTotalPay()); // MyProject 인터페이스 호출
    }

    public int calculateActualPay() {
        return calculateTotalPay() - calculateTax();
    }

    public void inputData() {}

    public String getEmployeeID() { return employeeID; }
    public Date getBirthday() { return birthday; }
    public String getGradeStep() { return "0급-0호"; }
    public int getDays() { return 0; }
    public int getDailyWage() { return 0; }
    public int getIncentive() { return 0; }
    public int getCommission() { return 0; }
    public abstract String getJobType();
}