class Book {
    private String title;
    private boolean isAvailable; // 대출 가능 여부

    public Book(String title) {
        this.title = title;
        this.isAvailable = true; // 기본적으로 대출 가능
    }

    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }

    public void checkOut() { this.isAvailable = false; }
    public void returnBook() { this.isAvailable = true; }

    @Override
    public String toString() {
        return "제목: " + title + " (상태: " + (isAvailable ? "대출 가능" : "대출 중") + ")";
    }
}