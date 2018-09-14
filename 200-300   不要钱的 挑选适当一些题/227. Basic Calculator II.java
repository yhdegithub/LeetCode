import java.util.*;
//自己写的后缀求解 ，很挫 ，看别人的代码才叫精简
class Solution {
    public int calculate(String s) {
        if (s == null)
            return 0;
        s = s.trim();
        int n = s.length();
        if (n == 0) return 0;
        int res = 0;
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if(ch==' ') {
                i++;
                continue;
            }
            else if(!isDigital(ch)){   //遇到操作符
                if(op.isEmpty() || ((ch=='*'||ch=='/')&& (op.peek()=='+'|| op.peek()=='-' )))
                    op.push(ch);
                else{
                    while(!(op.isEmpty() || ((ch=='*'||ch=='/')&& (op.peek()=='+'|| op.peek()=='-' )))){
                         int b = num.pop() , a = num.pop();
                        char cur = op.pop();
                        num.push(cal(a,b,cur));
                    }
                    op.push(ch);
                }
                i++;
            }else{             //遇到数字
               int j = i+1;
                while(j<n&&isDigital(s.charAt(j)))
                    j++;
                int k  =Integer.parseInt(s.substring(i,j));
               i = j;
                num.push(k);
            }

        }
        //剩下元素
        while(!op.isEmpty()){
            int b = num.pop() , a = num.pop();
            char cur = op.pop();
            //num.push(cur);
            num.push(cal(a,b,cur));
        }
        return num.pop();
    }
    public boolean isDigital(char ch){
        return ch<='9'&& ch>='0';
    }
    public int cal(int a,int b,char ch){
        if(ch=='+')
            return a+b;
        else if(ch=='-')
            return a-b;
        else if(ch=='*')
            return a*b;
        else
            return a/b;

    }

    public static void main(String args[]) {
        String s =" 3+5 / 2 " ;//"13+7/3*3-5/2+3*2-1"
        System.out.println(new Solution().calculate(s));
    }
	
	
}




//这是别人写的 ，那叫一个精简
public class Solution {
public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
            if(sign=='-'){
                stack.push(-num);
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}
}
















