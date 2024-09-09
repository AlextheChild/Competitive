public class Test {
    public static void main(String[] args) throws Exception {
        for (int t = 0; t < 100; t++) {
            System.out.println((((t / 10) % 2 == 0 ? t % 11 : 10 - t % 11) / 10) * 12);
        }
    }
}