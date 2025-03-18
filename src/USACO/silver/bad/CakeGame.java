package USACO.silver.bad;
import java.util.*;
import java.io.*;

public class CakeGame {
    public static void main(String[] args) throws Exception {
        // ! no idea what's wrong here
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(new File("cake.in")));
        PrintWriter out = new PrintWriter("cake.out");

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] cakeLine = in.readLine().split(" ");
            ArrayList<Long> cakes = new ArrayList<Long>();
            long totalSize = 0;
            for (int i = 0; i < n; i++) {
                long cakeSize = Long.parseLong(cakeLine[i]);
                cakes.add(cakeSize);
                totalSize += cakeSize;
            }

            long elsieTotal = 0;
            for (int i = 0; i < n / 2 - 1; i++) {
                // for (int c : cakes) {
                // System.out.print(c + ", ");
                // }
                // System.out.println();

                if (cakes.get(0) > cakes.get(cakes.size() - 1)) {
                    elsieTotal += cakes.remove(0);
                } else {
                    elsieTotal += cakes.remove(cakes.size() - 1);
                }
            }

            // for (int c : cakes) {
            // System.out.print(c + ", ");
            // }
            // System.out.println();

            long bessieTotal = totalSize - elsieTotal;
            System.out.println(bessieTotal + " " + elsieTotal);
        }

        in.close();
        out.close();
    }
}