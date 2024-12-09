package USACO.silver.bad;

import java.io.*;

public class LoanRepayment {
    static long n;
    static long k;
    static long m;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("loan.in")));
        PrintWriter out = new PrintWriter("loan.out");
        String[] line = in.readLine().split(" ");
        n = Long.parseLong(line[0]);
        k = Long.parseLong(line[1]);
        m = Long.parseLong(line[2]);

        // binary search on x
        long l = 1;
        long r = n / m;
        long x = -1;
        while (l <= r) {
            long mid = l + ((r - l) / 2);
            // System.out.println(mid + "------------------------------" + l + ", " + r);
            if (check(mid)) {
                x = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        out.println(x);

        in.close();
        out.close();
    }

    public static boolean check(long x) {
        long milkOwed = n;
        long days = 1;
        while (days <= k) {
            // System.out.println(days);
            // System.out.println("n: " + milkOwed);
            // System.out.println("n/x: " + Math.max(milkOwed / x, m));
            milkOwed -= Math.max(milkOwed / x, m);
            if (milkOwed < 0) {
                // System.out.println("true");
                return true;
            }

            days++;
        }
        // System.out.println("false");
        return false;
    }
}