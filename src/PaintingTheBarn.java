import java.io.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("paintbarn.in")));
        PrintWriter out = new PrintWriter("paintbarn.out");
        String[] nk = in.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] paintCoats = new int[1001][1001];
        for (int i = 0; i < n; i++) {

        }

        out.println();

        in.close();
        out.close();
    }
}