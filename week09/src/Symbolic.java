import java.io.IOException;

interface  Symbolic {

    int[][] salary = new int[][] {
            {0, 0, 0, 0, 0, 0}, // 0급 (사용 안 함)
            {0, 2600000, 2650000, 2700000, 2750000, 2800000}, // 1급 (0, 1호봉, 2호봉, 3호봉, 4호봉, 5호봉)
            {0, 2800000, 2860000, 2920000, 2980000, 3040000}, // 2급
            {0, 3100000, 3170000, 3240000, 3310000, 3380000}, // 3급
            {0, 3400000, 3480000, 3560000, 3640000, 3720000}, // 4급
            {0, 3800000, 3890000, 3980000, 4070000, 4160000}  // 5급
    };

    default void error(String message) throws IOException {
        System.err.println("ERROR : " + message);
        System.in.read();
    }

}
