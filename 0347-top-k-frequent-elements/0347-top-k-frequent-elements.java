class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int num : nums){
            hp.put(num,hp.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>(hp.keySet());
        list.sort((a,b) -> hp.get(b) - hp.get(a));
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}