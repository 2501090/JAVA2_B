class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "책 제목 : " + title + ", 저자 : " + author;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("JAVA 처음하기");

        Book book1 = new Book("Android", "김철수");
        Book book2 = new Book("Bible", "작자미상");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}