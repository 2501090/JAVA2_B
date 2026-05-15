            return String.format("(%2d세", age());
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        return today.getYear() - birthDate.getYear() -
                (today.getDayOfYear() < birthDate.getDayOfYear() ? 1 : 0);
    }


    public int age() throws IOException {// 나이 계산
        LocalDate birthDate = LocalDate.of(year, month, day);
        if (birthDate == null)
            error("유효하지 않은 생년월일 입니다.");
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    private void error(String message) throws IOException {
        System.err.println("ERROR : " + message);
        System.in.read();
    }

    @Override
    public String toString() {
        try {
            return String.format("(%2d세)", age());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}