public class Temporary extends Employee {
    private int dailyWage;
    private int workDays;

    public Temporary(String employeeID, String name, String hireDate, int dailyWage, int workDays) {
        super(employeeID, name, hireDate);
        this.dailyWage = dailyWage;
        this.workDays = workDays;
    }

    @Override
    public void calculatePay() {
        salary.baseSalary = dailyWage * workDays;
        salary.calculateTaxAndNet();
    }

    @Override
    public int getSortGrade() { return 99; }

    @Override
    public String getPositionName() { return "일용직"; }
    
    public int getDailyWage() { return dailyWage; }
    public int getWorkDays() { return workDays; }
}