import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Library cityLibrary = new Library("중앙 도서관");

        Book book1 = new Book("자바 프로그래밍");
        Book book2 = new Book("객체지향 설계");
        Book book3 = new Book("데이터베이스");

        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);
        cityLibrary.addBook(book3);

        Member member1 = new Member("홍길동", "M001");
        cityLibrary.registerMember(member1);

        System.out.println("=== " + cityLibrary.getName() + " 시스템 작동 시작 ===\n");

        cityLibrary.showAllStatus();

        System.out.println("\n[대출 요청]");
        cityLibrary.borrowBook("자바 프로그래밍", member1);
        cityLibrary.borrowBook("고급 자바", member1); // 없는 책 요청

        System.out.println("\n[상태 업데이트]");
        cityLibrary.showAllStatus();
    }
}