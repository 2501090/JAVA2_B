public class ClassRoom {

    private Student[] students;

    public ClassRoom(Student[] students) {
        this.students = students;
    }

    protected void inputData() {
        for (int i = 0; i < students.length; i++) {
            students[i].inputData();
            System.out.println();
        }
    }

    protected void display(int type) {
        if (type == 1) {
            System.out.println("\t\t\t\t\t 고등학교 성적표");
            line(50);
            System.out.println(" 학번  이름  %s  총점  성적  등수\n", students[0].partsListName());
            line(50);
            for (int i = 0; i< students.length; i++) {
                System.out.println(students[i]);
                line(50);
            }
        } else {
            System.out.println("\t\t\t\t\t 고등학교 성적표");
            line(50);
            System.out.println(" 학번  이름  %s 성적  등수\n", students[0].partsListName());
            line(50);
            for (int i = 0; i< students.length; i++) {
                System.out.println(students[i]);
                line(50);
            }
        }
    }

    private void line(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        } System.out.println("--");
    }

}
