import java.util.*;
//栈的使用
class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()%2!=0)
            return false;
        int n = s.length();
        Stack<Character>stack = new Stack();
        for(int i=0;i<n;i++){
            char cur = s.charAt(i);
            if(isLeft(cur))
                stack.push(cur);
            else{
                if(cur==']'){
                    if(stack.isEmpty()||stack.peek()!='[')
                        return false;
                    stack.pop();
                }
                if(cur=='}'){
                    if(stack.isEmpty()||stack.peek()!='{')
                        return false;
                    stack.pop();
                }
                if(cur==')'){
                    if(stack.isEmpty()||stack.peek()!='(')
                        return false;
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }
    public boolean isLeft(char ch){
        return ch=='(' || ch=='[' || ch=='{';
    }
    public static void main(String args[]){
        System.out.println(new Solution().isValid("{[]}"));
    }
}