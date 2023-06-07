import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N, M;
    static int[] A, B;
    static List<Integer> listA = new ArrayList<>(), listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());

        N = stoi(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = stoi(st.nextToken());
        }

        M = stoi(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        System.out.println(getCount());
    }

    static long getCount() {
        long cnt = 0;
        int pointerA = 0;
        int pointerB = listB.size() - 1;

        while (pointerA < listA.size() && pointerB >= 0) {
            long sum = listA.get(pointerA) + listB.get(pointerB);

            if (sum < T) {
                pointerA++;
                continue;
            }

            if (sum > T) {
                pointerB--;
                continue;
            }

            int a = listA.get(pointerA);
            int b = listB.get(pointerB);
            long aCnt = 0;
            long bCnt = 0;

            while (pointerA < listA.size() && listA.get(pointerA) == a) {
                aCnt++;
                pointerA++;
            }

            while (pointerB >= 0 && listB.get(pointerB) == b) {
                bCnt++;
                pointerB--;
            }

            cnt += aCnt * bCnt;
        }

        return cnt;
    }
}
