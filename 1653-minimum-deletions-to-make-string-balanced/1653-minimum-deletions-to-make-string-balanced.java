class Solution {
    public int minimumDeletions(String s) {
        int result = 0;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a'){
                result = Math.min(result+1,count);
            }
            else{
                count++;
            }
        }
        return result;
    }
}