import java.io.*;
import java.util.ArrayList;

public class Deforestation {
    public static void main(String[] args) throws Exception {
        // ! I don't know how to do this casework
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(new File("forest.in")));
        PrintWriter out = new PrintWriter("forest.out");
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            System.out.println("TIME : ");
            String[] nk = in.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            in.readLine();
            ArrayList<K> kList = new ArrayList<K>();
            for (int i = 0; i < k; i++) {
                String[] line = in.readLine().split(" ");
                kList.add(new K(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            }

            // merge ks
            while (kList.size() > 1) {
                System.out.println("WHILE : ");
                for (K kObject : kList) {
                    System.out.print(kObject.l + ", " + kObject.r + ", " + kObject.t);
                    System.out.println();
                }

                K k0 = kList.get(0);
                K k1 = kList.get(1);

                K newK = new K(0, 0, 0);
                newK.l = Math.min(k0.l, k1.l);
                newK.r = Math.max(k0.r, k1.r);

                int overlap = 0;
                if (k0.r < k1.l || k0.l > k1.r) {
                    continue;
                } else {
                    overlap = Math.min(k0.r, k1.r) - Math.max(k0.l, k1.l) + 1;
                }
                System.out.println("overlap: " + overlap);
                newK.t = k0.t + k1.t - overlap;

                kList.remove(0);
                kList.remove(0);
                kList.add(newK);
            }

            for (K kObject : kList) {
                System.out.print(kObject.l + ", " + kObject.r + ", " + kObject.t);
                System.out.println();
            }

            out.println(n - kList.get(0).t);
        }
        in.close();
        out.close();
    }

    static class K {
        int l, r, t;

        public K(int l, int r, int t) {
            this.l = l;
            this.r = r;
            this.t = t;
        }
    }
}