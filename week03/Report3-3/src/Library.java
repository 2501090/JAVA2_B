import java.util.ArrayList;
import java.util.List;

class Library {
    private String name;
    private List<Book> books;
    private List<Member> members;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addBook(Book book) { books.add(book); }
    public void registerMember(Member member) { members.add(member); }

    public void borrowBook(String title, Member member) {
        System.out.println("-> '" + member.getName() + "'님이 '" + title + "' 대출 요청");
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.isAvailable()) {
                b.checkOut();
                System.out.println("=> '" + title + "' 대출이 완료되었습니다.");
                return;
            }
        }
        System.out.println("=> '" + title + "'은 현재 대출이 불가능한 도서입니다.");
    }

    public void showAllStatus() {
        System.out.println("--- " + this.name + " 도서 목록 ---");
        for (Book b : books) {
            System.out.println(b);
        }
        System.out.println("--- 회원 수: " + members.size() + "명 ---");
    }
}