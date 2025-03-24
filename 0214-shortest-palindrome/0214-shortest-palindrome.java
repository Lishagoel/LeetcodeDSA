class Solution {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int length = 0;
        for(int i=s.length();i>=0;i--){
            if(s.substring(0,i).equals(reverse.substring(s.length()-i))){
                length = i;
                break;
            }
        }
        return reverse.substring(0,s.length()-length)+s;
    }
}