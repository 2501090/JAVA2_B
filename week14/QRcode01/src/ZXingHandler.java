import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZXingHandler {

    protected void encoding(String data, String fileName) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map<EncodeHintType, Object> hintTypeObjectMap = new HashMap<>();
        hintTypeObjectMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintTypeObjectMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250, hintTypeObjectMap);
            Path path = Paths.get(fileName);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            System.out.println("QR코드 생성 완료");
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
