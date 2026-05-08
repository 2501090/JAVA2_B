import java.util.Scanner;

public class SalesMan extends Regular {
    private int sales;
    private double rate;

    public SalesMan(String name, Date birthday, String employeeId, int step, int grade, int sales, double rate) {
        super(name, birthday, employeeId, step, grade);
        this.sales = sales;
        this.rate = rate;
    }
    
    @Override
    public int bonus() {
        return (int) (sales * (rate / 100));
    }

    @Override
    public String toString() {
        return  String.format("%s %,9d원 %,9d원 %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), basicSalary(), bonus(), salary(), tax(), gross(), "영업수당");
    }

    @Override
    protected void inputData() {
        Scanner keyboard = new Scanner(System.in);
        sales = inputSales(keyboard);
        rate = inputRate(keyboard);
    }

    private int inputSales(Scanner keyboard) {
        int sales;
        while (true) {
            System.out.printf("%s님의 영업실적 입력 : ", this.getName());
            sales = keyboard.nextInt();
            if (sales >= 0) {
                break;
            }
            System.out.println("영업실적 오류");
        }
        return sales;
    }

    private  double inputRate(Scanner keyboard) {
        double rate;
        while (true) {
            System.out.printf("%s님의 영업수당률 입력 : ", this.getName());
            rate = keyboard.nextDouble();
            if (rate >= 0.0 && rate <= 5.0) {
                break;
            }
            System.out.println("영업 커미션 오류");
        }
        return rate;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
