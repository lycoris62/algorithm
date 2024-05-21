import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int firstIdx, secondIdx, maxCount;
    static List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words = words.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < N - 1; i++) {
            String firstWord = words.get(i);

            for (int j = i + 1; j < N; j++) {
                String secondWord = words.get(j);
                int count = 0;

                for (int k = 0; k < Math.min(firstWord.length(), secondWord.length()); k++) {
                    if (firstWord.charAt(k) != secondWord.charAt(k)) {
                        break;
                    }
                    count++;
                }

                if (maxCount < count) {
                    maxCount = count;
                    firstIdx = i;
                    secondIdx = j;
                }
            }
        }

        System.out.println(words.get(firstIdx));
        System.out.println(words.get(secondIdx));
    }
}
