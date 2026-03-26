class Student {
    String name;
    int rollno;
    String depart;
    int birthday;

    // 정보를 출력, 나이를 계산하는 메소드
    void printInfo() {
        int currentYear = 2026;
        int age = currentYear - birthday;

        System.out.println("\n--- 학생 정보 출력 ---");
        System.out.println("이름: " + name);
        System.out.println("학번: " + rollno);
        System.out.println("학과: " + depart);
        System.out.println("나이: " + age + "세");
    }
}