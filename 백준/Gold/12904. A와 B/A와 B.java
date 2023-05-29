import java.io.*;

public class Main {
    static StringBuffer S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = new StringBuffer(br.readLine());
        T = new StringBuffer(br.readLine());

        while (T.length() > S.length()) {
            boolean isB = T.charAt(T.length() - 1) == 'B';
            T.deleteCharAt(T.length() - 1);
            if (isB) T.reverse();
        }

        System.out.println(S.toString().contentEquals(T) ? 1 : 0);
    }
}
