import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) { // String to int 함수
        return Integer.parseInt(s);
    }

    static int N; // 입력 개수
    static int[] arr; // 0번부터 N-1번의 학생을 인덱스로 하고, 그 인덱스의 값을 학생이 가리키는 다른 학생 번호로 하는 배열
    static boolean[] visited; // 방문한 학생을 체크하는 배열
    static boolean[] finished; // 방문한 학생들중 싸이클을 계산했었는지 체크하는 배열 
    static int count; // 팀을 이룬 학생을 셈

    public static void main(String[] args) throws IOException {
        // 자바는 입력을 이렇게 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine()); // 테스트 케이스를 한줄 입력 받아서 String to int 로 변환
        for (int i = 0; i < T; i++) { // 각 테스트 케이스만큼 반복문 돌려주기
            N = stoi(br.readLine()); // 한 테스트 케이스 동안 입력으로 오는 학생수 받기.
            arr = new int[N]; // 특정 학생이 가리키는 학생을 값으로 가지는 배열
            visited = new boolean[N]; // 방문 체크
            finished = new boolean[N];
            count = 0; // 0으로 초기화하여 매 테스트 케이스에 독립적.

            // 이 클래스로 자바는 공백을 기준으로 쪼갠다.
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) { // N번만큼 학생이 가리키는 학생번호 입력받기
                arr[j] = stoi(st.nextToken()) - 1;
            }

            for (int j = 0; j < N; j++) { // 각 학생들을 돌아가며 백트래킹 돌리기
                if (!visited[j]) {
                    bt(j);
                }
            }
            // 팀을 못 이룬 학생수를 출력해야하므로, 전체 학생수 - 팀이룬 학생수
            System.out.println(N - count);
        }
    }

    static void bt(int now) { // 백트래킹
        if (visited[now]) return; // 방문 했으면 리턴

        visited[now] = true; // 방문 안 했으면 했다고 체크
        int next = arr[now]; // 그 학생이 가리키는 다른 학생 번호 가져오기

        if (!visited[next]) { // 그 학생도 방문 안 했다면
            bt(next); // 방문
        } else if (!finished[next]) { // 방문 했는데 아직 처리 안 했다면,
            count++;
            // 싸이클의 시작이자 끝부터(next) 계속 가리키는 학생을 돌며 현재 학생(now, 싸이클의 시작과 끝을 가리키는 학생)이 되면 끝.
            for (int i = next; i != now; i = arr[i]) {
                count++;
            }
            // 싸이클을 이루는 학생 수 카운팅.
        }

        finished[now] = true; // 싸이클이 완성된 후, 싸이클 계산이 끝났다는 것을 체크 
    }
}