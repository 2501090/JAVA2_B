public class Department {

    private char departNo;
    private String departName;

    public Department(char departNo, String departName) {
        this.departNo = departNo;
        this.departName = departName;
    }

    //getter
    public char getDepartNo() {
        return departNo;
    }

    public String getDepartName() {
        return departName;
    }

    //toString
    @Override
    public String toString() {
        return String.format("%3s ", departName);
    }
}
