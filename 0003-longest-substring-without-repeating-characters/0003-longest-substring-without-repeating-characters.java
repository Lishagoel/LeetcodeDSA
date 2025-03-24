class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(set.contains(ch)){
                result = Math.max(result,set.size());
                while(set.contains(ch)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            right++;
        }
        result = Math.max(result,set.size());
        return result;
    }
}