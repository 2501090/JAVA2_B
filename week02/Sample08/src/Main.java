import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Adder adder = new Adder();

        adder.setStart(adder.readData("시작 숫자를 입력"));
        adder.setLast(adder.readData("마지막 숫자 입력"));

        System.out.println(adder);

    }
}