class Solution {
    
    String[] availableWords = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (isSpeakable(word)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isSpeakable(String word) {
        if(word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("mama")) {
            return false;
        }
        
        for (String availableWord : availableWords) {
            word = word.replace(availableWord, " ");
        }
        word = word.replace(" ", "");
        
        return word.length() == 0; 
    }
}