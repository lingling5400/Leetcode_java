//1
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //Stack 是後進先出
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i); 
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); //將所有開括號放進去stack裡
            }
            else{
                if(stack.isEmpty()) return false; //當沒一個開括號時，stack是空的
                char open = stack.pop();          //所有開括號收入stack
                char close =c;                    //所有關括號收入c
                if (!(open == '(' && close == ')') && !(open == '[' && close == ']') && !(open == '{' && close == '}')){
                    //因為本身就有迴圈依依分別將括號放入stackc 和 c，所以直接寫不用在第二個迴圈
                    return false;  
                }
            }
        }return stack.isEmpty();
    }
}

//2

class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack= new Stack<>();
        HashMap <Character,Character> map= new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
                continue;                       //因為continue，所以會先跑完所有i，不會先跑下面流程，這樣能確保expectedOpen有東西，不會空值
            }
            if (stack.isEmpty()) return false;

            char expectedOpen = map.get(c);    // 1.從 map 查詢「這個閉括號 c 應該對應的開括號」 2.如果 c 是開括號，map.get(c) 會是 null（因為 map 裡只有閉括號）3.自動帶入規則

            char actualOpen = stack.pop();       // pop為拿出stack最後 push 的開括號(因為閉括號都放入Map裡所以Stack都是開括號)，並且Stack 用來維持 還沒被匹配的開括號 的順序。
            
            if (expectedOpen != actualOpen){
                return false;
            }
            
        }
         return stack.isEmpty(); 
         /* 等同於:
            if (stack.isEmpty()) return true;
            else return false;*/
    }
}
