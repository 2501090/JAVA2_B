import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    ArrayList<Customer> customers = new ArrayList<>();

    protected ArrayList<Customer> readData(File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            String line;
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                line = line.trim().replaceAll(",", "");
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNext()) {
                    String customID = lineScanner.next();
                    Customer customer;
                    if (customID.charAt(0) == '9') {
                        customer = new Special(lineScanner.next(), customID, lineScanner.nextInt());
                        customers.add(customer);
                    } else if (customID.charAt(0) == 'S') {
                        customer = new Normal(lineScanner.next(), customID, lineScanner.nextInt());
                        customers.add(customer);
                    }
                }
                lineScanner.close();
            }
            fileScanner.close();
            if (customers.isEmpty()) {
                System.out.println("데이터가 없습니다");
                System.exit(-1);
            } else {
                System.out.printf("%d개의 데이터를 읽었습니다\n", customers.size());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
}
