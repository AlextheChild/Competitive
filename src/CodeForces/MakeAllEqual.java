package CodeForces;

import java.util.*;
import java.io.*;

public class MakeAllEqual {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] aString = in.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aString[i]);
            }

            // count number of happenings for each number
            HashMap<Integer, Integer> numberHappenings = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                if (!numberHappenings.containsKey(a[i])) {
                    numberHappenings.put(a[i], 1);
                } else {
                    numberHappenings.put(a[i], numberHappenings.get(a[i]) + 1);
                }
            }

            // find the number that happens the most
            int maxNumberHappenings = 0;
            for (int i : numberHappenings.keySet()) {
                if (numberHappenings.get(i) > maxNumberHappenings) {
                    maxNumberHappenings = numberHappenings.get(i);
                }
            }

            System.out.println(n - maxNumberHappenings);
        }
    }
}