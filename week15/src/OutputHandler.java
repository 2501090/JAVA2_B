import java.util.List;

public class OutputHandler {
    public void printPayrollReport(List<Employee> employees) {
        System.out.println("\t\t\t\t[ 직원 급여 현황표 ]");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s | %-4s | %-10s | %-4s | %10s | %10s | %10s | %10s | %10s | %10s\n",
                "사번", "이름", "입사일", "직급명", "기본급", "수당류", "급여액", "세금", "지급액", "기타");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        for (Employee emp : employees) {
            Salary s = emp.getSalary();
            int totalAllowances = s.stepAllowance + s.managementBonus + s.performanceBonus + s.stockOption;

            System.out.printf("%-6s | %-4s | %-10s | %-5s | %,10d원 | %,10d원 | %,10d원 | %,10d원 | %,10d원 | %s\n",
                    emp.getEmployeeID(),
                    emp.getName(),
                    emp.getHireDate(),
                    emp.getPositionName(),
                    s.baseSalary,
                    totalAllowances,
                    s.totalSalary,
                    s.tax,
                    s.netPay,
                    emp.getPositionName() + "직"
            );
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }
}