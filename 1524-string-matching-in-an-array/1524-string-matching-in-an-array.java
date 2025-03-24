class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word : words){
            for(String Otherword : words){
                if(!word.equals(Otherword) && Otherword.contains(word)){
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }
}