package p1436;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        int num = 666;

        while (true) {
            int cnt = 0;
            char[] nums = String.valueOf(num).toCharArray();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == '6') cnt++;
                else cnt = 0;
                if (cnt >= 3) break;
            }

            if (cnt == 3) res++;
            if (res == N) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
