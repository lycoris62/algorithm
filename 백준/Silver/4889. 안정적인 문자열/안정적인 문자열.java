import java.util.*;

public class Main {

    static int N = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.contains("-")) {
                break;
            }

            sb.append(N++).append(". ").append(sol(str)).append("\n");
        }

        System.out.println(sb);
    }

    static int sol(String str) {
        // 스택으로 안정적인 문자열 체크
        // 불안정 하다면, 그 부분을 안정으로 (}는{로, {는 }로) 변경.

        Stack<Character> stack = new Stack<>(); // Deque 가 성능이 더 좋지만, 메서드가 스택과 안 맞음
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '{') { // { 시작은 스택에 그냥 넣기.
                stack.push(ch);
                continue;
            }

            // 이후는 } 만난 경우
            if (stack.isEmpty()) { // {} 짝 지어야 하는데 {가 없음
                count++;
                stack.push('{');
            } else {
                // 스택에는 { 밖에 없음. 따라서 스택이 비지 않으면 {} 쌍을 맞춘 것.
                stack.pop();
            }
        }

        count += stack.size() / 2; // 스택에 남았다면, { 가 짝수로 남았으니 이 중 절반을 } 로 변경
        return count;
    }

    // 1. } 만났는데 스택 빈 경우 -> }를 {로 변경한 후 스택에 넣기.
    // 2. } 만났는데 스택 peek 이 {가 아닌 경우 -> peek 을 {로 변경. or
    // ㄴ 가 있을 수 있나?? {가 아니면 }인데 }는 스택에 안 넣잖아. 바보야
    // 3. 스택이 끝났는데 {{{... 밖에 없는 경우 -> {는 짝수밖에 남을 수밖에 없으니 그 절반만 변경
}
