
import java.util.*;
//两种方法 ， 一种是构建一个升序栈 O(n)， 二则是左右扫描定义每个bar的左右极限边界数组O(n^2)
import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int max = height[0];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {

                int high = height[stack.pop()];
                int wide = i;
                if (!stack.isEmpty())
                    wide = i - stack.peek() - 1;
                int square = high * wide;
                max = Math.max(max,square);
            }
        }
        //栈里面还有一个升序的序列，请注意检查
        while(!stack.isEmpty()){
            int high = height[stack.pop()];
            int wide = 0;
            if(stack.isEmpty())
              wide = i ;
            else
                wide  = i - stack.peek()-1;
            max = Math.max(max, wide * high );

        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}