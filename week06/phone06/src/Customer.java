import java.io.IOException;
import java.util.Scanner;

public class Customer extends Person {

    private String phoneNo;
    private int usageTime;
    private int message;
    private Plan plan;

    public Customer(String name, Date birthday, String phoneNo, Plan plan) {
        super(name, birthday);
        this.phoneNo = phoneNo;
        this.usageTime = 0;
        this.message = 0;
        this.plan = plan;

        // 80세 이상은 무조건 할인 요금제로 변경
        if (this.getBirthday().getAge() >= 80) {
            this.plan = new DiscountPlan();
        }
    }

    public int getMessage() {
        return message;
    }

    public int getUsageTime() {
        return usageTime;
    }

    protected void inputUsageTime() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 전용 통화 시간 입력 : ", super.getName());
            usageTime = keyboard.nextInt();
            if (usageTime >= 0) {
                break;
            } else {
                System.err.println("ERROR : 통화 시간 오류");
            }
        }
    }

    protected void inputMessage() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 문자 건수 입력 : ", super.getName());
            message = keyboard.nextInt();
            if (message >= 0) {
                break;
            } else {
                System.err.println("ERROR : 문자 건수 오류");
            }
        }
    }

    private int fee() {
        return plan.calculateFee(this);
    }

    private int tax() {
        return plan.tax(this); // 치명적인 오류 수정 (기존: calculateFee 호출)
    }

    private int charge() {
        return fee() + tax();
    }

    @Override
    public String toString() {
        return String.format("%s %13s %,6d 초 %,6d 건 %6s %,10d원 %,8d원 %,10d원",
                super.toString(), phoneNo, usageTime, message, plan.getName(), fee(), tax(), charge());
    }
}