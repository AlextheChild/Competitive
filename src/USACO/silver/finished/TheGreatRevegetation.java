package USACO.silver.finished;

import java.util.*;
import java.io.*;

public class TheGreatRevegetation {
    static ArrayList<Edge>[] edgeList;
    static int[] type;

    static boolean impossible = false;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("revegetate.in")));
        PrintWriter out = new PrintWriter("revegetate.out");
        String[] nmLine = in.readLine().split(" ");
        int n = Integer.parseInt(nmLine[0]);
        int m = Integer.parseInt(nmLine[1]);
        edgeList = new ArrayList[n];
        type = new int[n];

        edgeList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < m; i++) {
            String[] line = in.readLine().split(" ");
            String relation = line[0];
            int from = Integer.parseInt(line[1]) - 1;
            int to = Integer.parseInt(line[2]) - 1;

            edgeList[from].add(new Edge(to, relation.equals("S")));
            edgeList[to].add(new Edge(from, relation.equals("S")));
        }

        int numGroups = 0;
        for (int i = 0; i < n; i++) {
            if (type[i] == 0) {
                DFS(i, 1);
                numGroups++;
            }
        }

        if (impossible) {
            out.print(0);
        } else {
            out.print(1);
            for (int i = 0; i < numGroups; i++) {
                out.print(0);
            }
        }

        in.close();
        out.close();
    }

    public static void DFS(int i, int color) {
        type[i] = color;

        for (Edge e : edgeList[i]) {
            if (e.same) {
                if (type[e.to] == 0) {
                    DFS(e.to, color);
                }
                if (type[e.to] == 3 - color) {
                    impossible = true;
                }
            } else {
                if (type[e.to] == 0) {
                    DFS(e.to, 3 - color);
                }
                if (type[e.to] == color) {
                    impossible = true;
                }
            }
        }
    }

    static class Edge {
        int to;
        boolean same;

        public Edge(int to, boolean same) {
            this.to = to;
            this.same = same;
        }
    }
}