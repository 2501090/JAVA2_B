import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelHandler {

    public List<Employee> readExcel(File file) {
        List<Employee> employees = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                String employeeID = readData(row, 0);
                String name = readData(row, 1);
                String hireDate = readData(row, 2);
                String type = readData(row, 3).trim();

                if (employeeID.isEmpty()) continue;

                if (type.contains("임원")) {
                    int grade = parseIntSafe(readData(row, 4));
                    int perfBonus = parseIntSafe(readData(row, 6));
                    int stockOption = parseIntSafe(readData(row, 7));
                    employees.add(new Executive(employeeID, name, hireDate, grade, perfBonus, stockOption));
                } else if (type.contains("관리")) {
                    int grade = parseIntSafe(readData(row, 4));
                    int step = parseIntSafe(readData(row, 5));
                    employees.add(new Manager(employeeID, name, hireDate, grade, step));
                } else if (type.contains("사원")) {
                    int grade = parseIntSafe(readData(row, 4));
                    int step = parseIntSafe(readData(row, 5));
                    employees.add(new Staff(employeeID, name, hireDate, grade, step));
                } else if (type.contains("일용")) {
                    int dailyWage = parseIntSafe(readData(row, 6));
                    int workDays = parseIntSafe(readData(row, 7));
                    employees.add(new Temporary(employeeID, name, hireDate, dailyWage, workDays));
                } else if (type.contains("계약")) {
                    employees.add(new Contract(employeeID, name, hireDate));
                }
            }
            workbook.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            System.out.println("엑셀 읽기 오류: " + e.getMessage());
        }
        return employees;
    }

    private String readData(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
                }
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return "";
        }
    }

    private int parseIntSafe(String val) {
        if (val == null || val.trim().isEmpty()) return 0;
        try {
            return Integer.parseInt(val.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void writeExcel(String fileName, List<Employee> employees) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("직원 급여 현황표");

        header(workbook, sheet);
        record(workbook, sheet, employees);

        setColumnWidths(sheet);

        try {
            OutputStream outputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            workbook.close();
            System.out.println("급여 처리 엑셀 파일 생성 성공: " + fileName);
        } catch (IOException e) {
            System.out.println("엑셀 쓰기 오류: " + e.getMessage());
        }
    }

    private void record(XSSFWorkbook workbook, XSSFSheet sheet, List<Employee> employees) {
        CellStyle dataStyle = getCellStyle(workbook, IndexedColors.WHITE);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        for (int i = 0; i < employees.size(); i++) {
            XSSFRow row = sheet.createRow(i + 2);
            Employee emp = employees.get(i);
            Salary s = emp.getSalary();

            String year = "", month = "", day = "";
            try {
                String[] dateParts = emp.getHireDate().split("-");
                if(dateParts.length == 3) {
                    year = dateParts[0];
                    month = String.valueOf(Integer.parseInt(dateParts[1]));
                    day = String.valueOf(Integer.parseInt(dateParts[2]));
                }
            } catch (Exception e) {}

            String grade = "", posName = "", step = "", workDays = "", dailyWage = "";
            String stepAllow = "", mgmtPerf = "", stockOpt = "", typeStr = "";

            if (emp instanceof Executive) {
                Executive ex = (Executive) emp;
                grade = String.valueOf(ex.getSortGrade());
                posName = ex.getPositionName();
                step = "0";
                stepAllow = "0원";
                mgmtPerf = formatWon(s.performanceBonus);
                stockOpt = formatWon(s.stockOption);
                typeStr = "임원직";
            } else if (emp instanceof Manager) {
                Manager mg = (Manager) emp;
                grade = String.valueOf(mg.getSortGrade());
                posName = mg.getPositionName();
                step = String.valueOf(mg.getStep());
                stepAllow = formatWon(s.stepAllowance);
                mgmtPerf = formatWon(s.managementBonus);
                typeStr = "관리직";
            } else if (emp instanceof Staff) {
                Staff st = (Staff) emp;
                grade = String.valueOf(st.getSortGrade());
                posName = st.getPositionName();
                step = String.valueOf(st.getStep());
                stepAllow = formatWon(s.stepAllowance);
                typeStr = "정규직";
            } else if (emp instanceof Temporary) {
                Temporary temp = (Temporary) emp;
                workDays = String.valueOf(temp.getWorkDays());
                dailyWage = formatWon(temp.getDailyWage());
                typeStr = "일당제";
            } else if (emp instanceof Contract) {
                typeStr = "계약직";
            }

            Object[] rowData = {
                    emp.getEmployeeID(), emp.getName(),
                    year, month, day,
                    grade, posName, step, workDays, dailyWage,
                    formatWon(s.baseSalary), stepAllow, mgmtPerf, stockOpt,
                    formatWon(s.totalSalary), formatWon(s.tax), formatWon(s.netPay), typeStr
            };

            for (int j = 0; j < rowData.length; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(rowData[j] != null ? rowData[j].toString() : "");
                cell.setCellStyle(dataStyle);
            }
        }
    }

    private String formatWon(int amount) {
        if (amount == 0) return "";
        return String.format("%,d원", amount);
    }

    private void header(XSSFWorkbook workbook, XSSFSheet sheet) {
        CellStyle titleStyle = getCellStyle(workbook, IndexedColors.YELLOW);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        XSSFRow row0 = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);

        String[] topHeaders = {"사번", "이름", "입사일", "", "", "직급", "직급명", "호봉", "day", "일당", "기본급", "기본수당", "관리/성과", "스톡옵션", "급여액", "세금", "지급액", "기타"};
        String[] subHeaders = {"", "", "년", "월", "일", "", "", "", "", "", "", "", "", "", "", "", "", ""};

        for (int i = 0; i < topHeaders.length; i++) {
            XSSFCell cell0 = row0.createCell(i);
            cell0.setCellValue(topHeaders[i]);
            cell0.setCellStyle(titleStyle);

            XSSFCell cell1 = row1.createCell(i);
            cell1.setCellValue(subHeaders[i]);
            cell1.setCellStyle(titleStyle);
        }

        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 4));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 11, 11));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 12, 12));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 13, 13));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 14, 14));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 15, 15));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 16, 16));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 17, 17));
    }

    private void setColumnWidths(XSSFSheet sheet) {
        int[] widths = {
                2500, // 0: 사번
                2500, // 1: 이름
                2000, // 2: 년
                1500, // 3: 월
                1500, // 4: 일
                2000, // 5: 직급
                3000, // 6: 직급명
                2000, // 7: 호봉
                2000, // 8: day
                3500, // 9: 일당
                4500, // 10: 기본급
                4000, // 11: 기본수당
                4000, // 12: 관리/성과
                4500, // 13: 스톡옵션
                4500, // 14: 급여액
                3500, // 15: 세금
                4500, // 16: 지급액
                3000  // 17: 기타
        };
        for (int i = 0; i < widths.length; i++) {
            sheet.setColumnWidth(i, widths[i]);
        }
    }

    private CellStyle getCellStyle(XSSFWorkbook workbook, IndexedColors color) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(color.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        return cellStyle;
    }
}