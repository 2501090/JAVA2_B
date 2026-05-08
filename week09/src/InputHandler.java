import java.io.IOException;
import java.util.Scanner;

public class InputHandler implements  Symbolic {
    Scanner keyboard = new Scanner(System.in);

    protected void inputData(Employee[] employees) throws IOException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Temporary) {
                inputDailyPay();
                    System.out.println();
            } else if (employees[i] instanceof SalesMan) {
                ((SalesMan) employees[i]).inputData();
                System.out.println();
            }
        }
    }


        private int inputDailyPay() {
            int dailyPay;
            while (true) {
                System.out.printf("%s님의 일당 입력 : ", this.getName());
                dailyPay = keyboard.nextInt();
                if (dailyPay >= 25000 && dailyPay <= 95000) {
                    break;
                }
            }
            return dailyPay;
        }


}
