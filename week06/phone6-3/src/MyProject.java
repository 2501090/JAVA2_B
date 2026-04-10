public interface MyProject {
    /* int NETWORK = 3200;
    int BASIC = 1000;

    int calculateFee(Customer customer);

    default boolean isOld(int age) {
        return (age > 19);
    }

    default boolean isYoung(int age) {
        return (age <= 19);
    } */

    default void error(String message) {
        System.err.printf("ERROR : %s", message);
    }
}