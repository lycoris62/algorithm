import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, resLeft, resRight;
  static int[] arr;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int left = resLeft = 0;
    int right = resRight = N - 1;

    while (left < right) {
      int sum = arr[left] + arr[right];

      if (sum == 0) {
        resLeft = left;
        resRight = right;
        break;
      }

      if (Math.abs(arr[resRight] + arr[resLeft]) > Math.abs(sum)) {
        resRight = right;
        resLeft = left;
      }

      if (sum < 0) left++;
      else right--;
    }

    System.out.println(arr[resLeft] + " " + arr[resRight]);
  }
}
