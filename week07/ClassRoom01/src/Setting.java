import java.io.IOException;
import java.util.Scanner;

public class Setting implements MyProject{

    protected int selectType() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int type = 0;
        while (true) {
            System.out.print("Type 입력 \n" + "1 = 고등학교, 2 = 대학교");
            type = keyboard.nextInt();
            if (isValid2(type)) {
                break;
            } else {
                error("Type 오류 (1 또는 2");
            }
        } return type;
    }

    // 응집도 낮추기
    protected Student[] prepare(int type, Person[] persons) {
        Student[] students = new Student[persons.length];
        if (type == 1) {
            for (int i=0; i<persons.length; i++) {
                students[i] = new Highschool(persons[i].getStudentID(), persons[i].getName());
            } else {
                students[i] = new Highschool(persons[i].getStudentID(), persons[i].getName());
            }
        }
    }
}
