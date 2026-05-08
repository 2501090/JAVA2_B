public class Staff extends Regular {


    public Staff(String name, Date birthday, String employeeId, int step, int grade) {
        super(name, birthday, employeeId, step, grade);
    }

    @Override
    public String toString() {
        return String.format("%s %,9d원 %,9d원 %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), basicSalary(), bonus(), salary(), tax(), gross(), "정규직");
    }
}
