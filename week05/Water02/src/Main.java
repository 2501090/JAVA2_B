//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Type[] types = new Type[] {
                    new Type(" ", 0, 0.0f),
                    new Type("가정용", 40, 5.0f),
                    new Type("영업용", 55, 3.5f),
                    new Type("공장용", 78, 2.5f),
                    new Type("관공서", 35, 1.5f),
                    new Type("군기관", 20, 0.0f),
            };

    Customer[] customers = new Customer[] {
            new Customer("홍길동", "1234", types[1]),
            new Customer("홍길동", "1234", types[2]),
            new Customer("홍길동", "1234", types[3]),
            new Customer("홍길동", "1234", types[4]),
            new Customer("홍길동", "1234", types[5]),
        };
    }
}