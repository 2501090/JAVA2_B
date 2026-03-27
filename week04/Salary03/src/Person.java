public class Person {

    private String name;
    private Date brithday;

    public Person(String name, Date brithday) {
        this.name = name;
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return String.format("%3s%s ", name, brithday);
    }

    public String getName() {
        return name;
    }
}
