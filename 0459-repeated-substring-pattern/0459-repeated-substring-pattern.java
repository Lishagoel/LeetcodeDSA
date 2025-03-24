class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String newS = s+s;
        String trimmedS = newS.substring(1,newS.length()-1);
        return trimmedS.contains(s);
    }
}