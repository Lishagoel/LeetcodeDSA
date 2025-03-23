class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num*num);
        }
        Collections.sort(list);
        int[] result = new int[nums.length];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}