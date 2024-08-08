import java.io.*;

public class OldTemplate {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File("file.in")));
        PrintWriter out = new PrintWriter("file.out");
        in.readLine();

        out.println();

        in.close();
        out.close();
    }
}