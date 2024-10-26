package USACO.silver.finished;

import java.io.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("paintbarn.in")));
        PrintWriter out = new PrintWriter("paintbarn.out");
        String[] nk = in.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] barn = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            barn[x1][y1]++;
            barn[x1][y2]--;
            barn[x2][y1]--;
            barn[x2][y2]++;
        }

        // for (int x = 0; x < 10; x++) {
        // for (int y = 0; y < 10; y++) {
        // System.out.print((barn[y][x] >= 0 ? ".." : ".") + barn[y][x]);
        // }
        // System.out.println();
        // }

        // System.out.println("-------------------------------------------");

        int good_coats = 0;
        for (int x = 0; x <= 1000; x++) {
            for (int y = 0; y <= 1000; y++) {
                if (x > 0) {
                    barn[x][y] += barn[x - 1][y];
                }
                if (y > 0) {
                    barn[x][y] += barn[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    barn[x][y] -= barn[x - 1][y - 1];
                }
                if (barn[x][y] == k) {
                    good_coats++;
                }
            }
        }

        // for (int x = 0; x < 10; x++) {
        // for (int y = 0; y < 10; y++) {
        // System.out.print((barn[y][x] >= 0 ? ".." : ".") + barn[y][x]);
        // }
        // System.out.println();
        // }

        out.println(good_coats);

        in.close();
        out.close();
    }
}