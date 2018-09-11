import java.util.*;
//贪心算法
class Solution {
    public int jump(int[] a) {
        if (a == null || a.length <= 1)
            return 0;
        int lastmax = 0;
        int curmax = 0;
        int step = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i > lastmax) {   //  到达最大值时候 ， 步长++
                step++;
                lastmax = curmax;
            }

            curmax = Math.max(curmax, i + a[i]);

        }
        return step;
    }


    //主函数
    public static void main(String args[]) {
        int a[] = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(new Solution().jump(a));
    }
}