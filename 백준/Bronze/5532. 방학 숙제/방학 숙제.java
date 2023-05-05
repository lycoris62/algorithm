import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int L, A, B, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = stoi(br.readLine());
        A = stoi(br.readLine());
        B = stoi(br.readLine());
        C = stoi(br.readLine());
        D = stoi(br.readLine());

        int korean = A % C > 0 ? A / C + 1 : A / C;
        int math = B % D > 0 ? B / D + 1 : B / D;

        System.out.println(L - Math.max(korean, math));
    }
}