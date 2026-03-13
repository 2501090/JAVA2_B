public class Person {
    private String name;
    private int age;
    private boolean gender;
    private boolean isMarried; // 스펠링 Married로 통일 권장
    private int children;

    // 1. 기본 생성자 추가 (new Person() 가능하게 함)
    public Person() {
    }

    // 2. 매개변수 생성자
    public Person(String name, int age, boolean gender, boolean isMarried, int children) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isMarried = isMarried;
        this.children = children;
    }

    // Getter / Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isGender() { return gender; }
    public void setGender(boolean gender) { this.gender = gender; }

    public boolean isMarried() { return isMarried; }
    public void setMaried(boolean married) { isMarried = married; } // Main에서 setMaried로 호출하므로 유지하거나 수정

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }

    // 3. toString 수정
    @Override
    public String toString() {
        // gender가 true면 '남', false면 '여'로 치환하는 로직 필요
        char genderChar = gender ? '남' : '여';
        String marriedStatus = isMarried ? "했" : "안 했";

        return String.format("나이는 %d살, 이름은 %s이라는 %c자가 있습니다.\n" +
                        "이 %c자는 결혼을 %s고 자식이 %d명 있습니다.",
                age, name, genderChar, genderChar, marriedStatus, children);
    }
}