import java.util.Scanner;

public class Temporary extends Employee {
    private int workDay;
    private int dailyPay;

    public Temporary(String name, Date birthday, String employeeId) {
        super(name, birthday, employeeId);
        this.dailyPay = 0;
        this.workDay = 0;
    }

    @Override
    public int basicSalary() {
        return workDay * dailyPay;
    }

    @Override
    public int bonus() {
        return 0;
    }

    public String toString() {
        return String.format("%s %c급-%c호 %2d %,6d원 %,9d원 %,9d원 %,9d원 %,7d원 %,9d원 %,9d원 %s",
                super.toString(), 'X', 'X', workDay, dailyPay, basicSalary(), bonus(), salary(), tax(), gross(), 0, "일당제");
    }

    @Override
    protected void inputData() {
        workDay = inputWorkDay();
        dailyPay = inputDailyPay();
    }

    private int inputWorkDay() {
        int workDay;
        while (true) {
            System.out.printf("%s님의 근무일수 입력 : ", this.getName());
            Scanner keyboard = new Scanner(System.in);
            workDay = keyboard.nextInt();
            if (workDay >= 0 && workDay <= 31) {
                break;
            }
            System.out.println("근무일수는 0에서 31 사이여야 합니다. 다시 입력해주세요.");
        }
        return workDay;
    }

    private int inputDailyPay() {
        int dailyPay;
        while (true) {
            System.out.printf("%s님의 일당 입력 : ", this.getName());
            Scanner keyboard = new Scanner(System.in);
            dailyPay = keyboard.nextInt();
            if (dailyPay >= 25000 && dailyPay <= 95000) {
                break;
            }
        }
        return dailyPay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public void setDailyPay(int dailyPay) {
        this.dailyPay = dailyPay;
    }
}