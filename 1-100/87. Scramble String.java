import java.util.*;

public class Solution {
   
 public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
            return false;
        if (len1 == 1)
            return s1.equals(s2);
        //剪枝:若排序后不不相等则必定不满足条件
        char[] chars1 = new char[len1];
        s1.getChars(0, len1, chars1, 0);
        Arrays.sort(chars1);
        char[] chars2 = new char[len1];
        s2.getChars(0, len2, chars2, 0);
        Arrays.sort(chars2);
        if (!(new String(chars1).equals(new String(chars2))))
            return false;
         
        for (int i = 1; i < len1; i++) {
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i, len1);
            String s2left = s2.substring(0, i);
            String s2right = s2.substring(i, len1);
             
            //在当前分割处没有交换
            if (isScramble(s1left, s2left) && isScramble(s1right, s2right))
                return true;
            //当前分割处左右交换
            s2right = s2.substring(len1 - i, len1);
            s2left = s2.substring(0, len1 - i);
             
            if (isScramble(s1left, s2right) && isScramble(s1right, s2left))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String s1 = "abcde";
        String s2 = "caebd";
        System.out.println(new Solution().isScramble(s1, s2));
    }
}