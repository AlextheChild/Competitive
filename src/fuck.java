import java.io.*;
import java.util.*;

public class fuck {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("wormsort");

        int cowNum = io.nextInt();
        int wormholeNum = io.nextInt();

        int[] cows = new int[cowNum];
        for (int c = 0; c < cowNum; c++) {
            cows[c] = io.nextInt() - 1;
        }

        int maxWidth = 0;
        List<int[]> wormholes = new ArrayList<>();
        for (int w = 0; w < wormholeNum; w++) {
            wormholes.add(
                    new int[] { io.nextInt() - 1, io.nextInt() - 1, io.nextInt() });
            maxWidth = Math.max(maxWidth, wormholes.get(w)[2]);
        }

        int lo = 0;
        int hi = maxWidth + 1;
        int valid = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            DSU dsu = new DSU(cowNum);
            for (int[] w : wormholes) {
                if (w[2] >= mid) {
                    dsu.link(w[0], w[1]);
                }
            }

            boolean sortable = true;
            for (int c = 0; c < cowNum; c++) {
                if (dsu.getTop(c) != dsu.getTop(cows[c])) {
                    sortable = false;
                    break;
                }
            }

            if (sortable) {
                valid = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        io.println(valid == maxWidth + 1 ? -1 : valid);
        io.close();
    }

    // BeginCodeSnip{Kattio}
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    // EndCodeSnip
}

// BeginCodeSnip{DSU}
class DSU {
    private final int[] parent;
    private final int[] size;

    public DSU(int size) {
        parent = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int getTop(int n) {
        return parent[n] == n ? n : (parent[n] = getTop(parent[n]));
    }

    public boolean link(int e1, int e2) {
        e1 = getTop(e1);
        e2 = getTop(e2);
        if (e1 == e2) {
            return false;
        }
        if (size[e2] > size[e1]) {
            return link(e2, e1);
        }
        parent[e2] = e1;
        size[e1] += size[e2];
        return true;
    }
}
// EndCodeSnip