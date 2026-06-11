import java.io.File;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String path = ".\\data\\";
        String fileName = "student.pdf";
        String outputFile = "report.pdf";
        ArrayList<Student> students;


        File file = new File(path + fileName);
        if (file.exists()) {
         PDFHandler handler = new PDFHandler();
         students = handler.readPDF(path + fileName);
         ClassRoom classRoom  = new ClassRoom(students);
         classRoom.sortByGenderAndSum();

         handler.makePDF(path + outputFile, students);



        } else {
            System.out.printf("%s File이 존재하지 않습니다. \n", path + fileName);
        }
    }
}