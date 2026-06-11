import com.google.zxing.BarcodeFormat;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String data;
        String path = ".\\data\\";
        String fileName = "Barcode128text.png";


        while (true) {
            System.out.print("Barcode 문자열 입력 (문자, 숫자) : ");
            data = keyboard.nextLine(); // 띄어쓰기 위해 nextLine()으로 변경
            if (data != null)
                break;
        }

        ZXingHandler handler = new ZXingHandler();
        handler.encoding(data, BarcodeFormat.CODE_128, path+fileName);
    }
}