import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDFHandler {

    String[] headers = {"학번", "이름", "성별", "국어", "영어", "수학", "선택", "합계", "평균", "성별등수", "학급등수"};

    protected ArrayList<Student> readPDF(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            PdfReader reader = new PdfReader(fileName);
            StringBuilder builder = new StringBuilder();
            //진짜 값이 없는지 확인
            System.out.printf(reader.getNumberOfPages() + " ");

            // Excel PDF 의 열이 0부터 시작하니까 1를 세니까 1부터 시작
            for (int i = 1; i < reader.getNumberOfPages(); i++) {
                String pageText = PdfTextExtractor.getTextFromPage(reader, i);
                builder.append(pageText).append("\n");
            }
            reader.close();
            //한줄씩 읽은 데이터를 makeData로 넘김
            makeData(builder.toString(), students);
            if (students.isEmpty()) {
                System.out.println("데이터가 없습니다.");
                System.exit(-1);
            } else {
                System.out.printf("%d개의 데이터를 읽었습니다.\n", students.size());
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private void makeData(String text, ArrayList<Student> students) {
        String[] lines = text.split("\\r?\\n");
        for (int i = 0; i < lines.length; i++) {
            String fixedLine = lines[i].replaceAll("^(\\d{7})([가-힣]+)", "$1 $2");
            System.out.println(fixedLine.trim());
            if (fixedLine.matches("^\\d{7}\\s+.*")) {
                String[] tokens = fixedLine.trim().split("\\s+");
                if (tokens.length >= 7) {
                    String studentID = tokens[0];
                    String name = tokens[1];
                    String gender = tokens[2];
                    Student student = new Student(name, gender, studentID);
                    for (int j = 0; j < student.getSubjects().size(); j++) {
                        student.getSubject(j).setScore(Integer.parseInt(tokens[j + 3]));
                    }
                    students.add(student);
                }
            }
        }
    }

    public void makePDF(String fileName, ArrayList<Student> students) {
        Document documnet = new Document();
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(outputStream);
            PdfWriter.getInstance(document, bufferedOutputStream);
            document.open();
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 8);
            PdfPTable table = new PdfPTable(headers.length);
            title(documnet, baseFont, font, table);
            record(font, table, students);
            document.add(table);
            System.out.println("PDF 파일 생서 완료");

            // 합칠수 있음!
            //
//          catch (FileNotFoundException e | Exception e)
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void title(Document documnet, BaseFont baseFont, Font font, PdfPTable table) {
        Font titleFont = new Font(baseFont, 16, Font.BOLD, BaseColor.RED);
        Paragraph title = new Paragraph("학생 성적표", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph("\n"));
        for (int i = 0; i < headers.length; i++) {
            table.addCell(getCell(headers[i], font, BaseColor.YELLOW));
        }
    }

    private PdfPCell getCell(String data, Font font) {
        PdfCell cell = new PdfPCell(new paragraph(data, font));
        cell.setHoriziontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    //바탕화면에 색을 지정하는 걸 하고 싶다
    private PdfPCell getCell(String data, Font font, BaseColor color) {
        PdfCell cell = new PdfPCell(new paragraph(data, font));
        cell.setBackgroundColor(color);
        cell.setHoriziontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    private void record(Font font, PdfPTable table, ArrayList<Student>) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            table.addCell(getCell(student.getStudentID(), font));
            table.addCell(getCell(student.getName(), font));
            table.addCell(getCell(student.getGender(), font));
            for (int j = 0; j < student.getSubjects().size(); j++) {
                //Stirng.valueOf() 숙지!
                table.addCell(getCell(String.valueOf()(student.getSubject(j).getScore())));
            }
            table.addCell(getCell(String.valueOf(student.sum(), font));
            table.addCell(getCell(String.valueOf(student.avg(), font));
            ClassRoom classRoom = new ClassRoom(students);
            //남성 여성을 색상으로 구분
            table.addCell(getCell(String.valueOf(classRoom.getGenderRank(student.getGender(), i)),font
            student.getGender().equals("여") ? | BaseColor.PINK : BaseColor.GREEN);
            table.addCell(getCell(String.valueOf(classRoom.getRank(i)),font);
        }
    }

}