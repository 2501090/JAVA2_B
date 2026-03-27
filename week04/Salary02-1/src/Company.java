import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    private void inputData() throws IOException {
        for (int i = 0; i < employees.length; i++) {
            employees[i]
        }
    }

    protected void display() {
        line();
        System.out.println("이름(생일)  사번  부서  호봉  기본급 수당  급여  세금  지급액");
        line();
        for(int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        } line();
    }

    public void sortByPayment() {
        Collections.sort(employees, new netComparator().reversed());
    }
    private class netComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.net() - o2.net();
        }
    }
}
