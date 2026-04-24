import java.util.Scanner;

public class Salesman extends Regular {
    private int sale;
    private double commissionRate;

    public Salesman(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("[영업직] %s님의 판매 금액 입력 : ", getName());
        this.sale = scanner.nextInt();
        System.out.printf("[영업직] %s님의 커미션 비율 입력 : ", getName());
        double rate = scanner.nextDouble();
        this.commissionRate = (rate > 5.0) ? 5.0 : rate;
    }

    @Override
    public int calculateTotalPay() {
        int commission = (int)(sale * (commissionRate / 100.0));
        return super.calculateBasePay() + commission;
    }

    @Override public int getCommission() { return calculateTotalPay() - super.calculateBasePay(); }
    @Override public String getJobType() { return "영업직"; }
    public int getSale() { return sale; }
    public double getCommissionRate() { return commissionRate; }
}