import java.util.*;

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        int sign = 1;  //只有加减
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){  //遇到数字就把把它和之前的res，添上sign运算
                int cur = ch - '0';
                while(i+1<n && Character.isDigit(s.charAt(i+1)))
                    cur = cur *10 + s.charAt(++i) - '0';
                res  += sign *cur;
            }else if(ch=='+')
                sign =1;
            else if(ch=='-')  //   + -保存起来
                sign =-1;
            else if(ch=='('){           //保存之前的结果 ，先算括号里面的
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign =1;
            }else if(ch==')')
                res = stack.pop() *res +stack.pop();


        }
        return res;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        String t = "(1-(4-5+2)-3)-(6-8)";
        System.out.println(s.calculate(t));
    }
}