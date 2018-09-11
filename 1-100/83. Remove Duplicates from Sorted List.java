
public class Solution {
   public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next;
        while(cur!=null){
            if(cur.val != pre.val){
                pre = cur;
                cur = cur.next;
            }else{
                pre.next = cur.next;
                cur = pre.next;

            }
        }

        return head;
    }
}