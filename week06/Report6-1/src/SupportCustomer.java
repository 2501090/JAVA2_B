public class SupportCustomer extends Customer {
    public SupportCustomer(String id, String name, int usage) {
        super(id, name, usage);
    }

    @Override
    protected int getBilledUsage() {
        return Math.max(0, usage - 100); // 100Kw 무료 혜택 적용 [cite: 3, 6, 12]
    }

    @Override
    public String getRemark() {
        return "지원가구"; // 비고란 출력 [cite: 3, 13]
    }
}