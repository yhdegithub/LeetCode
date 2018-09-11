import java.util.*;
//比较水的题 。
class Solution {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        if(L1==null)
            return L2;
        if(L2==null)
            return L1;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int c = 0;
        while(L1!=null || L2!=null){
            int sum = (L1 == null ? 0:L1.val) + (L2 == null? 0:L2.val) + c;
            c = sum / 10;
            ListNode node = new ListNode( sum % 10 );
            tail.next = node;
            tail = node;
            if(L1!=null)
                L1 = L1.next;
            if(L2!=null)
                L2 = L2.next;
        }
        if(c!=0)
            tail.next = new ListNode(c);
        return dummy.next;
    }
    public static void main(String args[]){
        ListNode node1 = new ListNode( 2 );ListNode node2 = new ListNode( 4 );ListNode node3 = new ListNode( 3 );
        node1.next = node2; node2.next = node3;
        ListNode node4 = new ListNode( 5 );ListNode node5 = new ListNode( 6 );ListNode node6 = new ListNode( 4 );
        node4.next = node5;node5.next = node6;
        new Solution().addTwoNumbers(node1,node4);
    }
}