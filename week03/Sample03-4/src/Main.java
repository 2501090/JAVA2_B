//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Apple apple = new Apple(1000, 30);
        Seller seller = new Seller(apple, 50000);
        Customer customer = new Customer(30000);
        // 3번째줄 myMoney로 받아야 함

        System.out.println(seller);
        System.out.println(customer);

        customer.buy(seller, apple, 5);

    }
}