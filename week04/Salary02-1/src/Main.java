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

//        Employee[] employees = new Employee[] {
//                new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        new Employee(new String[]{"홍길동", "1234"}, new Date(2000, 3, 26)),
//                departments[1], grades[1]),
//        };

        Company company = new Company(employees);
        company.inputData();
        company.display();

    }
}