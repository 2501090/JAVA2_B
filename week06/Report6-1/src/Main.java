import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.print("이대한 고객의 사용량 입력 : ");
        int leeUsage = scanner.nextInt(); 
        scanner.close();

        // 초기 데이터 [cite: 27-38]
        String[][] rawData = {
                {"12345", "정상진", "7898"},
                {"92345", "일본인", "2345"},
                {"12345", "홍길동", "1234"},
                {"12345", "한국인", "789"},
                {"12345", "고길동", "678"},
                {"12345", "이대한", String.valueOf(leeUsage)},
                {"92345", "이기동", "567"},
                {"92345", "박종호", "563"},
                {"12345", "이니나", "456"},
                {"12345", "윤상열", "345"}
        };

        for (String[] data : rawData) {
            String id = data[0];
            String name = data[1];
            int usage = Integer.parseInt(data[2]);

            // 다형성 활용: 번호에 따라 다른 객체 생성
            Customer c = id.startsWith("9")
                    ? new SupportCustomer(id, name, usage)
                    : new GeneralCustomer(id, name, usage);

            c.calculateBill();
            customers.add(c);
        }

        Collections.sort(customers); // 정렬 실행 [cite: 47]
        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("****************************************************************************************");
        System.out.printf("%-7s %-5s %-10s %-15s %-10s %-15s %-10s\n", "번호", "이름", "사용량", "사용요금", "세금", "납부금액", "기타");
        System.out.println("****************************************************************************************");

        for (Customer c : customers) {
            System.out.printf("%-7s %-5s %10s %15s %12s %15s %10s\n",
                    c.id, c.name, df.format(c.usage) + "Kw", df.format(c.usageRate) + "원",
                    df.format(c.tax) + "원", df.format(c.totalBill) + "원", c.getRemark());
        }
    }
}