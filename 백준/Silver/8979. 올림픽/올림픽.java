import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static List<Country> countryList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Country country = new Country(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
            countryList.add(country);
        }

        Collections.sort(countryList);

        int rank = 1;

        for (int i = 1; i < countryList.size(); i++) {
            Country prevCountry = countryList.get(i - 1);
            Country nowCountry = countryList.get(i);

            if (nowCountry.compareTo(prevCountry) != 0) {
                rank++;
            }

            if (nowCountry.num == K) {
                System.out.println(rank);
                return;
            }
        }
    }

    static class Country implements Comparable<Country> {

        int num, gold, silver, bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return Integer.compare(o.bronze, this.bronze);
                }
                return Integer.compare(o.silver, this.silver);
            }
            return Integer.compare(o.gold, this.gold);
        }
    }
}
