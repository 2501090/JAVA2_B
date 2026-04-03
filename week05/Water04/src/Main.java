// Main.java
public class Main {
    public static void main(String[] args) {

        Customer[] customers = new Customer[] {
                new Home("홍길동", "1001"),
                new Business("이몽룡", "1002"),
                new Factory("성춘향", "1003"),
                new Government("임꺽정", "1004"),
                new Army("김유신", "1005"),
                new School("경복대", "2345")
        };

        // WaterOffice 객체 생성 후 실행 로직 추가
        WaterOffice office = new WaterOffice(customers);
        office.inputData();    // 사용량 입력받기
        office.printReceipt(); // 결과 출력하기
    }
}