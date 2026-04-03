public class WaterOffice {
    private Customer[] customers;

    // Main에서 넘겨준 customers 배열을 받아서 초기화
    public WaterOffice(Customer[] customers) {
        this.customers = customers;
    }

    // 각 고객별로 수도 사용량을 입력받는 로직
    public void inputData() {
        for (Customer c : customers) {
            try {
                c.inputUseAge();
            } catch (Exception e) {
                System.err.println("입력 중 오류가 발생했습니다.");
            }
        }
    }

    // 전체 요금 청구서 출력 로직 (테스트 확인용)
    public void printReceipt() {
        System.out.println("\n=======================================================================");
        System.out.println("고객번호   이름    용도     사용량     기본요금     세금     청구금액  비고");
        System.out.println("=======================================================================");
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
        System.out.println("=======================================================================");
    }
}