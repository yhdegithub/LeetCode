import java.util.*;
/**暴力做法是超时的 ， 这道题是左右两边的夹逼 
 * 
 * */
class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length<=1)
            return 0;
        int n = height.length;
        int max = 0;
        int left = 0,  right = n-1;
        while(left<right){
            int area = Math.min(height[left] , height[right]) * (right-left);
            max = Math.max(max ,area);
            if(height[left]< height[right])
                left++;
            else
                right--;
        }
        return max;
    }
    public static void main(String args[]){
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}