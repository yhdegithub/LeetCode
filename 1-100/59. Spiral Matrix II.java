import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    //
    public int[][] generateMatrix(int n) {
        int a[][] = new int[n][n];
        if (n <= 0)
            return a;
        int rowStart = 0, rowEnd = n - 1;  //行
        int colStart = 0, colEnd = n - 1;  //列
        int index = 1;
        while (colStart <= colEnd && rowStart <= rowEnd) {
            //左到右
            for (int i = rowStart, j = colStart; j <= colEnd &&colStart <= colEnd && rowStart <= rowEnd; j++)
                a[i][j] = index++;
             rowStart++;
            //从上到下
            for(int i = rowStart , j=colEnd;i<=rowEnd&&colStart <= colEnd && rowStart <= rowEnd;i++)
                a[i][j] = index++;
             colEnd--;
             //从右到左
            for(int i=rowEnd,j=colEnd;j>=colStart&&colStart <= colEnd && rowStart <= rowEnd;j--)
                a[i][j] = index++;
              rowEnd--;
              //下到上
            for(int i=rowEnd,j=colStart;i>=rowStart&&colStart <= colEnd && rowStart <= rowEnd;i--)
                a[i][j] = index++;
             colStart++;
        }
        return a;
    }

    public static void main(String args[]) {
        int nums[] = {-2, 1};
        new Solution().generateMatrix(4);
        new Solution().generateMatrix(4);
    }
}