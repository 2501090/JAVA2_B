class Employee {
    String name;
    String id;
    int partCode;
    boolean isSpecial;
    int grade;
    int step;
    int savings;

    String partName;
    int basePay;
    int jobAllowance;
    int taskAllowance;
    int tax;
    int totalDeduction;
    int finalPay;

    public Employee(String name, String id, int partCode, boolean isSpecial, int grade, int step, int savings) {
        this.name = name;
        this.id = id;
        this.partCode = partCode;
        this.isSpecial = isSpecial;
        this.grade = grade;
        this.step = step;
        this.savings = savings;
        calculate();
    }

    private void calculate() {
        int[][] basePayTable = {
                {1250000, 1200000, 1150000, 1100000, 1050000},
                {950000, 925000, 900000, 875000, 850000},
                {750000, 725000, 700000, 675000, 650000}
        };
        basePay = basePayTable[grade - 1][step - 1];

        int[] jobAllowTable = {300000, 200000, 100000};
        jobAllowance = jobAllowTable[grade - 1];

        String[] partNames = {"경리과", "인사과", "영업팀", "생산과", "A/S팀"};
        int[] taskAllowTable = {250000, 250000, 350000, 350000, 300000};
        partName = partNames[partCode - 1];
        taskAllowance = taskAllowTable[partCode - 1];

        int basicDeduction = (int)(basePay * 0.03);
        totalDeduction = basicDeduction + savings;

        int taxableAmount = (basePay + jobAllowance + taskAllowance) - totalDeduction;

        if (isSpecial) {
            tax = (int)(basePay * 0.03);
        } else {
            if (taxableAmount >= 1000000) {
                tax = (int)(taxableAmount * 0.09);
            } else if (taxableAmount >= 800000) {
                tax = (int)(taxableAmount * 0.07);
            } else if (taxableAmount >= 700000) {
                tax = (int)(taxableAmount * 0.05);
            } else {
                tax = 0;
            }
        }

        finalPay = (basePay + taskAllowance + jobAllowance) - tax - totalDeduction;
    }

    public void printSlip() {
        String specialMark = isSpecial ? "O" : "X";
        System.out.printf("%-4s\t%-5s\t%-5s\t%-2s\t%d-%d\t%,10d\t%,10d\t%,10d\t%,10d\t%,10d\t%,10d\n",
                name, id, partName, specialMark, grade, step,
                basePay, taskAllowance, jobAllowance, savings, tax, finalPay);
    }
}