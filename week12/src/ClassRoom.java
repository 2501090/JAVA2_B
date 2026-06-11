import java.util.ArrayList;

public class ClassRoom {

    private ArrayList<Student> students;

    public ClassRoom(ArrayList<Student> students) {
        this.students = students;
    }

    protected int getRank(int index) {

        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).sum() > sum) {
                rank++;
            }
            return rank;
        }
    }
