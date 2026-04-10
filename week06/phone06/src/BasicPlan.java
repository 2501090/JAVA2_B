public class BasicPlan extends Plan {

    public BasicPlan() {
        super("기본 요금제");
    }

    @Override
    protected int calculateFee(Customer customer) {
        // 통화료: 2초당 10원 (홀수 초는 올림 처리)
        int callFee = ((customer.getUsageTime() / 2) + (customer.getUsageTime() % 2 != 0 ? 1 : 0)) * 10;
        // 문자료: 20건 초과분부터 건당 2원 (마이너스 방지)
        int msgFee = Math.max(0, customer.getMessage() - 20) * 2;
        return NETWORK + callFee + msgFee; // 곱하기(*)가 아닌 더하기(+)
    }

    @Override
    protected int tax(Customer customer) {
        int tax = 0;
        if (customer.getBirthday().getAge() > 19) {
            int total = calculateFee(customer); // 이미 NETWORK가 포함되어 있으므로 바로 사용
            tax = (int) (total * 0.065); // 6.5% 세금
        }
        return tax;
    }
}