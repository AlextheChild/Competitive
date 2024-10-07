package USACO.silver.finished;

import java.io.*;

public class HoofPaperScissors {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("hps.in")));
        PrintWriter out = new PrintWriter("hps.out");
        int n = Integer.parseInt(in.readLine());
        int[] hPrefix = new int[n + 1];
        int[] pPrefix = new int[n + 1];
        int[] sPrefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hPrefix[i + 1] = hPrefix[i];
            pPrefix[i + 1] = pPrefix[i];
            sPrefix[i + 1] = sPrefix[i];

            switch (in.readLine()) {
                case "H":
                    hPrefix[i + 1] += 1;
                    break;
                case "P":
                    pPrefix[i + 1] += 1;
                    break;
                case "S":
                    sPrefix[i + 1] += 1;
                    break;
            }
        }

        int maxWins = 0;

        for (int i = 1; i <= n; i++) {
            int beforeWins = Math.max(hPrefix[i], Math.max(pPrefix[i], sPrefix[i]));
            int afterWins = Math.max(hPrefix[n] - hPrefix[i],
                    Math.max(pPrefix[n] - pPrefix[i],
                            sPrefix[n] - sPrefix[i]));

            maxWins = Math.max(maxWins, beforeWins + afterWins);
        }

        out.println(maxWins);

        in.close();
        out.close();
    }
}