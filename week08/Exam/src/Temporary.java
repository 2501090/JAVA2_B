import java.util.Scanner;

public class Temporary extends Employee {
    private int dailyWage;
    private int days;

    public Temporary(String employeeID, Date birthday, String name) {
        super(employeeID, birthday, name);
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("[일용직] %s님의 일당 입력 : ", getName());
            int wage = scanner.nextInt();
            if (wage >= 25000 && wage <= 95000) {
                this.dailyWage = wage;
                break;
            } else {
                System.err.println("ERROR : 일당 범위 오류 (25,000 ~ 95,000원)");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
            }
        }
        System.out.printf("[일용직] %s님의 작업 일수 입력 : ", getName());
        this.days = scanner.nextInt();
    }

    @Override public int calculateBasePay() { return dailyWage * days; }
    @Override public int calculateTotalPay() { return calculateBasePay(); }
    @Override public int calculateTax() { return (int)(calculateTotalPay() * 0.066); }
    @Override public int getDays() { return days; }
    @Override public int getDailyWage() { return dailyWage; }
    @Override public String getJobType() { return "일당제"; }
}