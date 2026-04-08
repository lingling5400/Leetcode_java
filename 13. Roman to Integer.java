class Solution {
    public int romanToInt(String s) {
        int result = 0;                  //儲存轉換的數字和
        int i = 0;                       //i為索引值
        
        while (i < s.length()) {         //當i小於字串長度繼續
            int current = value(s.charAt(i));   //當前的字串轉方法規則內的數值
	            int next = 0;      //不可以放進for迴圈外，不然next不會更新，會出錯
            /*String s = "MCM";
							s.charAt(0) → 'M'
							s.charAt(1) → 'C'
							s.charAt(2) → 'M'*/
            
            if (i + 1 < s.length()) {    // 確保不會越界，越界會出現StringIndexOutOfBoundsException（字串越界錯誤）錯誤
                next = value(s.charAt(i + 1));
            }
            
            if (next > current) {// 減法情況
                result += (next - current);//因為羅馬數字減法規則為:一定是「小的在前，大的在後」
                i += 2;
            } else {
                // 一般加法
                result += current;
                i++;
            }
        }
        
        return result;
    }

    public int value(char c) { //方法名稱叫value，接收char c，然後switch再根據c的狀況
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
