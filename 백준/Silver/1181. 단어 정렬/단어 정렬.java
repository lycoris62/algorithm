import java.util.*;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      Set<String> set = new TreeSet<>();
      for (int i = 0; i < N; i++) {
        set.add(sc.next());
      }

      ArrayList<String> list = new ArrayList<>(set);
      Collections.sort(list, (String s1, String s2) -> s1.length() - s2.length());
      
      for (String string : list) {
        System.out.println(string);
      }
    }
  }
}
