class Customer implements Comparable<Customer> {
    protected String id;
    protected String name;
    protected int usage;
    protected int baseRate = 1660;
    protected int usageRate;
    protected int tax;
    protected int totalBill;

    public Customer(String id, String name, int usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    public void calculateBill() {
        double charge = 0;
        int k = getBilledUsage();

        if (k > 500) { charge += (k - 500) * 643.9; k = 500; }
        if (k > 400) { charge += (k - 400) * 466.4; k = 400; }
        if (k > 300) { charge += (k - 300) * 353.6; k = 300; }
        if (k > 200) { charge += (k - 200) * 278.3; k = 200; }
        if (k > 100) { charge += (k - 100) * 223.8; k = 100; }
        if (k > 0)   { charge += k * 184.1; }

        usageRate = baseRate + (int)charge;
        tax = (int)(usageRate * 0.07);
        totalBill = usageRate + tax;
    }

    protected int getBilledUsage() {
        return usage;
    }

    public String getRemark() {
        return "";
    }

    @Override
    public int compareTo(Customer o) {
        return o.totalBill - this.totalBill;
    }
}