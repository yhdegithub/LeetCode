import java.util.*;

class Solution {
    ListNode res[];
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len =0;

        ListNode cur = root,tmp =null;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        int m = len/k;
        int n = len%k;
        res = new ListNode[k];
        cur = root;
        for(int i=0;i<k;i++){
            if(cur==null){
                res[i] =null;
                continue;
            }
            res[i] = cur;
            if(i<n){
                cur = move(cur,m);
                tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }else{
                cur = move(cur,m-1);
                tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }
        }


        return res;
    }
    //向前走k步
    public ListNode move(ListNode head,int k){
        for(int i=0;i<k;i++)
            head = head.next;
        return head;
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
        int a[] = {1, 2};
        ListNode head = s.build(a);
      int k =4;
      s.splitListToParts(head,k);
    }
}