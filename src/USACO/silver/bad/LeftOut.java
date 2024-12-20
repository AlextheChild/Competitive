package USACO.silver.bad;

import java.io.*;

public class LeftOut {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("leftout.in")));
        PrintWriter out = new PrintWriter("leftout.out");
        int n = Integer.parseInt(in.readLine());
        boolean[][] pasture = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split("");
            for (int j = 0; j < n; j++) {
                pasture[i][j] = line[j].equals("L");
            }
        }

        // flip left column to false
        for (int i = 0; i < n; i++) {
            if (pasture[i][0]) {
                for (int j = 0; j < n; j++) {
                    pasture[i][j] = !pasture[i][j];
                }
            }
        }

        // flip top row to false
        for (int i = 0; i < n; i++) {
            if (pasture[0][i]) {
                for (int j = 0; j < n; j++) {
                    pasture[j][i] = !pasture[j][i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pasture[j][i] ? 1 : 0);
            }
            System.out.println();
        }

        out.println();

        in.close();
        out.close();
    }
}