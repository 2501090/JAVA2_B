// 올바른 Customer.java 예시
public abstract class Customer implements Constants {
    private String name;
    private String customID;
    private int powerUsage;

    public Customer(String name, String customID, int powerUsage) {
        this.name = name;
        this.customID = customID;
        this.powerUsage = powerUsage;
    }

    public String getName() { return name; }
    public String getCustomID() { return customID; }
    public int getPowerUsage() { return powerUsage; }

    // 기본 요금 계산 (Normal에서 오버라이드 하거나 공통으로 사용)
    protected int fee() {
        int temp = powerUsage;
        float fee = basic;
        for (int i = 0; i < table.length; i++) {
            int usage = Math.min(temp, limits[i]);
            fee += usage * table[i];
            temp -= usage;
            if (temp <= 0) break;
        }
        return (int) fee;
    }

    // 세금 등을 포함한 최종 금액 계산 (PowerOffice에서 사용)
    public int charge() {
        return (int) (fee() * (1 + rate));
    }

    @Override
    public String toString() {
        int f = fee();
        int tax = (int)(f * rate);
        return String.format("%s  %s  %d  %d  %d  %d",
                customID, name, powerUsage, f, tax, charge());
    }
}