public abstract class Employee implements Comparable<Employee> {
    protected String employeeID;
    protected String name;
    protected String hireDate;
    protected Salary salary;

    public Employee(String employeeID, String name, String hireDate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hireDate = hireDate;
        this.salary = new Salary();
    }

    public abstract void calculatePay();
    public abstract int getSortGrade();
    public abstract String getPositionName();

    public Salary getSalary() { return salary; }
    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getHireDate() { return hireDate; }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getSortGrade(), o.getSortGrade());
    }
}