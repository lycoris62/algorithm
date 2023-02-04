import java.util.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] list = new int[N];
      for (int i = 0; i < list.length; i++) {
        list[i] = sc.nextInt();
      }
      int res = 0;
      for (int i = N-1; i >= 0; i--) {
        res += M / list[i];
        M %= list[i];
        if (M == 0) break;
      }
      System.out.println(res);
    } 
  }
}
