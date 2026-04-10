public abstract class Plan implements MyProject{
    private String name;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int calculateFee(Customer customer);
    public abstract int tax(Customer customer);
}