//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Adder problem1 = new Adder(5,3);

        System.out.println(problem1);

        Adder[] problem = new Adder[] {new Adder(5,8), new Adder(8,12) , new Adder(8,17)};

        for (int i=0; i< problem.length; i++) {
            System.out.println(problem[i]);
        }
    }
}