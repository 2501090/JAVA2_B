import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student st = new Student();

        System.out.print("이름을 입력하세요: ");
        st.name = scanner.next();

        System.out.print("학번을 입력하세요: ");
        st.rollno = scanner.nextInt();

        System.out.print("학과를 입력하세요: ");
        st.depart = scanner.next();

        System.out.print("태어난 연도를 입력하세요: ");
        st.birthday = scanner.nextInt();

        st.printInfo();

        scanner.close();
    }
}