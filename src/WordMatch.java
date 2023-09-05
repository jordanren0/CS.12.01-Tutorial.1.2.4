public class WordMatch {
    String guess;

    public WordMatch(String guess) {
        this.guess = guess;
    }

    public int scoreGuess(String s){
        if(s.length() == 0) throw new IllegalArgumentException("Your guess cannot be an empty String!");
        if(s.length() > guess.length()) throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        int count = 0;
        for(int i = 0; i < guess.length(); i++){
            if(i+s.length() <= guess.length()){
                String temp = guess.substring(i, i+s.length());
                if(temp.equals(s)) count++;
            }
        }
        return count * s.length() * s.length();

    }
    public String findBetterGuess(String s1, String s2){
        int scoreOne = scoreGuess(s1);
        int scoreTwo = scoreGuess(s2);
        int compare = s1.compareTo(s2);
        if(scoreOne > scoreTwo) return s1;
        else if (scoreOne < scoreTwo) return s2;
        if(compare > 0) return s1;
        return s2;
    }
}
