package USACO.silver.bad;
import java.io.*;

public class FarmerJohnsFavoriteOperation {
    public static void main(String[] args) throws Exception {
        // BufferedReader in = new BufferedReader(new FileReader(new File("file.in")));
        // PrintWriter out = new PrintWriter("file.out");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String[] nm = in.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] line = in.readLine().split(" ");   
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(line[i]) % m;
            }

            // for(int i = 0; i<n; i++){
            //     System.out.print(a[i] + " ");
            // }System.out.println();

            int minOperations = Integer.MAX_VALUE;
            for (int x = 0; x <= m; x++) { // O(n * m) // ! way too slow
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int temp = Math.abs(a[i] - x);
                    sum += Math.min(temp, m-temp);
                }
                // System.out.println(sum);
                minOperations = Math.min(sum, minOperations);
            }
            System.out.println(minOperations);
        }

        // in.close();
        // out.close();
    }
}