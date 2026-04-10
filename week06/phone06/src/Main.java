import java.io.IOException; // 맨 위에 이 줄을 반드시 추가해야 합니다.

public class Main {
    public static void main(String[] args) throws IOException {

        Customer[] customers = new Customer[] {
                new Customer("홍길동", new Date(2007, 7, 12), "010-2345-5678",
                        new DiscountPlan()),
                new Customer("박길동", new Date(2007, 7, 12), "010-3345-5678",
                        new DiscountPlan()),
                new Customer("정길동", new Date(1930, 7, 12), "010-4345-5678",
                        new DiscountPlan())
        };

        PhoneOffice office = new PhoneOffice(customers);
        office.inputData();
        office.display();

    }
}