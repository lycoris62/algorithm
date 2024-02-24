import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Double> scores = Map.of(
        "A+", 4.5,
        "A0", 4.0,
        "B+", 3.5,
        "B0", 3.0,
        "C+", 2.5,
        "C0", 2.0,
        "D+", 1.5,
        "D0", 1.0,
        "F", 0.0
    );
    static double totalTime = 0.0;
    static double totalScore = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            String lecture = sc.next();
            double time = sc.nextDouble();
            String score = sc.next();

            if (score.equals("P")) {
                continue;
            }

            totalTime += time;
            totalScore += scores.get(score) * time;
        }

        double ans = totalScore / totalTime;
        System.out.println(ans);
    }
}
