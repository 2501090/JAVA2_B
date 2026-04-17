import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Person[] person = new Person[] {
                    new Person("0501003", "홍길동"),
                    new Person("0501007", "최순실"),
                    new Person("0501013", "손홍민"),
                    new Person("0501024", "류현진"),
                    new Person("0501026", "이순신"),
                    new Person("0501058", "나희영"),
                    new Person("0501077", "이대한"),
                    new Person("0501085", "이희망"),
                    new Person("0501096", "박예림"),
                    new Person("0501110", "임계치")};

        Setting setting = new Setting();
        int type = setting.selectType();
        Student[] students = setting.prepare(type, persons);

        ClassRoom classRoom = new ClassRoom(students);
        classRoom.inputData();
        classRoom.display(type);
    }


}