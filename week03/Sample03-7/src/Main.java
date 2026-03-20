//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("테슬라");
        SportsCar sportsCar = new SportsCar("페라리");

        electricCar.charge();
        electricCar.start();
        electricCar.stop();
        sportsCar.start();
        sportsCar.trubo();
        sportsCar.stop();

    }
}