import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int L;
    static String ads;
    static int[] table;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = stoi(st.nextToken());
        ads = br.readLine();

        table = new int[L];
        
        makeTable();

        // 가능한 광고 중 가장 짧은 길이 -> L보다 작거나 같음
        // 주어진 광고판에서 가장 긴 접두사/접미사 -> 연속적인 광고에서 겹치는 부분 -> 전체 길이에서 최장길이 접두/미사 길이 빼면 광고길이
        // table : i위치까지 가장 긴 접두/미사 길이 -> L - 1 위치(광고판 끝)에서 가장 긴 접두/미사를 광고판 길이에서 빼기
        System.out.println(L - table[L - 1]);
    }

    static void makeTable() {
        int idx = 0;
        for (int i = 1; i < L; i++) {
            while (idx > 0 && (ads.charAt(i) != ads.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (ads.charAt(i) == ads.charAt(idx)) {
                table[i] = ++idx;
            }
        }
    }
}
