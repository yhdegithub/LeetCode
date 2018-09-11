/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//一次不好写 ，可以把转置k个结点作为一个函数
public class Solution {
    //转置k个结点
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = getLength(head);
        if (n <= 1 || n < k || k == 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, last = pre;
        while (last != null) {
            last = pre;
            for (int i = 0; i <= k; i++) {   // 检查够不够k个结点 ， 以及找到尾巴结点
                if (last == null)
                    return dummy.next;
                last = last.next;
            }

            ListNode tail = reverse(pre, last, k);
            tail.next = last;
            pre = tail;
        }
        return dummy.next;
    }

    //反转中间k个结点,返回尾巴结点
    public ListNode reverse(ListNode pre, ListNode last, int k) {

        if (pre == null)
            return null;
        ListNode p = pre.next, tail = p;
        if (p == null || p.next == null)
            return p;
        ListNode q = p.next, t = q.next;
        for (int i = 1; i < k; i++) {   //原地逆置
            q.next = p;
            p = q;
            q = t;
            if (t != last)
                t = t.next;
        }
        pre.next.next = last;
        pre.next = p;
        return tail;

    }
    //求长度
    public int getLength(ListNode head) {

        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
    }
}