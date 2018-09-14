import java.util.*;
class MyStack {
    Queue<Integer> q1;  //两个队列肩搭着用
    Queue<Integer> q2;   //只用来出栈保存一下数据
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()!=1)
            q2.offer(q1.poll());
        int target = q1.poll();
        while(!q2.isEmpty())
            q1.offer(q2.poll());
        return target;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size()!=1)
            q2.offer(q1.poll());
        int target = q1.poll();
        q2.offer(target);
        while(!q2.isEmpty())
            q1.offer(q2.poll());
        return target;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String args[]){

        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }


}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */