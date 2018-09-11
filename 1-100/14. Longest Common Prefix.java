/**
 * *最长的前缀就是最不相同的两个字符串之间的前缀 ， 也可以考虑字典树 ， 只是简单题复杂化了
 * *
 * */
import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int n = strs.length;
        if (n == 1)
            return strs[0];
        Arrays.sort(strs);
        StringBuffer sb = new StringBuffer();
        int m = strs[0].length(), l = strs[n - 1].length();
        for (int i = 0; i < m && i < l; i++) {
            if (strs[0].charAt(i) == strs[n - 1].charAt(i))
                sb.append(strs[0].charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}