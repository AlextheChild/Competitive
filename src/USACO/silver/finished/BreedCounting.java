package USACO.silver.finished;

import java.io.*;

public class BreedCounting {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("bcount.in")));
        PrintWriter out = new PrintWriter("bcount.out");
        String[] nq = in.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        int[] hPrefix = new int[n + 1];
        int[] gPrefix = new int[n + 1];
        int[] jPrefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            switch (Integer.parseInt(in.readLine())) {
                case 1:
                    hPrefix[i + 1] = hPrefix[i] + 1;
                    gPrefix[i + 1] = gPrefix[i];
                    jPrefix[i + 1] = jPrefix[i];
                    break;
                case 2:
                    hPrefix[i + 1] = hPrefix[i];
                    gPrefix[i + 1] = gPrefix[i] + 1;
                    jPrefix[i + 1] = jPrefix[i];
                    break;
                case 3:
                    hPrefix[i + 1] = hPrefix[i];
                    gPrefix[i + 1] = gPrefix[i];
                    jPrefix[i + 1] = jPrefix[i] + 1;
                    break;
            }
        }

        for (int i = 0; i < q; i++) {
            String[] line = in.readLine().split(" ");
            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]);

            int h = hPrefix[end] - hPrefix[start];
            int g = gPrefix[end] - gPrefix[start];
            int j = jPrefix[end] - jPrefix[start];
            out.println(h + " " + g + " " + j);
        }

        in.close();
        out.close();
    }
}