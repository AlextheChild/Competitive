package USACO.silver.finished;

import java.util.*;
import java.io.*;

public class SleepyCowHerding {
    static int n;
    static int[] cowPositions;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("herding.in")));
        PrintWriter out = new PrintWriter("herding.out");
        n = Integer.parseInt(in.readLine());
        cowPositions = new int[n];
        for (int i = 0; i < n; i++) {
            cowPositions[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(cowPositions);

        out.println(solveMin());
        out.println(solveMax());

        in.close();
        out.close();
    }

    // length n window with the least gaps
    public static int solveMin() {
        // special case
        if ((cowPositions[n - 2] - cowPositions[0] == n - 2 && cowPositions[n - 1] - cowPositions[n - 2] > 2)
                || (cowPositions[n - 1] - cowPositions[1] == n - 2 && cowPositions[1] - cowPositions[0] > 2)) {
            return 2;
        }

        int minSpaces = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // find how many cows are less than n away from cow i
            int j = i;
            while ((j + 1 < n) && (cowPositions[j + 1] - cowPositions[i] + 1 <= n)) {
                j++;
            }
            int spaces = n - (j - i + 1);
            minSpaces = Math.min(minSpaces, spaces);
        }
        return minSpaces;
    }

    // total gap minus either the first or last gap
    public static int solveMax() {
        int numTotalSpaces = cowPositions[n - 1] - cowPositions[0] + 1 - n;
        return Math.max(numTotalSpaces - (cowPositions[1] - cowPositions[0] - 1),
                numTotalSpaces - (cowPositions[n - 1] - cowPositions[n - 2] - 1));
    }
}