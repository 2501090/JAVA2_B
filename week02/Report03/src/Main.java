class Date {
    int year;
    int month;
    int day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return year + "년 " + month + "월 " + day + "일";
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. 생년월일 지정
        Date birth = new Date(2000, 5, 10);
        System.out.println("생일: " + birth.toString());

        // 2. 오늘 날짜 지정
        Date today = new Date(2026, 3, 18);
        System.out.println("오늘: " + today.toString());

        // 3. 2025년 2월 29일 지정 (오류 데이터)
        Date errorDay = new Date(2025, 2, 29);
        System.out.println("오류 날짜: " + errorDay.toString());

        // 4. 년도만 2023년으로 수정
        today.year = 2023;
        System.out.println("수정된 날짜: " + today.toString());
    }
}