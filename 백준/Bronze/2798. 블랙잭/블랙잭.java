import java.util.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] list = new int[N];
      for (int i = 0; i < N; i++) {
        list[i] = sc.nextInt();
      }
      int max = 0;
      for (int i = 0; i < list.length - 2; i++) {
        for (int j = i + 1; j < list.length - 1; j++) {
          for (int j2 = j + 1; j2 < list.length; j2++) {
            int temp = list[i] + list[j] + list[j2];
            if (temp <= M && max < temp) {
              max = temp;
            }
          }
        }
      }
      System.out.println(max);
    }
  }
}