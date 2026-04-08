class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){    //val為節點的值
                tail.next=p1;      //tail只能接節點，所以不能寫p1.val
                p1=p1.next;//當前排完，換下一個
                tail=tail.next;
            }
            else{
                tail.next=p2;
                p2=p2.next;//當前排完，換下一個
                tail=tail.next;
            }
        }
        if (p1 != null) {
        tail.next = p1;   // 整段接上，不要再移動指標
        } 
        else {
            tail.next = p2;   // 整段接上，不要再移動指標
        }
        return dummy.next;
    }
}
