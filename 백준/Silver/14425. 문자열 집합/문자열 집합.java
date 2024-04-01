import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, ans;
    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            stringList.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (stringList.contains(br.readLine())) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
