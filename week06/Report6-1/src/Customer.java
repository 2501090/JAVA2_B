public abstract class Customer implements Billable, Comparable<Customer> {
    protected String id;
    protected String name;
    protected int usage;
    protected int baseRate = 1660; // 기본 요금 [cite: 3, 10]
    protected int usageRate;
    protected int tax;
    protected int totalBill;

    public Customer(String id, String name, int usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    @Override
    public void calculateBill() {
        double charge = 0;
        int k = getBilledUsage(); // 하위 클래스에서 구현한 사용량을 가져옴

        // 누진세 적용 로직 [cite: 4, 12]
        if (k > 500) { charge += (k - 500) * 643.9; k = 500; }
        if (k > 400) { charge += (k - 400) * 466.4; k = 400; }
        if (k > 300) { charge += (k - 300) * 353.6; k = 300; }
        if (k > 200) { charge += (k - 200) * 278.3; k = 200; }
        if (k > 100) { charge += (k - 100) * 223.8; k = 100; }
        if (k > 0)   { charge += k * 184.1; }

        usageRate = baseRate + (int)charge;
        tax = (int)(usageRate * 0.07); // 세금 7%
        totalBill = usageRate + tax;
    }

    // 일반/지원 가구가 서로 다르게 구현할 부분 (추상 메서드)
    protected abstract int getBilledUsage();

    @Override
    public int compareTo(Customer o) {
        return o.totalBill - this.totalBill; // 납부금액 많은 순 정렬 [cite: 3, 9]
    }
}