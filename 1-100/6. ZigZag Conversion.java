import java.util.*;
class Solution {
    public String convert(String s, int n) {
        if(s==null || s.length()<=n)
            return s;
        StringBuilder sb[] = new StringBuilder[n];
        int i=0;
        for(i=0;i<n;i++)
            sb[i] = new StringBuilder();
        int level = 0; //分奇偶
        i=0;
        while(i<s.length()) {
            level++;
            if ((level & 1) == 1) {
                for (int j = 0; j < n && i < s.length(); j++)
                    sb[j].append(s.charAt(i++));
            } else {
                for (int j = n - 2; j > 0 && i < s.length(); j--)
                    sb[j].append(s.charAt(i++));

            }
        }
        StringBuilder res = new StringBuilder();
        for(i=0;i<n;i++)
            res.append(sb[i]);
        return res.toString();
    }
    public static void main(String args[]){
        String s ="PAYPALISHIRING";
        int n = 3;
        System.out.println(new Solution().convert(s,n).equals("PAHNAPLSIIGYIR"));
    }
}