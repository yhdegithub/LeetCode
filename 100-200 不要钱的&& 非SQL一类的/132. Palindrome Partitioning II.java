import java.util.*;

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        if (n == 1) return 0;
        boolean dp[][] = new boolean[n][n];
        //初始化
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        //dp[i][j]代表i.....j是回文
        for (int j = 1; j < n; j++)
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((i + 1 >= j - 1) || dp[i + 1][j - 1]))
                    dp[i][j] = true;
            }
        // cut[i]代表从 i 到n-1最少可以切几刀
        int cut[] = new int[n + 1];
        Arrays.fill(cut,n-1);
        cut[n] = 0;
        cut[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--)
            if (dp[i][n - 1])
                cut[i] = 0;
            else {
                cut[i] = n-1 - i;
                for (int j = i; j < n; j++)
                    if (dp[i][j])
                        cut[i] = Math.min(cut[i], 1 + cut[j+1]);
            }

        return cut[0];
    }

    public static void main(String args[]) {
        System.out.println(new Solution().minCut("abb"));
    }
}