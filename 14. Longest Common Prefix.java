//1
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) return result;
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);  // 每個字串的第 i 個字元
            
            for (int j = 1; j < strs.length; j++) { // j則是代表陣列裡的第幾個字串，第0個字串為標準字串，所以從1開始
                if (i >= strs[j].length() || strs[j].charAt(i) != c)// 如果某字串長度不夠 或 字元不同 → 結束 ;這裡再限制一次字串長度是因為，假如之後字串比第一字串長，會發生StringIndexOutOfBoundsException錯誤
                {
                    return result;
                }
            }            // 代表所有字串第 i 個字一樣 → 加入 result 1 次
            result += c;
        }
        return result;
    }
}

//2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];   //以第一個字串為基礎
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); //這個動作就是把 prefix 最後一個字元刪掉。
                if (prefix.isEmpty()) return "";
            }
        }return prefix;
    }
}
