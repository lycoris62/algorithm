import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N, count;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());
        while (T-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = stoi(st.nextToken());
            map = new HashMap<>(N);
            count = 1;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int docRank = stoi(st.nextToken());
                int interviewRank = stoi(st.nextToken());
                map.put(docRank, interviewRank);
            }

            int vot = map.get(1);
            for (int i = 2; i <= N; i++) {
                if (map.get(i) < vot) {
                    vot = map.get(i);
                    count++;
                }
            }
            
            System.out.println(count);
        }
    }
}
