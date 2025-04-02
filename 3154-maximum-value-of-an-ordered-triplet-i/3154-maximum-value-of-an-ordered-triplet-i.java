class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxValue = 0;
        if(nums.length < 3){
            return 0;
        }
        for(int j=1;j<nums.length-1;j++){
            int leftMax = 0;
            int rightMax = 0;
            for(int i=0;i<j;i++){
                leftMax = Math.max(leftMax,nums[i]);
            }
            for(int k=j+1;k<nums.length;k++){
                rightMax = Math.max(rightMax,nums[k]);
            }
            maxValue = Math.max(maxValue,(long)(leftMax - nums[j])*rightMax);
        }
        return maxValue;
    }
}