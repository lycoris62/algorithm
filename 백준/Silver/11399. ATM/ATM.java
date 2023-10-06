import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] times = new int[N];
		
		Arrays.setAll(times, i -> sc.nextInt());
		Arrays.sort(times);
		IntStream.range(1, N).forEach(i -> times[i] += times[i - 1]);

		System.out.println(Arrays.stream(times).sum());
	}
}
