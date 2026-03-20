public class Car {

    protected String model;

    public Car(String model) {
        this.model = model;
    }

    public void drive() {
        System.out.printf("%s 자동차가 운전을 시작합니다\n", model);
    }

    public void findRoute(Navigation navigation, String start, String destination) {
        navigation.findRoute(start,destination);
    }

    public void stop() {
        System.out.printf("%s 자동차가 운전을 정지합니다\n", model);
    }
}