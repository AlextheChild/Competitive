import java.util.*;
import java.io.*;

public class IrisAndGameOnTheTree {

    static ArrayList<Edge>[] edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n - 1; i++) {
                String[] line = in.readLine().split(" ");
                int from = Integer.parseInt(line[0]) - 1;
                int to = Integer.parseInt(line[1]) - 1;

                edgeList[from].add(new Edge(to));
                edgeList[to].add(new Edge(from));
            }
        }

        System.out.println();
    }

    static class Edge {
        int to;

        public Edge(int t) {
            to = t;
        }
    }
}