package silver.finished;

import java.util.*;
import java.io.*;

public class FieldReduction {
    static Cow[] cows;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("reduce.in")));
        int n = Integer.parseInt(in.readLine());
        cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            cows[i] = new Cow(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        // get the four cows with the smalles and largest x's and y's
        Arrays.sort(cows, Comparator.comparingInt(c -> c.x));
        int[] smallXFour = { cows[0].x, cows[1].x, cows[2].x, cows[3].x };
        int[] largeXFour = { cows[n - 1].x, cows[n - 2].x, cows[n - 3].x, cows[n - 4].x };

        Arrays.sort(cows, Comparator.comparingInt(c -> c.y));
        int[] smallYFour = { cows[0].y, cows[1].y, cows[2].y, cows[3].y };
        int[] largeYFour = { cows[n - 1].y, cows[n - 2].y, cows[n - 3].y, cows[n - 4].y };

        // loop through all combinations and get min area
        int minArea = Integer.MAX_VALUE;
        for (int smallX : smallXFour) {
            for (int largeX : largeXFour) {
                for (int smallY : smallYFour) {
                    for (int largeY : largeYFour) {
                        if (check(smallX, largeX, smallY, largeY)) {
                            minArea = Math.min(minArea, Math.max((largeX - smallX) * (largeY - smallY), 0));
                            System.out.println((largeX - smallX) * (largeY - smallY));
                        }
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter("reduce.out");
        out.println(minArea);
        in.close();
        out.close();
    }

    public static boolean check(int smallX, int largeX, int smallY, int largeY) {
        int numOutside = 0;
        for (Cow c : cows) {
            if (c.x < smallX || c.x > largeX || c.y < smallY || c.y > largeY) {
                numOutside++;
            }
            if (numOutside > 3) {
                return false;
            }
        }

        return true;
    }

    static class Cow {
        int x, y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}