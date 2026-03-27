import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = {
                new Employee("김철수", "2024001", new Date(90, 3, 15), '1', '1'),
                new Employee("이영희", "2024002", new Date(92, 10, 3), '2', '1'),
                new Employee("박지성", "2023055", new Date(85, 0, 25), '4', '2'),
                new Employee("최수연", "2024010", new Date(95, 6, 12), '1', '3'),
                new Employee("정민호", "2022103", new Date(88, 8, 30), '3', '2'),
                new Employee("강하늘", "2024015", new Date(100, 1, 21), '1', '4'),
                new Employee("윤서준", "2021088", new Date(83, 4, 5), '5', '1'),
                new Employee("한미소", "2024022", new Date(97, 9, 18), '2', '3'),
                new Employee("오동건", "2023112", new Date(91, 11, 25), '2', '2'),
                new Employee("장나래", "2024030", new Date(94, 5, 8), '1', '4')
        };

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}