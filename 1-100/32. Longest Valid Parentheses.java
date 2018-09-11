import java.util.*;
//利用栈，可以把时间降到O(n)
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int n = s.length();
        int max = 0;
        int i = 0;
        //  while (i < n && s.charAt(i) == ')')
        //    i++;
        Stack<Integer> stack = new Stack<>();
        int pre = -1;      //指向前一个 )
        for (; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty())
                    pre = i;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, i - pre);
                    else
                        max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}