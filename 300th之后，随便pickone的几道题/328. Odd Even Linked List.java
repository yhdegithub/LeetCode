import java.util.*;

class Solution {
    public ListNode oddEvenList(ListNode head) {
          if(head==null || head.next==null)
              return head;
          //奇数 偶数结点分开
        ListNode dummy1 = new ListNode(-100);
        ListNode dummy2 = new ListNode(-100);
        ListNode tail1 = dummy1  , tail2 = dummy2;
        ListNode cur = head;
        int num =0;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = null;
            num++;
            if((num&1)==1){
              tail1.next = cur;
              tail1 = cur;
            }else{
                tail2.next = cur;
                tail2 = cur;
            }
        cur = tmp;
        }
       tail1.next = dummy2.next;

        return dummy1.next;
    }

    public ListNode build(int a[]) {
        int n = a.length;
        ListNode dummy = new ListNode(-99), tail = dummy;
        for (int i = 0; i < n; i++) {
            ListNode t = new ListNode(a[i]);
            tail.next = t;
            tail = t;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = s.build(a);
        s.oddEvenList(head);
    }
}