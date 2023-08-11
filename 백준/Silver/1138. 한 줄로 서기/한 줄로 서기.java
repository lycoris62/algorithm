import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        IntStream.range(0, N).forEach(i -> arr[i] = sc.nextInt());

        List<Integer> list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            list.add(arr[i], i + 1);
        }

        list.forEach(x -> System.out.print(x + " "));
    }
}
