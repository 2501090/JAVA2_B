import java.io.File;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = ".\\data\\";
        String excelFile = "employee.xlsx";
        String outputFile = "payrollOut.xlsx";
        List<Employee> employees;

        File file = new File(path + excelFile);

        if (file.exists()) {
            ExcelHandler handler = new ExcelHandler();

            employees = handler.readExcel(file);

            for (Employee emp : employees) {
                emp.calculatePay();
            }

            Collections.sort(employees);

            OutputHandler outputHandler = new OutputHandler();
            outputHandler.printPayrollReport(employees);

            handler.writeExcel(path + outputFile, employees);

        } else {
            System.out.printf("%s 파일이 존재하지 않아요.\n", path + excelFile);
            System.out.println("해당 경로에 엑셀 파일을 먼저 생성해 주세요.");
        }
    }
}