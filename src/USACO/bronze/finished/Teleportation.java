package USACO.bronze.finished;

import java.io.*;

public class Teleportation {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("teleport.in")));
        PrintWriter out = new PrintWriter("teleport.out");
        String[] line = in.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);
        int y = Integer.parseInt(line[3]);

        int dist = Math.abs(a - b);
        dist = Math.min(dist, Math.abs(a - x) + Math.abs(b - y));
        dist = Math.min(dist, Math.abs(a - y) + Math.abs(b - x));

        out.println(dist);

        in.close();
        out.close();
    }
}