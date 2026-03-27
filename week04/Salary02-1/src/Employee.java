import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Employee {

    private String[] person; // person[0] = name, person[1] = employeeID
    private Date birthday;
    private Department department;
    private Grade grade;
    private int extraPay;

    public Employee(String[] person, Date birthday, Department department, Grade grade, int extraPay) {
        this.person = person;
        this.birthday = birthday;
        this.department = department;
        this.grade = grade;
    }

    public void inputExtraPay() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 수당 입력 : ", person[0]);
            extraPay = keyboard.nextInt();
            if (extraPay >= 0 && extraPay <= 1000000) {
                break;
            } else {
                System.err.print("ERROR : 수당 오류");
                System.in.read();
            }
        }
    }

    //내부 method
    private int tax() {
        int tax = 0;
        if (grade.getSelary() >= 1700000) {
            tax = (int) (gross() * (5.0f / 100));
        } else if (gross() < 2300000) {
            tax = (int) (gross() * (10.0f / 100));
        } else {
            tax = gross();
        } tax = tax / 10 * 10;
        return tax;
    }

    protected int net() {
        return gross() - tax();
    }

    private int gross() {
        return grade.getSelary() + extraPay;
    }

    @Override
    public String toString() {
        return String.format("%3s%s %4s %3s %2c %,10d원 %,10d원 %,10d원 %,8d원 %,10d원"
                , person[0], birthday, person[1], department.getDepartName()
                , grade.getGrade(), grade.getSelary(), extraPay, gross(), tax(), net());
    }
}
