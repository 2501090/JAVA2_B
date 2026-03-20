//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Apple apple = new Apple(1000, 30);
        Seller seller = new Seller(apple, 50000);
        Customer customer = new Customer(30000);
        // mymoney여야 함 3번쨰줄

        Store store = new Store(seller, customer);
        store.open();
        store.trade(5);
        store.trade(15);
    }
}