class Solution {
    public int removeDuplicates(int[] nums) {
		    if (nums.length == 0) return 0;
        int k=1; 
        for(int i=0; i+1<nums.length ; i++){  //對應雙指針: i => fast，k => slow
            if(nums[i]!=nums[i+1] ){ 
                nums[k]=nums[i+1]; 
                k+=1; 
            } 
        }return k;
    }
}
