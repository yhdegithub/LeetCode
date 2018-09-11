
public class Solution {
    //删除所有重复出现过的节点
    public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null)
                return head;
            //只有两个节点
            if(head.next.next==null){
                if(head.val==head.next.val)
                    return null;
                else
                    return head;
            }
            //至少有三个节点了
        ListNode duummy = new ListNode(head.val -1);
            duummy.next = head;
        ListNode  pre = duummy , cur = head, sub = cur.next;
        while(sub!=null){
            if(cur.val != sub.val){
                pre = cur;
                cur = sub;
                sub = sub.next;
            }else{
                while(sub!=null && sub.val == cur.val)
                    sub = sub.next;
                     cur = sub ;
                     pre.next = cur;
                     if(sub!=null)
                         sub= sub.next;
            }
        }
            return duummy.next;
    }
}