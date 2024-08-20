package CodeForces;

import java.io.*;

public class GeneratePermutation {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            if (n % 2 == 1) {
                int[] p = new int[n];
                p[n / 2] = 1;

                int evens = 2;
                for (int i = 0; i < n / 2; i++) {
                    p[i] = evens;
                    evens += 2;
                }
                int odds = 3;
                for (int i = n - 1; i >= n / 2 + 1; i--) {
                    p[i] = odds;
                    odds += 2;
                }
                for (int i : p) {
                    System.out.print(i + " ");
                }
                System.out.println();

            } else {
                System.out.println(-1);
            }
        }
    }
}