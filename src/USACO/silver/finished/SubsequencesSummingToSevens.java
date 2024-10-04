package USACO.silver.finished;

import java.io.*;

public class SubsequencesSummingToSevens {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("div7.in")));
        PrintWriter out = new PrintWriter("div7.out");
        int n = Integer.parseInt(in.readLine());
        long[] IDPrefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long id = Integer.parseInt(in.readLine());
            IDPrefix[i + 1] = IDPrefix[i] + id;
        }

        for (int size = n - 1; size > 0; size--) {
            for (int i = 0; i < n - size; i++) {
                int start = i;
                int end = i + size + 1;

                if ((IDPrefix[end] - IDPrefix[start]) % 7 == 0) {
                    out.println(size + 1);
                    in.close();
                    out.close();
                    System.exit(0);
                }
            }
        }
    }
}