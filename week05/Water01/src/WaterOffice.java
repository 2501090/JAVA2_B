import java.io.IOException;

public class WaterOffice {
    private Customer[] customers;

    public WaterOffice(Customer[] customers) {
        this.customers = customers;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < customers.length; i++) {
            customers[i].inputUseAge();
        }
    }

    protected void display() {
        sortByCharge();
        line();
        System.out.println(" 수도번호 이름 구분 사용량 사용금액 세금 납부금액 비고");
        line();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
        } // 괄호 위치 수정: 반복문 안에서 합계가 출력되지 않도록 이동
        line();
        System.out.println(total());
        line();
    }

    private String total() {
        return String.format("%s\n%s\n%s\n%s", totalUseage(), totalFee(), totalTax(), totalCharge());
    }

    private String totalUseage() {
        float total = 0.0f;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i].usage;
        }
        return  String.format("사용량 합계 : %,.2f", total);
    }

    private String totalFee() {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i].fee(); // usage 가 아닌 fee() 호출
        }
        return  String.format("사용금액 합계 : %,d원", total);
    }

    private String totalTax() {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i].tax(); // 변수가 아닌 tax() 메서드 호출
        }
        return  String.format("세금 합계 : %,d원", total); // 텍스트 수정
    }

    // 누락되었던 납부금액 합계 메서드 추가
    private String totalCharge() {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i].charge();
        }
        return  String.format("납부금액 합계 : %,d원", total);
    }

    private void sortByCharge() {
        Customer temp;
        for (int i = 0; i < customers.length - 1; ++i) { // i{ 오타 수정
            for (int j = i + 1; j < customers.length; ++j) {
                if (customers[i].charge() < customers[j].charge()) { // chage 오타 수정
                    temp = customers[i];
                    customers[i] = customers[j]; // 자기 자신을 할당하는 스왑 논리 오류 수정
                    customers[j] = temp;
                }
            }
        }
    }

    private void line() {
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        } // 괄호 위치 수정
        System.out.println(); // 반복문 밖에서 줄바꿈 하도록 수정
    }
}