import java.util.*;
/**（1）模拟加法和乘法
 *  （2）BigInteger
 * */
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (m == 0 || n == 0 || num1.equals("0") || num2.equals("0"))
            return "0";

        String res = cal(num1, num2.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            String tmp = cal(num1, num2.charAt(i));
            for(int j= i ;j<n-1;j++)
                tmp +="0";
            res = add(res, tmp);
        }
        return res;
    }

    public String cal(String num1, char a) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int m = num1.length();
        for (int i = m - 1; i >= 0; i--) {
            int mul = (num1.charAt(i) - '0') * (a - '0') + cnt;
            sb.append(mul % 10);
            cnt = mul / 10;
        }
        if (cnt != 0)
            sb.append(cnt);
        return sb.reverse().toString();
    }

    //
    public String add(String res, String tmp) {
        int m = res.length();
        int n = tmp.length();
        if (m < n)
            return add(tmp, res);
        while (n < m) {
            tmp = "0" + tmp;
            n++;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = m - 1; i >= 0; i--) {
            int sum = res.charAt(i) - '0' + tmp.charAt(i) - '0' + cnt;
            sb.append(sum % 10);
            cnt = sum / 10;
        }
        if (cnt != 0)
            sb.append(cnt);
        return sb.reverse().toString();
    }
}