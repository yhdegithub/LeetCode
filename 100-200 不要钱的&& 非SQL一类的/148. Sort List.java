
import java.util.*;
class Solution {
    //二分归并
    public ListNode sortList(ListNode head) {
         if(head==null || head.next == null)
             return head;
         ListNode mid = getMid(head);
         ListNode r = sortList(mid.next);
         if(mid!=null)
         mid.next = null;
         ListNode l = sortList(head);
         ListNode res = Merge(l,r);
         return res;
    }
    //合并
    public ListNode Merge(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<=l2.val){
            l1.next = Merge(l1.next,l2);
            return l1;
        }else{
            l2.next = Merge(l1,l2.next);
            return l2;
        }
    }
    //找到中间值
    public ListNode getMid(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode slow =head,fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }

    //建立链表
    public ListNode buildList(int a[]){
        int n=a.length;
        ListNode dummy = new ListNode(-1);
        ListNode tail =dummy;
        for(int i=0;i<n;i++){
            ListNode t = new ListNode(a[i]);
            tail.next = t;
            tail = t;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        int a[] ={-1,5,3,4,0};
        Solution s = new Solution();
        ListNode head = s.buildList(a);
       ListNode res = s.sortList(head);
    }
}