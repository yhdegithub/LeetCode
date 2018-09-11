import java.util.*;
class Solution {
    public int evalRPN(String[] s) {
        Stack<Integer>stack = new Stack<>();
        if(s==null || s.length==0)
            return 0;
        int n=s.length;
        for(int i=0;i<n;i++){
            if(isNum(s[i]))
                stack.push(Integer.parseInt(s[i]));
            else if(s[i].equals("+"))
                stack.push(stack.pop()+stack.pop());
            else if(s[i].equals("*"))
                stack.push(stack.pop()*stack.pop());
           else if(s[i].equals("-"))
                stack.push( -(stack.pop()-stack.pop()));
            else{
                int a =stack.pop();
                int b =stack.pop();
                stack.push(b/a);
            } 
                
        }
        return stack.pop();
    }
    public boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}