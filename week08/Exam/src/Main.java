public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        // 1. 본인 데이터 (Regular 대신 Staff 사용!)
        company.addEmployee(new Staff("123344", new Date(1999, 11, 11), "배정환", 1, 1));

        // 2. 입력 필요 사원
        company.addEmployee(new Temporary("123456", new Date(1993, 10, 5), "경복대"));
        company.addEmployee(new Salesman("124567", new Date(2011, 4, 19), "한송이", 3, 4));
        company.addEmployee(new Temporary("456213", new Date(1999, 5, 13), "이대한"));
        company.addEmployee(new Salesman("424561", new Date(2012, 4, 20), "최명길", 3, 2));
        company.addEmployee(new Salesman("124655", new Date(2013, 12, 20), "정통파", 2, 3));

        // 3. 별도 입력 없는 사원
        company.addEmployee(new Manager("245778", new Date(2012, 12, 20), "한민국", 3, 1));
        company.addEmployee(new Manager("345678", new Date(2012, 7, 20), "한국인", 1, 1));
        company.addEmployee(new Staff("234567", new Date(2010, 3, 7), "홍길동", 2, 3));

        // [신규 문제] 비과세 연구직
        company.addEmployee(new Researcher("348988", new Date(2011, 8, 10), "코로나", 1, 4));

        company.inputData();
        System.out.println("\n");
        company.printPayroll();
    }
}