//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Temporary("홍길동", new Date(1999, 5, 8), "123456"),
                new Staff("김철수", new Date(1995, 3, 15), "654321", 3, 1),
                new Temporary("경복대", new Date(2000, 7, 20), "789012"),
                new Manager("박영희", new Date(1990, 1, 1), "345678", 5, 2),
                new SalesMan("최영수", new Date(1992, 12, 12), "901234", 4, 1, 10000000, 3.0)
        };

        //입력
        InputHandler inputHandler = new InputHandler();
        inputHandler.inputData(employees);

        //처리
        Company company = new Company(employees);
        company.sortByGross();

        //출력
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.display(employees);

    }
}