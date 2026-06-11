import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String data;
        String path = ".\\data\\";
        String fileName = "QRCode.png";

        ZXingHandler handler = new ZXingHandler();
        while (true) {
            System.out.print("QRCode 텍스트 입력 : ");
            data = keyboard.nextLine();
            if (data.isEmpty()) {
                System.out.println("종료");
                break;
            }
            // generate QR code for the entered text
            handler.encoding(data, path + fileName);
        }
    }
}