//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Book book = new Book("자바의 정석");

    Student student = new Student("김영희");
    Teacher teacher = new Teacher("김철수", "JAVA");

    teacher.teach();
    // 매개변수로 집어넣으면 user관계가 된다.
    student.study(book);

    }
}