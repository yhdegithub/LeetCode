import java.util.*;
//这道题关键是要找到循环的结束条件 ， 这道题不好找 ， 回想以前的快慢指针法，就可以隐含的找到结果了
class Solution {
    public boolean isHappy(int n) {
        
        int slow =   move(n);
        int fast =  move(slow);
        while(fast!=slow){
            slow = move(slow);
            fast = move(move(fast));
            if(slow==1 || fast==1)
                return true;
            if(fast==slow && fast!=1)  return false;
        }
        if(slow==1 || fast==1)
            return true;
        return false;
    }
    public int move(int n){
        int sum = 0;
        while(n!=0){
            sum +=  (n%10) * (n%10);
            n = n/10;
        }
        return sum;

    }
    public static void main(String args[]){
        System.out.println(new Solution().isHappy(1));
    }
}