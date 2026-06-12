public class Salary {
    int baseSalary;         // 기본급
    int stepAllowance;      // 호봉수당
    int managementBonus;    // 관리수당
    int performanceBonus;   // 성과수당
    int stockOption;        // 스톡옵션
    int totalSalary;        // 급여액(총액)
    int tax;                // 세금
    int netPay;             // 지급액(실수령)

    public void calculateTaxAndNet() {
        totalSalary = baseSalary + stepAllowance + managementBonus + performanceBonus + stockOption;

        if (totalSalary < 2000000) {
            tax = (int) (totalSalary * 0.045);
        } else if (totalSalary < 4000000) {
            tax = (int) (totalSalary * 0.084);
        } else if (totalSalary < 6000000) {
            tax = (int) (totalSalary * 0.106);
        } else {
            tax = (int) (totalSalary * 0.123);
        }

        netPay = totalSalary - tax;
    }
}