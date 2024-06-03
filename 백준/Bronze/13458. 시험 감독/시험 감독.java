import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long answer;
    static int N, B, C;
    static int[] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        rooms = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rooms[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        answer += N;

        for (int people : rooms) {
            people -= B;

            if (people <= 0) {
                continue;
            }

            answer += people / C;
            if (people % C != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
