public class Person {

    protected String name; // 수정: private -> protected로 변경하여 자식 클래스에서 접근 가능하도록 함

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%3s", name);
    }
}