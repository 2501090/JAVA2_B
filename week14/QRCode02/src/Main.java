//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String path = ".\\data\\";
        String fileName = "qrCode.png";

        File file = new File(path+fileName); // parameter값이 pathname
        if (file.exists()) {
          
        } else {
            System.out.println("%s 파일이 존재하지 않아요.\n", path + fileName);
        }
    }
}