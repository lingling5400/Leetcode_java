/*
Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.
You may assume that each input would have ***exactly* one solution**, and you may not use the *same* element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
---------------------------------------------------------------

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
---------------------------------------------------------------

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
---------------------------------------------------------------
*/

//1
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length; i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }return new int[]{-1,-1};   //不會到這裡 (題目保證有答案)
    }
}


//2
import java.util.HashMap; //使用雜湊函數

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 宣告一個 HashMap，key: 數值, value: 索引
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 算出需要的另一個數字
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // 找到答案
            }
            map.put(nums[i], i); // 將當前數字放入 HashMap,如果 complement 沒找到，就把當前值存入 HashMap，之後可能會被別的 complement 用到。第一個是存key = 數字，第二個是存value = 索引
        }
        return new int[]{}; // 不會到這裡 (題目保證有答案)
    }
}
