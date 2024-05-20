import java.util.*;

class Solution {

    public static void main(String[] args) {

    }

    List<Integer> answer = new ArrayList<>();
    Map<String, Integer> genreTotalPlayMap = new HashMap<>();
    Map<String, Map<Integer, Integer>> genreMusicMap = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {

        for (int i = 0; i < plays.length; i++) {
            if (!genreTotalPlayMap.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genreMusicMap.put(genres[i], map);
                genreTotalPlayMap.put(genres[i], plays[i]);
                continue;
            }

            genreMusicMap.get(genres[i]).put(i, plays[i]);
            genreTotalPlayMap.put(genres[i], genreTotalPlayMap.get(genres[i]) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(genreTotalPlayMap.keySet());
        genreList.sort((s1, s2) -> genreTotalPlayMap.get(s2) - genreTotalPlayMap.get(s1));

        for (String genre : genreList) {
            Map<Integer, Integer> musicMap = genreMusicMap.get(genre);
            List<Integer> musicPlayList = new ArrayList<>(musicMap.keySet());

            musicPlayList.stream()
                .sorted((s1, s2) -> musicMap.get(s2) - (musicMap.get(s1)))
                .limit(2)
                .forEach(music -> answer.add(music));
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}