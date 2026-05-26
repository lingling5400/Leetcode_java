class Solution { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n){
            return findMedianSortedArrays(nums2, nums1);  //確保nums1長度小於nums2
        }

        int left = 0;
        int right = m;
        int mid = (m + n + 1) / 2;  //nums1及nums2全部的中間(確保中間值在左邊最後一個)

        while (left <= right){

            int i = (left + right) / 2;   //i為nums1中間的切割位置(因為不能出界，所以動較短的陣列)，i的初始位置是在nums1的中間的切割位置
            int j=mid-i;                  //j為num2s中間的切割位置

            // SAFE VERSION
            int left1  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];  //如果 i 在最左邊 → 左邊沒有東西 → 當作 -∞ 否則 → 正常取 nums1[i-1]
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            /*如果 (i == 0)
            left1 = Integer.MIN_VALUE
            否則
            left1 = nums1[i - 1]*/

            // binary search 判斷
            if (left1 > right2){
                right = i - 1;  //nums1切割位置往左一格
            }
            else if (left2 > right1){
                left = i + 1; //nums1切割位置往右一格
            }
            else{
                int leftMax = Math.max(left1, left2);    //紀錄最大的左邊
                int rightMin = Math.min(right1, right2); //紀錄最小的右邊
                
                if ((m + n) % 2 == 1){
                    return leftMax;
                }
                return (leftMax + rightMin) / 2.0; //除整數（小數會被砍掉）
            }
        }

        throw new RuntimeException();  
    }
}
