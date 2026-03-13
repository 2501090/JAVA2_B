public class Main {
    public static void main(String[] args) {
        // 기본 생성자 호출 (Person 클래스에 기본 생성자가 있어야 함)
        Person person = new Person();

        person.setName("홍길동");
        person.setAge(30);
        person.setGender(true);
        person.setMaried(true); // Person 클래스의 setter 이름과 일치해야 함
        person.setChildren(5);

        System.out.println(person);
        System.out.println();

        // 매개변수 생성자 호출
        Person hong = new Person("홍길동", 30, true, true, 5);
        System.out.println(hong);
    }
}