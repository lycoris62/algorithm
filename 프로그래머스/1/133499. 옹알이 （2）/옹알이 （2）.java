class Solution {
    
    String[] availableWords = { "aya", "ye", "woo", "ma" };
    String[] canNotSpeakableWords = { "ayaaya", "yeye", "woowoo", "mama" };
    
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
        for (String canNotSpeakableWord : canNotSpeakableWords) {
            if (word.contains(canNotSpeakableWord)) {
                return false;
            }
        }
        
        for (String availableWord : availableWords) {
            word = word.replace(availableWord, " ");
        }
        
        word = word.replace(" ", "");
        
        return word.length() == 0; 
    }
}