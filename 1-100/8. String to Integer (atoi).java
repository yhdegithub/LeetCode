class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        int pos = 1;
        int n = str.length();
        if(n==0)  return 0;
        int i = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-')
            i++;
        if (str.charAt(0) == '-') pos = -1;
        int res = 0;
        for (; i < n; i++) {
            int cur = str.charAt(i) - '0';
            if (cur >= 0 && cur <= 9) {
                int temp = res;
                res = res * 10 + cur;
                if ((res) / 10 != temp) {  //注意32位溢出
                    if (pos == 1) return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
            }else
                return res * pos;
        }
        return res * pos;
    }
}