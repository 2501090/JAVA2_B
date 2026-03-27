import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department[] departments = new Department[] {
                new Department('0', ""),
                new Department('1', "인사팀"),
                new Department('2', "재무팀"),
                new Department('3', "영업팀"),
                new Department('4', "개발팀"),
                new Department('5', "생산팀"),
        };

        Grade[] grades = new Grade[] {
                new Grade('0', 0),
                new Grade('1', 1650000),
                new Grade('2', 1680000),
                new Grade('3', 1700000),
                new Grade('4', 1720000),
                new Grade('5', 1750000),
        };

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("김철수", "2024001", new Date(90, 3, 15), departments[0], grades[0]));
        employees.add(new Employee("이영희", "2024002", new Date(92, 10, 3), departments[1], grades[1]));
        employees.add(new Employee("박지성", "2023055", new Date(85, 0, 25), departments[2], grades[2]));
        employees.add(new Employee("최수연", "2024010", new Date(95, 6, 12), departments[0], grades[1]));
        employees.add(new Employee("정민호", "2022103", new Date(88, 8, 30), departments[1], grades[2]));
        employees.add(new Employee("강하늘", "2024015", new Date(100, 1, 21), departments[2], grades[0]));
        employees.add(new Employee("윤서준", "2021088", new Date(83, 4, 5), departments[0], grades[3]));
        employees.add(new Employee("한미소", "2024022", new Date(97, 9, 18), departments[1], grades[1]));
        employees.add(new Employee("오동건", "2023112", new Date(91, 11, 25), departments[2], grades[2]));

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}