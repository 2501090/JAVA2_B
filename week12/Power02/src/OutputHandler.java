import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class OutputHandler {

    protected void report(String fileName, ArrayList<Customer> customers) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName, StandardCharsets.UTF_8);
            PrintWriter monitor = new PrintWriter(System.out);
            header(monitor);
            header(printWriter);
     
            for (Customer customer : customers) {
                printWriter.println(customer);
                monitor.println(customer);
            }
            line(printWriter, 60);
            line(monitor, 60);
            printWriter.close();
            monitor.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void header(PrintWriter printWriter) {
        line(printWriter, 60);
        printWriter.println("고객번호  이름   사용량    사용금액  세금  납부금액  비고");
        line(printWriter, 60);
    }

    private void line(PrintWriter printWriter, int count) {
        for(int i = 0; i < count; i++) {
            printWriter.print("*");
        }
        printWriter.println();
    }
}
