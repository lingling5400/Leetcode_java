class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){ //i為起點，範圍為:0~nums.length-1
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(sum>max){
                    max=sum;
                }
            }
        }return max;
    }
}
