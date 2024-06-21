import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static int N;
    static List<Person> people = new ArrayList<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = stoi(st.nextToken());
            int month = stoi(st.nextToken());
            int year = stoi(st.nextToken());

            LocalDate date = LocalDate.of(year, month, day);

            people.add(new Person(name, date));
        }

        Collections.sort(people);

        System.out.println(people.get(people.size() - 1).name);
        System.out.println(people.get(0).name);
    }

    static class Person implements Comparable<Person> {

        String name;
        LocalDate date;

        public Person(String name, LocalDate date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public int compareTo(Person o) {
            return date.compareTo(o.date);
        }
    }
}
