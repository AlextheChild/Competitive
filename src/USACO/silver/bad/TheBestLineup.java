package USACO.silver.bad;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class TheBestLineup {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("file.in")));
        PrintWriter out = new PrintWriter("file.out");
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] aList = in.readLine().split(" ");
            int[] a = new int[n];
            Integer[] aSorted = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aList[i]);
                aSorted[i] = Integer.parseInt(aList[i]);
            }
            // boolean moved = false;

            Arrays.sort(aSorted, Collections.reverseOrder());

            
        }

        // 1234
        // sort in descending order
        // 4321
        // for each number, check if it has to be moved (earlier ones have priority) or can be moved (can only move in front)
        // moved = true (4)
        // therefore no more moves are allowed
        // now, check each number whether or not it could have made it in that order


        // System.out.println();
        in.close();
        out.close();
    }
}