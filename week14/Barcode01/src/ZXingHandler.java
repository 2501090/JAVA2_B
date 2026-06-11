import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZXingHandler {

    protected void encoding(String data, BarcodeFormat format, String fileName) throws WriterException {
        try {
            MultiFormatWriter writer = new MultiFormatWriter();
            BitMatrix matrix = writer.encode(data, format, 300, 100);
            Path path = Paths.get(fileName);
            MatrixToImageConfig config = new MatrixToImageConfig(
                    0xFFFF0000, 0xFFFFFFFF); // 검정, 흰색

            MatrixToImageWriter.writeToPath(matrix, "PNG", path, config);
            System.out.println("Barcode 생성 완료 : " + fileName);
        } catch (WriterException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
