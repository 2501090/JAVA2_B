public class Main {
    public static void main(String[] args) {

        // 1. Type 배열을 먼저 올바르게 생성합니다. (총 6개 용도)
        Type[] types = new Type[] {
                new Home(),       // types[0]
                new Business(),   // types[1]
                new Factory(),    // types[2]
                new Government(), // types[3]
                new Army(),       // types[4]
                new School()      // types[5]
        };

        // 2. 인덱스는 0부터 시작하도록 맞추어 Customer 배열을 구성합니다.
        Customer[] customers = new Customer[] {
                new Customer("홍길동", "1001", types[0]),
                new Customer("이몽룡", "1002", types[1]),
                new Customer("성춘향", "1003", types[2]),
                new Customer("임꺽정", "1004", types[3]),
                new Customer("김유신", "1005", types[4]),
                new Customer("신사임당", "1006", types[5])
        };

        // 3. WaterOffice 객체를 생성하고 로직을 실행합니다.
        WaterOffice office = new WaterOffice(customers);

        // 데이터 입력받기
        office.inputData();

        // 결과 출력하기 (새로 추가한 출력 메서드)
        office.printReceipt();
    }
}