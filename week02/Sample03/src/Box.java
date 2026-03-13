public class Box {

    private int width;
    private int height;
    private int depth;
    private String color;
    private String message;

    public Box(int width, String color, int depth, int height, String message) {
        this.width = width;
        this.color = color;
        this.depth = depth;
        this.height = height;
        this.message = message;
    }

    public int volume() {
        return width * height * depth;
    }

    @Override
    public String toString() {
        return String.format(">>> %s BOX <<<\n" +
                "\t 가로 : %d Cm\n" +
                "\t 세로 : %d Cm\n" +
                "\t 높이 : %d Cm\n" +
                "\t 문구 : %s\n" +
                "\t 부피 : %d\u33a4"
                , color, width, height, depth, message, volume());
    }
}
