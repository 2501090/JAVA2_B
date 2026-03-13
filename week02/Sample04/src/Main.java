//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Person kim = new Person("김철수", 183, 65.7f, new Date(2007, 7, 20)
            , new Address("경기도", "남양주시", "234번지"));

    System.out.println(kim);

    }
}