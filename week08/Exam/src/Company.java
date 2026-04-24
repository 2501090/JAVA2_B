public class Company {
    private Employee[] employees;
    private int count;

    public Company() {
        employees = new Employee[10];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
        }
    }

    public void inputData() {
        for (int i = 0; i < count; i++) {
            employees[i].inputData();
        }
    }

    public void sortByPay() {
        Employee temp;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (employees[i].calculateActualPay() < employees[j].calculateActualPay()) {
                    temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    public void printPayroll() {
        sortByPay();
        long totalSum = 0;

        System.out.println("경복주식회사 급여 대장");
        line();
        System.out.println("사번\t이름\t\t\t급-호\tday\t일당\t기본급\t\t인센티브\t커미션\t\t급여액\t\t세금\t지급액\t\t비고");
        line();

        for (int i = 0; i < count; i++) {
            Employee e = employees[i];
            totalSum += e.calculateActualPay();

            System.out.printf("%s\t%s%s\t%s\t%d\t%,d원\t%,d원\t%,d원\t\t%,d원\t\t%,d원\t%,d원\t%,d원\t%s\n",
                    e.getEmployeeID(), e.getName(), e.getBirthday().toString(), e.getGradeStep(), e.getDays(), e.getDailyWage(),
                    e.calculateBasePay(), e.getIncentive(), e.getCommission(), e.calculateTotalPay(), e.calculateTax(), e.calculateActualPay(), e.getJobType());
        }
        line();
        System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t지급액 합계 : %,d 원\n", totalSum);
        line();
        System.out.println("\n");

        System.out.println("영업직 사원 커미션 산출 내역");
        System.out.println("*************************************************************************");
        System.out.println("사번\t이름\t\t\t판매 실적\t\t요율\t커미션 금액");
        System.out.println("*************************************************************************");
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof Salesman) {
                Salesman s = (Salesman) employees[i];
                System.out.printf("%s\t%s%s\t%,d원\t\t%.1f%%\t%,d\n",
                        s.getEmployeeID(), s.getName(), s.getBirthday().toString(), s.getSale(), s.getCommissionRate(), s.getCommission());
            }
        }
        System.out.println("*************************************************************************");
    }

    private void line() {
        for (int i = 0; i < 120; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}