import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Chef> chefList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int totalScore = 0;
            for (int j = 0; j < 4; j++) {
                totalScore += sc.nextInt();
            }

            chefList.add(new Chef(i, totalScore));
        }

        chefList.stream()
            .sorted()
            .limit(1)
            .forEach(chef -> System.out.println(chef.num + " " + chef.totalScore));
    }

    static class Chef implements Comparable<Chef> {

        int num, totalScore;

        public Chef(int num, int totalScore) {
            this.num = num;
            this.totalScore = totalScore;
        }

        @Override
        public int compareTo(Chef o) {
            return Integer.compare(o.totalScore, this.totalScore);
        }
    }
}
