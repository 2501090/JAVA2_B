// Government.java
public class Government extends Customer {
    public Government(String name, String waterNo) { // 매개변수 받도록 수정
        super(name, waterNo);
        type = new Type("관공서", 36, 5.0f);
    }
}