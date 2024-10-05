import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, count, prevTime;
    static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (prevTime <= meeting.start) {
                prevTime = meeting.end;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {

        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }

            return Integer.compare(this.end, o.end);
        }
    }
}
