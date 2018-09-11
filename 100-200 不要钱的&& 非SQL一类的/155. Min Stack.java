import java.util.*;
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
          stack = new Stack<>();   //存储压入值
          min = new Stack<>();    //存储最小值
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.size()==0 || x<=min.peek())
            min.push(x);
            else
                min.push(min.peek());
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */