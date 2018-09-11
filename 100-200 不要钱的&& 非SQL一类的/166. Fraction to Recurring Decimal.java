/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.util.*;

class Solution {
    public String fractionToDecimal(int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        long a = (long) num1, b = (long) num2;
        if (a == 0) return String.valueOf(0);
        String sign = "-";
        if ((a < 0 && b > 0) || (a > 0 && b < 0))
            sb.append(sign);
        a = Math.abs(a);
        b = Math.abs(b);
        long c = a / b;
        HashMap<Long, Integer> map = new HashMap<>();
        sb.append(c);
        if ((a % b) == 0)
            return sb.toString();
        sb.append(".");
        int cnt = sb.length();
        long mod = a % b;
        while (mod != 0 && !map.containsKey(mod)) {
            map.put(mod, cnt++);
            sb.append((mod * 10) / b);
            mod = (mod * 10) % b;

        }
        if (mod == 0)
            return sb.toString();
        else
            sb.append(")");
        int pos = map.get(mod);
        sb.insert(pos, '(');
        return sb.toString();
    }

    public static void main(String args[]) {
        int a = -1;
        int b = -2147483648;
        String tt = new Solution().fractionToDecimal(a, b);
        System.out.println(tt);
    }
}