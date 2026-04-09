class SupportCustomer extends Customer {
    public SupportCustomer(String id, String name, int usage) {
        super(id, name, usage);
    }

    @Override
    protected int getBilledUsage() {
        return Math.max(0, usage - 100);
    }

    @Override
    public String getRemark() {
        return "지원가구";
    }
}