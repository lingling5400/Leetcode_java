
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);   //不同資料型態轉字串
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) { // 初始化多個變數時只寫一次 int
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
