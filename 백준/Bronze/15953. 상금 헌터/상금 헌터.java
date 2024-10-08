import java.io.*;
import java.util.*;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int money = 0;

            if (first == 0) {
                money += 0;
            } else {
                if (first == 1) {
                    money += 5000000;
                } else if (first <= 3) {
                    money += 3000000;
                } else if (first <= 6) {
                    money += 2000000;
                } else if (first <= 10) {
                    money += 500000;
                } else if (first <= 15) {
                    money += 300000;
                } else if (first <= 21) {
                    money += 100000;
                } else {
                    money += 0;
                }
            }

            if (second == 0) {
                money += 0;
            } else {
                if (second == 1) {
                    money += 5120000;
                } else if (second <= 3) {
                    money += 2560000;
                } else if (second <= 7) {
                    money += 1280000;
                } else if (second <= 15) {
                    money += 640000;
                } else if (second <= 31) {
                    money += 320000;
                } else {
                    money += 0;
                }
            }

            sb.append(money).append("\n");
        }

        System.out.println(sb);
    }
}