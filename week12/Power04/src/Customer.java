// 자식 방지용으로 abstract class로 선언
abstract public class Customer extends Person implements Constants {
    private String customID;
    private int powerUsage;

    //객체 초기화 = 생성자 , setter 두가지 방법
    public Customer(String name, String customID, int powerUsage) {
        super(name);
        this.customID = customID;
        this.powerUsage = powerUsage;
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    //사용요금
    protected int fee() {
        int temp = powerUsage;
        float fee = basic;
        for (int i = 0; i < table.length; i++) {
            int usage = Math.min(temp, limits[i]);
            fee += usage * table[i];
            temp -= usage;
            if (temp <= 0)
                break;
        }
        return (int) fee;
    }

    //세금
    private int tax() {
        return (int) (fee() * rate);
    }

    protected int charge() {
        return fee() + tax();
    }

    @Override
    public String toString() {
        return String.format("%5s %s %,5d kw %,9d원 %,7d원 %,9d원",
                customID, getName(), powerUsage, fee(), tax(), charge());
    }
}
