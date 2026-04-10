public class DiscountPlan extends Plan {

    public DiscountPlan() {
        super("할인 요금제");
    }

    @Override
    protected int calculateFee(Customer customer) {
        // 통화료: 2초당 5원
        int callFee = ((customer.getUsageTime() / 2) + (customer.getUsageTime() % 2 != 0 ? 1 : 0)) * 5;
        int msgFee = 0;

        // 80세 미만은 40건 초과분 건당 2원, 80세 이상은 전면 무료
        if (customer.getBirthday().getAge() < 80) {
            msgFee = Math.max(0, customer.getMessage() - 40) * 2;
        }

        return NETWORK + BASIC + callFee + msgFee;
    }

    @Override
    protected int tax(Customer customer) {
        int tax = 0;
        if (customer.getBirthday().getAge() > 19) {
            int total = calculateFee(customer);
            tax = (int) (total * 0.065);
        }
        return tax;
    }
}