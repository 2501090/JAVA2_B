public class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    protected void inputData() {
        for (int i = 0; i < employees.length; i++) {
           if (employees[i] instanceof Temporary) {
               ((Temporary) employeespi[i]).inputData();
               System.out.println();
           } else if (employees[i] instanceof SalesMan) {
               ((SalesMan) employees[i]).inputData();
               System.out.println();
           }
        }
    }

    protected void sortByGross() {

    }

    protected void display() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }



}
