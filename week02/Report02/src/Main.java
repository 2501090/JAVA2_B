class Movie {
    String title;
    String director;
    int open;
    String mainActor;
    double rankPoint;

    Movie(String title, String director, int open, String mainActor, double rankPoint) {
        this.title = title;
        this.director = director;
        this.open = open;
        this.mainActor = mainActor;
        this.rankPoint = rankPoint;
    }

    void show() {
        System.out.println("제목: " + title + ", 감독: " + director + ", 개봉: " + open + ", 주연: " + mainActor + ", 평점: " + rankPoint);
    }
}

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("헤라클레스", "레니 할린", 2014, "켈란 루츠", 6.9);
        Movie movie2 = new Movie("노아", "대런 아로노프스키", 2004, "러셀 크로우", 7.3);

        // 평점 변경 및 출력
        movie2.rankPoint = 8.2;
        movie1.show();
        movie2.show();

        // 특정 필드(감독)만 출력
        System.out.println("movie1 감독: " + movie1.director);
    }
}