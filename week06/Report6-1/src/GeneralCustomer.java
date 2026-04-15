public class GeneralCustomer extends Customer {
    public GeneralCustomer(String id, String name, int usage) {
        super(id, name, usage);
    }

    @Override
    protected int getBilledUsage() {
        return usage; // 일반 가구는 전체 사용량 청구 [cite: 5]
    }

    @Override
    public String getRemark() {
        return "";
    }
}