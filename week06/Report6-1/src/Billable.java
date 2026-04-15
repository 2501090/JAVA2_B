public interface Billable {
    void calculateBill(); // 요금 계산 규칙
    String getRemark();   // 비고 출력 규칙
}