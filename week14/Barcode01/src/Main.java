import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws WriterException {

        Scanner keyboard = new Scanner(System.in);
        String data;
        String path = ".\\data\\";
        String fileName = "barcode128.png";

        while (true) {
            System.out.print("Barcode 문자 입력 (영문자, 숫자) : ");
            data = keyboard.next();
            if (data != null)
                break;
        }

        ZXingHandler handler = new ZXingHandler();
        handler.encoding(data, BarcodeFormat.CODE_128, path+fileName);
    }
}