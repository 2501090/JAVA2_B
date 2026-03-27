public class Main {
    public static void main(String[] args) {
        Teacher t = new Teacher("영희", 24);
        Doctor d = new Doctor("철수", 45);
        Engineer e = new Engineer("민수", 35);

        t.introduce(); t.work();
        d.introduce(); d.work();
        e.introduce(); e.work();
    }
}