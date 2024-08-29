package USACO.silver.finished;

import java.io.*;

public class WormholeSort {
    static int n;
    static int[] cows;
    static int[][] wormholes;

    static int[] parents;

    // cows can be sorted if every cow is connected to where they should be

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("wormsort.in")));
        String[] nm = in.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] cowLine = in.readLine().split(" ");
        cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(cowLine[i]) - 1;
        }
        wormholes = new int[m][3];
        int maxWidth = 0;
        for (int i = 0; i < m; i++) {
            String[] line = in.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;
            int width = Integer.parseInt(line[2]);

            int[] wormhole = { from, to, width };
            wormholes[i] = wormhole;

            maxWidth = Math.max(maxWidth, width);
        }

        // binary search on width
        int l = 0;
        int r = maxWidth;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        PrintWriter out = new PrintWriter("wormsort.out");
        out.println(l - 1 == maxWidth ? -1 : l - 1);
        in.close();
        out.close();
    }

    // use dsu to check if everything is connected
    public static boolean check(int width) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // connect everything
        for (int[] w : wormholes) {
            if (w[2] >= width) {
                union(w[0], w[1]);
            }
        }

        // check if the parents are all the same
        for (int c = 0; c < n; c++) {
            if (find(c) != find(cows[c])) {
                return false;
            }
        }

        return true;
    }

    public static int find(int node) {
        if (parents[node] == node) {
            return node;
        } else {
            return parents[node] = find(parents[node]);
        }
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parents[parentB] = parentA;
        }
    }
}