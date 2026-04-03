// Factory.java
public class Factory extends Customer {
    public Factory(String name, String waterNo) { // 매개변수 받도록 수정
        super(name, waterNo);
        type = new Type("공장용", 76, 2.5f); // 불필요한 이중 괄호 수정
    }
}