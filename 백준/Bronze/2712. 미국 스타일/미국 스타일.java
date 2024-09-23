import java.io.*;
import java.util.*;

public class Main extends Exception {
            
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double number = Double.parseDouble(st.nextToken());
            String str = st.nextToken();

            double answerA = 0.0;
            String answerB = "";
            String chagneAnswer = "";

            if (str.equals("kg")) {
                answerB = "lb";
                answerA = number * 2.2046;
                chagneAnswer = String.format("%.4f", answerA);
            } else if (str.equals("l")) {
                answerB = "g";
                answerA = number * 0.2642;
                chagneAnswer = String.format("%.4f", answerA);
            } else if ((str.equals("lb"))) {
                answerB = "kg";
                answerA = number * 0.4536;
                chagneAnswer = String.format("%.4f", answerA);
            } else if (str.equals("g")) {
                answerB = "l";
                answerA = number * 3.7854;
                chagneAnswer = String.format("%.4f", answerA);
            }

            sb.append(chagneAnswer)
                .append(" ")
                .append(answerB)
                .append("\n");
        }

        System.out.println(sb);
    }
}