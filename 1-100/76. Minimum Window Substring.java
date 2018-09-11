/*
 * 这道题其实解答很简单得，就是用滑动窗口的思想
 *    （1）把T的字符及其出现次数放到map中
 *     （2）窗口用一个i,j表示左右边界 ， 用count计数 ，直到满足的窗口出现，更新
 *       （3）i右移。直到移出一个T中的字符，然后j又右移，查找下一个窗口
 *
 *Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
 * */

import java.util.*;

public class Solution {
    public String minWindow(String S, String T) {
        int n = S.length(), m = T.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++)
            if (map.containsKey(T.charAt(i)))
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            else
                map.put(T.charAt(i), 1);
        //滑动窗口
        int i = 0, len = n + 1;
        int count = 0;
        int left = 0;
        String res = "";
        for (i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
                if (map.get(S.charAt(i)) >= 0) {
                    count++;
                }
                while (count == T.length()) {
                    if (map.containsKey(S.charAt(left))) {
                        if (i - left + 1 < len) {
                            len = i - left + 1;
                            res = S.substring(left, i + 1);
                        }
                        map.put(S.charAt(left), map.get(S.charAt(left)) + 1);
                        if (map.get(S.charAt(left)) > 0)
                            count--;
                    }
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(new Solution().minWindow(S, T));
    }
}