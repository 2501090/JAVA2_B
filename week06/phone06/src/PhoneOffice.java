import java.io.IOException;

public class PhoneOffice {
    private Customer[] customers;

    public PhoneOffice(Customer[] customers) {
        this.customers = customers;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < customers.length; i++) {
            customers[i].inputUsageTime();
            customers[i].inputMessage();
        }
    }

    protected void display() {
        line();
        // 타일이라는 글자 대신 실제 예시의 헤더로 교체
        System.out.println("           이름(생일)      나이      전화번호      통화시간   문자건수    요금제       사용요금    세금      납부금액");
        line();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        line();
    }

    private void line() {
        for (int i = 0; i < 100; i++) { // i < 100 으로 오타 수정
            System.out.print("*");
        }
        System.out.println();
    }
}