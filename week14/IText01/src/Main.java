//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String path = ".\\data\\";
        String fileName = "bookinvoice.pdf";

        Book[] books = {new Book("JAVA Programming 완전정복", 22000, 5,
                "9788970502105"),
                new Book("Android Programming 완전정복", 32000, 5,
                        "9788931462869")};

        iTextHandler iTextHandler = new iTextHandler();
        iTextHandler.makePDF(books, path + fileName);
    }
}