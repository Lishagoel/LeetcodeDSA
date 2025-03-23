class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> hp = new HashMap<>();
        for(char ch : s.toCharArray()){
            hp.put(ch,hp.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!hp.containsKey(ch)){
                hp.remove(ch);
            }
            hp.put(ch,hp.getOrDefault(ch,0)-1);
            if(hp.get(ch) == 0){
                hp.remove(ch);
            }
        }
        return hp.isEmpty();
    }
}