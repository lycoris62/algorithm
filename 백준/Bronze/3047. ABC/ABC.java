import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        String s = sc.next();
        Arrays.sort(arr);

        for (int j = 0; j < arr.length; j++) {
            if ('A' == s.charAt(j)) {
                System.out.print(arr[0] + " ");
            } else if ('B' == s.charAt(j)) {
                System.out.print(arr[1] + " ");
            } else if ('C' == s.charAt(j)) {
                System.out.print(arr[2] + " ");
            }
        }

    }
}