import java.io.IOException;
import java.util.Scanner;

public class Part implements MyProject {
    private String partName;
    private Integer score;

    public Part(String partName) {
        this.partName = partName;
        this.score = 0;
    }

    public Integer getScore() { return score; }
    public String getPartName() { return partName; }

    protected void inputData(String name) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님 %s 성적 입력 : ", name, partName);
            score = keyboard.nextInt();

            if (partName.equals("출석")) {
                if (inValid1(score)) break;
                else error("성적 입력 오류(0~20점)\n");
            } else {
                if (inValid(score)) break;
                else error("성적 입력 오류(0~100점)\n");
            }
        }
    }
}