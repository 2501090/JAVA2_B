import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[] {
                new Customer("홍길동", "1234", '1'),
                new Customer("홍길동", "1234", '2'),
                new Customer("홍길동", "1234", '3'),
                new Customer("홍길동", "1234", '4'),
                new Customer("홍길동", "1234", '5'),

        };

        WaterOffice office = new WaterOffice(customers);
        office.inputData();
        office.display();
    }
}