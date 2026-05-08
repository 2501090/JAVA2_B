import java.util.Scanner;

abstract public class Employee extends Person implements Symbolic{

    private String employeeId;

    public Employee(String name, Date birthday, String employeeId) {
        super(name, birthday);
        this.employeeId = employeeId;
    }

    abstract public int basicSalary();

    public int salary() {
        return basicSalary() + bonus();
    }

    public int tax() {
        int tax;
        if (this instanceof Temporary)
            tax = (int) (basicSalary() * (6.6f/100));
        else
            if (basicSalary() <= 2000000) {
                tax = (int) (basicSalary() * (6.6f / 100));
            } else if (basicSalary() <= 3000000) {
                tax = (int) (basicSalary() * (3.3f / 100));
            }
        return tax;
    }

    public int gross() {
        return salary() - tax();
    }

    protected void inputData() {
        Scanner keyboard = new Scanner(System.in);
        sales = inputSales();
    }

    private  int inputSales() {
        int sales;
        while (true) {
            System.out.printf("%s님의 영업실적 입력 : ", this.getName);

        }
    }

    @Override
    public String toString() {
        return String.format("%6s %s, employeeId, super.toString()");
    }
}
