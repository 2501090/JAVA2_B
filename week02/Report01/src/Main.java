class TV {
    String brand;
    int year;
    int size;
    String type;

    TV(String brand, int year, int size, String type) {
        this.brand = brand;
        this.year = year;
        this.size = size;
        this.type = type;
    }

    void show() {
        System.out.println("우리집 TV는 " + brand + "에서 만든 " +
                year + "년형 " + size + " 인치 " +
                type + " TV 입니다");
    }
}

public class Main {
    public static void main(String[] args) {
        TV myTV = new TV("Samsung", 2017, 55, "LED");
        myTV.show();
    }
}