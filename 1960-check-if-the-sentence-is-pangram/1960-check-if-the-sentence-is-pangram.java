class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for(char ch : sentence.toCharArray()){
            seen[ch - 'a'] = true;
        }
        for(boolean bol : seen){
            if(!bol){
                return false;
            }
        }
        return true;
    }
}