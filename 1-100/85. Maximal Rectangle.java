import java.util.*;
//两种方法 ， 一种是构建一个升序栈 O(n)， 二则是左右扫描定义每个bar的左右极限边界数组O(n^2)
import java.util.*;

public class Solution {
    //这道题目要调用以前做过的题，在这个基础上，在每一列上连续的1作为height[]，然后调佣largestRectangleArea，计算最大值
    public int maximalRectangle(char[][] matrix) {
      int res = 0;
      if(matrix==null || matrix.length==0)
          return 0;
      int m  = matrix.length , n = matrix[0].length;
      for(int j=0;j<n;j++){       //对每一列都计算一次
          int height[] = new int[m];
          int t = j;
          for(int i=0;i<m;i++){
              int len=0;
              j = t;
              while(j<n && matrix[i][j]=='1')
              {
                  len++;
                  j++;
              }
               height[i] = len;
          }
          int tmp = largestRectangleArea(height);
          res = Math.max(res,tmp);
          j = t;
      }

    return res;
    }
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int max = height[0];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
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
        char matrix[][] = {
                {'0','1','1','0','0'},
                {'1','1','1','1','1'},
                {'0','1','1','0','1'},
                {'0','1','0','1','1'},
        };
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}