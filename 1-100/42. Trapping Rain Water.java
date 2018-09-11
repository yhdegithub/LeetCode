import java.util.*;
/**
 * （1）利用栈记录一个上升序列， 直到一个开始下降了就计算更新最值
 *    （2）或者左右两边记录其较高者
 */

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<=2)
            return 0;
        int n =height.length;
        int res = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        int max = 0;
        //扫描两次 ，记录每个bar左右的最大值
        for(int i = 0;i<n;i++){
            left[i] = Math.max(max,height[i]);
            max = Math.max(max,height[i]);
        }
        max = 0;
        for(int j=n-1;j>=0;j--){
            right[j] = Math.max(max,height[j]);
            max = Math.max(max,height[j]);

        }
        //计算
        for(int i=1;i<n-1;i++)

            res +=  (Math.min(left[i],right[i]) - height[i])>0?Math.min(left[i],right[i]) - height[i]:0;
        return res;
    }
}