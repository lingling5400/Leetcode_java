class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int digit=0;
        int total=0;
        ListNode dummy = new ListNode(0);
        ListNode cur=dummy;
        int v1;
        int v2;
        
        while (l1 != null || l2 != null || carry!=0){
            if (l1 != null){
                v1=l1.val;
            } 
            else{
                v1=0;
            }
            
            if (l2 != null){
                v2=l2.val;
            } 
            else{
                v2=0;
            }
            /*v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0*/
            
            total = v1 + v2 + carry;
            digit = total % 10;  //取餘數
            carry = total / 10; //取商數

            cur.next= new ListNode(digit);
            cur=cur.next;

            if (l1 != null){
                l1= l1.next;
            }
             if (l2 != null){
                l2= l2.next;
            }

        }
    return dummy.next;
        
    }
}


// ===== More clear version =====
/*
int carry = 0;

ListNode dummy = new ListNode(0);
ListNode cur = dummy;

while (l1 != null || l2 != null || carry != 0) {

    int v1 = (l1 != null) ? l1.val : 0;
    int v2 = (l2 != null) ? l2.val : 0;

    int total = v1 + v2 + carry;

    int digit = total % 10;
    carry = total / 10;

    cur.next = new ListNode(digit);
    cur = cur.next;

    if (l1 != null) l1 = l1.next;
    if (l2 != null) l2 = l2.next;
}

return dummy.next;
*/
