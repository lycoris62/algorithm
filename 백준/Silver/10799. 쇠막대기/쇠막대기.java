import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        int res = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(') {
                cnt++;
                continue;
            }

            cnt--;

            if (arr[i - 1] == '(') {
                res += cnt;
            } else {
                res++;
            }
        }

        System.out.println(res);
    }
}
