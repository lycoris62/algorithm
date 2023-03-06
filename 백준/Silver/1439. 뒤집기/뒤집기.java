import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer zeros = new StringTokenizer(str, "1");
        StringTokenizer ones = new StringTokenizer(str, "0");
        System.out.println(Math.min(zeros.countTokens(), ones.countTokens()));
    }
}
