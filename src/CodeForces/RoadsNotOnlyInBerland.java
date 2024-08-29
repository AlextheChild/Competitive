package CodeForces;

import java.util.*;
import java.io.*;

public class RoadsNotOnlyInBerland {
    static int[] parents;
    static ArrayList<int[]> unusedRoads = new ArrayList<int[]>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            String[] line = in.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;

            if (find(from) == find(to)) {
                // already connected
                int[] road = { from, to };
                unusedRoads.add(road);
            } else {
                union(from, to);
            }
        }

        // add better roads
        System.out.println(unusedRoads.size());
        for (int i = 0; i < n; i++) {
            if (find(0) != find(i)) {
                System.out.println("" + (unusedRoads.get(0)[0] + 1) +
                        " " +
                        (unusedRoads.get(0)[1] + 1) +
                        " " + (parents[0] + 1) +
                        " " + (i + 1));
                unusedRoads.remove(0);
                union(0, i);
            }
        }

        in.close();
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