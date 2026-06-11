public interface Constants {
    double rate = 7.0 / 100;

    //기본요금
    int basic = 1660;
    float[] table = {184.1f, 223.8f, 278.3f, 353.6f, 466.4f, 643.9f};
    int[] limits = {100, 100, 100, 100, 100, Integer.MAX_VALUE};
    int FREE = 100;

    String path = ".\\data\\";
    String dataFile = "customer.dat";
    String outputFile = "customer.rpt";
}
