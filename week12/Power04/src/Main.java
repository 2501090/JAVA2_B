import java.io.File;
import java.util.ArrayList;

public class Main implements Constants {
    public static void main(String[] args) {

        ArrayList<Customer> customers;

        File file = new File(path + dataFile);
        if (file.exists()) {
            InputHandler inputHandler = new InputHandler();
            customers = inputHandler.readData(file);

            PowerOffice powerOffice = new PowerOffice(customers);
            powerOffice.sortByCharge();

            OutputHandler outputHandler = new OutputHandler();
            outputHandler.report(path + outputFile, customers);

            try {
                Runtime.getRuntime().exec(new String[]{"notepad.exe", path + outputFile});
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.printf("%s File이 존재하지 않습니다\n", path + dataFile);
        }
    }
}