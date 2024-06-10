import java.io.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, length;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = stoi(br.readLine());

            if (N == 0) {
                break;
            }

            length = 2;
            String str = String.valueOf(N);

            length += str.length() - 1;

            for (char ch : str.toCharArray()) {
                if (ch == '1') {
                    length += 2;
                } else if (ch == '0') {
                    length += 4;
                } else {
                    length += 3;
                }
            }

            sb.append(length).append("\n");
        }

        System.out.println(sb);
    }
}
