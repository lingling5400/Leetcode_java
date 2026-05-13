//1
class Solution {
    public int singleNumber(int[] nums) {
        //[2,2,1], return 1;
        //[4,1,2,1,2], return 4;
       
        for (int i=0; i<nums.length ; i++){
            System.out.print(nums[i]);
            int count =0;
            for(int j=0; j<nums.length; j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
            if(count == 1){
            return nums[i];
        }
        }
        return -1;
    } 
}
//runtime=ixj次 為O(numsSize^2)
