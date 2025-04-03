class Solution {
    public int countAsterisks(String s) {
        boolean insider = false;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '|'){
                insider = !insider;
            }
            else if(ch == '*' && !insider){
                count++;
            }
        }
        return count;
    }
}