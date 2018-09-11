class Solution {
    public int minimumTotal(List<List<Integer>> t) {
          if (t == null || t.size() == 0)
            return 0;
        int n = t.size();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 99999);
        dp[0] = t.get(0).get(0);
        for (int i = 1; i < n; i++)
            for (int j = i; j >= 0; j--) {
                if (j == 0)
                    dp[j] = dp[j] + t.get(i).get(0);
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + t.get(i).get(j);
            }
            int min = dp[0];
        for(int i=1;i<n;i++)
            if(dp[i] <min)
                min = dp[i];
        return min;
    }
}