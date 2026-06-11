import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExcelHandler {

    protected ArrayList<Student> readExcel(File file) {

        ArrayList

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFWorkbook sheet = workbook.getSheet("학생성적");
            //getPhysicalNumberOfRows() : 실제로 데이터가 있는 행의 수를 반환
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                String studentID = readData(row, 0);
                Stirng name = readData(row, 1);
                String gender = readData(row, 2);
                Student student = new Student(name, gender, studentID);
                for (int j = 0; j < student.getSubject().size(); j++) {
                    student.setSubject(j,
                            Integer.parseInt(readData(row, j + 3));
                }
                student add (student);
            }
            if (students.isEmpty()) {
                System.out.println("데이터가 없습니다.");
                System.exit(-1);
            } else {
                System.out.printf("%d개의 데이터를 읽었습니다.\n, students.size() ");
            }
            workbook.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    private String readData(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        String value = "";
        switch (cell.getCellType()) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                //getNumericCellValue() : 셀의 숫자 값을 반환
                valeu = (int) cell.getNumericCellValue() + "";
            default:
                return "";
        }
        return value;
    }

    protected void writeExcel(String fileName, ArrayList<Student> students) {
        XSSFWorkbook workbook = new XSSFWorkbook(fileName);
        XSSFSheet sheet = workbook.createSheet("학생성적 처리");

    }

    private void record(XSSFWorkbook workbook, XSSFSheet sheet, ArrayList<Student>) {
        CellStyle femaleStyle = getCellStyle(workbook, IndexedColors.PINK);
        CellStyle maleStyle = getCellStyle(workbook, IndexedColors.GREEN);
        for (int i = 0; i < students.size(); i++) {
            SSFRow row = sheet.createRow(i + 1);
            Student studnet = studnets.get(i);
            CellStyle style = student.getGender().equals("남자") ? maleStyle : femaleStyle;
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(student.getStudentID());
            cell = row.createCell(1);
            cell.setCellValue(student.getName());
            cell = row.createCell(2);
            cell.setCellValue(student.getGender());
            for (int j = 0; j < student.getSubjects().size(); j++)
        }
    }

    private void header(XSSFWorkbook workbook, XSSFSheet sheet, ArrayList<Student>) {
        CellStyle titleStyle = getCellStyle(workbook, IndexedColors.YELLOW);
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("학번");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(1);
        cell.setCellValue("이름");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(2);
        cell.setCellValue("성별");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(3);
        cell.setCellValue("국어");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(4);
        cell.setCellValue("영어");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(5);
        cell.setCellValue("수학");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(6);
        cell.setCellStyle("합계");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(7);
        cell.setCellStyle("평균");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(8);

        private CellStyle getCellStyle (XSSFWorkbook workbook, IndexedColors color){
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFillForegroundColor(color.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            return cellStyle;

        }
    }

