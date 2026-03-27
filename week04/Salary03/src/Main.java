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

        Employee[] employees = new Employee[] {
                new Employee("김철수", new Date(90, 3, 15), "2024001", departments[1], grades[1], 0),
                new Employee("이영희", new Date(92, 10, 3), "2024002", departments[2], grades[2], 0),
                new Employee("박지성", new Date(85, 0, 25), "2023055", departments[3], grades[3], 0),
                new Employee("최수연", new Date(95, 6, 12), "2024010", departments[4], grades[4], 0),
                new Employee("정민호", new Date(88, 8, 30), "2022103", departments[5], grades[5], 0),
                new Employee("강하늘", new Date(100, 1, 21), "2024015", departments[1], grades[2], 0),
                new Employee("윤서준", new Date(83, 4, 5), "2021088", departments[2], grades[3], 0),
                new Employee("한미소", new Date(97, 9, 18), "2024022", departments[3], grades[4], 0),
                new Employee("오동건", new Date(91, 11, 25), "2023112", departments[4], grades[5], 0),
                new Employee("장나래", new Date(94, 5, 8), "2024030", departments[5], grades[1], 0)
        };

       Company company = new Company(employees);
       company.display();
    }
}