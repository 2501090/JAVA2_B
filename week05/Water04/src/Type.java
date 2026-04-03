public class Type {

    private String typeName;
    protected int unitPrice;
    protected float taxRate;

    public Type(String typeName, int unitPrice, float taxRate) {
        this.typeName = typeName;
        this.unitPrice = unitPrice;
        this.taxRate = taxRate;
    }

    // 수정: 외부에서 typeName을 안전하게 읽어갈 수 있도록 Getter 추가
    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return String.format("%3s", typeName);
    }
}