//未成功
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n){
            return findMedianSortedArrays(nums2, nums1);  //確保nums1長度小於nums2
        }
        
        int left=0;
        int right=m; 
        int mid=(m+n+1)/2; //nums1及nums2全部的中間(確保中間值在左邊最後一個)
        
        while(left<=right){
            int i=(left+right)/2;  //i為nums1中間的切割位置(因為不能出界，所以動較短的陣列)，i的初始位置是在nums1的中間的切割位置
            int j=mid-i; //j為num2s中間的切割位置

            //檢查各個邊界，確認左邊小於右邊
            if(nums1[i-1]>nums2[j]){  
                right=i-1;  //nums1切割位置往左一格
            }

            else if(nums2[j-1] > nums1[i]){
                left=i+1;   //nums1切割位置往右一格
            }

            else{
                int leftMax;  //紀錄最大的左邊
                int rightMin; //紀錄最小的右邊

                if (i == 0){
                    leftMax = nums2[j-1];
                } 
                else if(j == 0){
                    leftMax = nums1[i-1];
                } 
                else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                
                if (i == m) {
                    rightMin = nums2[j];
                }
                else if (j == n) {
                    rightMin = nums1[i];
                }
                else{
                    rightMin = Math.min(nums1[i], nums2[j]);
                } 

                return (rightMin+leftMax)/2;
            }
        }
        return 
    }
}
