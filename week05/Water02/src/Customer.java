import java.io.IOException;
import java.util.Scanner;

public class Customer extends Person{
    private String waterNo;
    private Type type;
    protected float usage;
    private final int BASIC;

    public Customer(String name, String waterNo, Type type) {
        super(name);
        this.waterNo = waterNo;
        this.type = type;
        this.usage = 0.0f;
        this.BASIC = 1200;
    }

    protected void inputUseAge() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            // 수정: type.typeName() -> type.getTypeName() 으로 Getter 사용
            System.out.printf("[%s] %s 님 수도 사용량 입력 : ", type.getTypeName(), super.name);
            usage = keyboard.nextFloat();
            if(usage >= 0.0f && usage <= 999.9f) {
                break;
            } else {
                System.err.print("ERROR : 사용량 오류\n");
                System.in.read();
            }
        }
    }

    @Override
    public String toString() {
        // 수정: type.typeName() -> type.getTypeName()
        // 수정: type.typeName.equals -> type.getTypeName().equals
        return String.format("%4s %s %3s %6.2f\u33A5 %,8d원 %,6d원 %,8d원 %s"
                ,waterNo, super.toString(), type.getTypeName(), usage, fee(), tax(), charge(), type.getTypeName().equals("군기관")
                        ?"일괄 징수" : "");
    }

    protected int charge() {
        return BASIC + fee() + tax();
    }

    protected int tax() {
        // 수정: switch(type)으로 객체를 분기하는 문법 오류 제거
        // Type 클래스에 이미 taxRate 정보가 있으므로 이를 가져와서 바로 계산하면 됩니다.
        int temp = BASIC + fee();
        int result = (int)(temp * (type.taxRate / 100.0f));
        return result / 10 * 10;
    }

    protected int fee() {
        // 수정: fee() 안에서 fee()를 또 호출하던 무한 루프 제거
        // 주석 처리되어 있던 올바른 로직(단가 * 사용량)으로 복원
        int result = (int)(usage + 0.5f) * type.unitPrice;
        return result / 10 * 10;
    }
}