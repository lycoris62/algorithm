import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, C;
    static int[] houses;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        houses = new int[N];

        IntStream.range(0, N).forEach(i -> houses[i] = sc.nextInt());
        Arrays.sort(houses);

        int start = 1;
        int end = houses[N - 1] - houses[0] + 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int res = count(mid);

            if (res >= C) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(end - 1);
    }

    static int count(int gap) {
        int cnt = 1;
        int lastLocate = houses[0];

        for (int i = 1; i < houses.length; i++) {
            int locate = houses[i];
            if (locate - lastLocate >= gap) {
                cnt++;
                lastLocate = locate;
            }
        }

        return cnt;
    }
}
