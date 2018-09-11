import java.util.*;

class Solution {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        if (n <= 26)
            return String.valueOf((char) ('A' + n - 1));
         n--;
        int cnt[] = new int[8];
        cnt[0] = 0;
        cnt[1] = 26;
        for (int i = 1; i < cnt.length; i++)
            cnt[i] = cnt[i - 1] + (int) Math.pow(26, i);
        while (n >= 0) {
            int k = n % 26;
            sb.append((char) ('A' + k));
            n = n/ 26  -1 ;
        }

        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        int n = 329398;
        System.out.println(new Solution().convertToTitle(n));
    }
}