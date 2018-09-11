import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        if (m < n) return addBinary(b, a);
        int i = m - 1, j = n - 1;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + (j >= 0 ? b.charAt(j) - '0' : 0) + c;
            sb.append(sum % 2);
            c = sum / 2;
            i--;
            j--;
        }
        if(c==1)  sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        String s1 = "11010";
        String s2 = "1011";
        String s3 = "10101";
        System.out.println(new Solution().addBinary(s1, s2));

    }
}