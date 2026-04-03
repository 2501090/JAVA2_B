public class Main {
    public static void main(String[] args) {
        Employee[] emps = {
                new Employee("홍길동", "11111", 1, false, 1, 1, 200000),
                new Employee("한국민", "12231", 3, false, 2, 3, 200000),
                new Employee("이대한", "13156", 4, false, 2, 4, 200000),
                new Employee("한아름", "13211", 5, false, 3, 3, 100000),
                new Employee("새로움", "16171", 4, false, 3, 5, 200000),
                new Employee("이기쁨", "17778", 3, false, 2, 3, 350000),
                new Employee("정동진", "18567", 1, true, 2, 2, 200000),
                new Employee("김진우", "19129", 4, false, 1, 1, 200000),
                new Employee("이나래", "19891", 3, false, 3, 4, 200000),
                new Employee("박명길", "21190", 2, false, 2, 5, 300000)
        };

        System.out.println("이름\t사번\t부서명\t원호\t급-호\t본봉\t\t업무수당\t직급수당\t공제금액\t세금\t\t수령액");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Employee e : emps) {
            e.printSlip();
        }
    }
}