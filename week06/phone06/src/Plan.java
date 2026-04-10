public abstract class Plan {
    private String name;
    final int NETWORK = 3200;
    final int BASIC = 1000;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract int calculateFee(Customer customer);
    protected abstract int tax(Customer customer);
}