class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;
        while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == currentChar){
                count++;
                i++;
            }
            chars[index++] = currentChar;
            if(count > 1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}