class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고 " + age + "살 입니다.");
    }
}

class Teacher extends Person {
    Teacher(String name, int age) { super(name, age); }
    void work() {
        System.out.println(name + " 선생님이 수업을 합니다.");
        System.out.println(name + " 선생님이 과제를 채점합니다.");
    }
}

class Doctor extends Person {
    Doctor(String name, int age) { super(name, age); }
    void work() {
        System.out.println(name + " 의사가 환자를 진료합니다.");
        System.out.println(name + " 의사가 수술도 진행합니다.");
    }
}

class Engineer extends Person {
    Engineer(String name, int age) { super(name, age); }
    void work() {
        System.out.println(name + " 엔지니어가 프로그램을 개발합니다.");
        System.out.println(name + " 엔지니어가 프로젝트의 버그를 수정합니다.");
    }
}