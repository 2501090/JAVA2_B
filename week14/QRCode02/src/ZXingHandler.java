import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ZXingHandler {

    protected void decoding(File file) {
        MultiFormatReader reader = new MultiFormatReader();
        try (FileInputStream inputStream = new FileInputStream(file)) {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            if (bufferedImage == null) {
                System.out.println("이미지를 읽을 수 없습니다: " + file.getAbsolutePath());
                return;
            }

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

            Result result = reader.decode(binaryBitmap, hints);
            System.out.println("QR코드 디코딩 결과 : " + result.getText());
            System.out.println("Code Format : " + result.getBarcodeFormat());

        } catch (NotFoundException e) {
            System.out.println("QR 코드를 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
