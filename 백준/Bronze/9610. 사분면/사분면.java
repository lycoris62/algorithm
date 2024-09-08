import java.io.*;
import java.util.*;

public class Main extends Exception {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int axis = 0;

        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                axis++;
            }

            if (x > 0 && y > 0) {
                one++;
            } else if(x > 0 && y < 0) {
                four++;
            } else if(x < 0 && y < 0) {
                three++;
            } else if(x < 0 && y > 0) {
                two++;
            }
        }

        sb.append("Q1: ").append(one).append("\n")
            .append("Q2: ").append(two).append("\n")
            .append("Q3: ").append(three).append("\n")
            .append("Q4: ").append(four).append("\n")
            .append("AXIS: ").append(axis);

        System.out.println(sb);
    }
}