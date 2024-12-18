package USACO.bronze.finished;

import java.util.*;
import java.io.*;

public class CowEvolution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("evolution.in")));
        PrintWriter out = new PrintWriter("evolution.out");
        int n = Integer.parseInt(in.readLine());
        ArrayList<HashSet<String>> cows = new ArrayList<HashSet<String>>();
        HashSet<String> traitSet = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            HashSet<String> currentCow = new HashSet<String>();
            for (int j = 0; j < k; j++) {
                currentCow.add(line[j + 1]);
            }
            cows.add(currentCow);
            traitSet.addAll(currentCow);
        }

        ArrayList<String> traits = new ArrayList<>(traitSet);

        for (int i = 0; i < traits.size(); i++) {
            for (int j = i + 1; j < traits.size(); j++) {
                // if the set contains two traits that are found apart from each other and also
                // with each other, then it is nonproper

                boolean both = false, onlyA = false, onlyB = false;
                for (HashSet<String> c : cows) {
                    boolean hasA = c.contains(traits.get(i));
                    boolean hasB = c.contains(traits.get(j));

                    if (hasA && hasB) {
                        both = true;
                    } else if (hasA && !hasB) {
                        onlyA = true;
                    } else if (!hasA && hasB) {
                        onlyB = true;
                    }
                }

                if (onlyA && onlyB && both) {
                    out.println("no");
                    in.close();
                    out.close();
                    System.exit(0);
                }
            }
        }

        out.println("yes");

        in.close();
        out.close();
    }
}