/**
 *(1)挨着检测
 *（2）利用catch 捕获异常
 （3）正则
 *  **/

import java.util.*;
public class Solution {
    public boolean isNumber(String s) {
        if(s.length()==0)  return false;
        try{
            char ch=s.charAt(s.length()-1);
            if(ch=='f'||ch=='F'||ch=='d'||ch=='D')
                return false;
            double f = Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }



    }
}


/*
     * 
     * 发现解答很多都用了一些小技巧，比如正则，或者NumberFormatException
     * 实际上这些解法都调用库函数，个人觉得不是出题者的真正意图
     * 
     * 
     * Runtime: 3 ms.Your runtime beats 83.72 % of java submissions.
     * 思路：这道题关键是分析所有会出现的情况。以及设置关键的flag来记录各种情况 
     * 首先使用trim()函数去除前后空格。 
     * 设置4个标志，分别是
     * boolean pointSeen = false;//是否出现过小数点“.” 
     * boolean eSeen =alse;//是否出现过指数标志“e” 
     * boolean numberSeen = false;//是否出现过数字 
     * booleannumberAfterE = true;//e后面是否有数字 
     * 进行循环s.charAt(i)：
     * 1.如果属于[0,9]，把numberSeen设为true 
     * 2.如果是‘.’，必须之前没有遇到'.'和'e'
     * 3.如果是'e'，必须之前没有遇到过'e' 
     * 4.如果是'+'或者'-',当前i必须是0，或者i-1上的字符是e 
     * 5.其他情况返回false
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0)
            return false;
        // 记录是否出现过数字
        boolean numberSeen = false;
        // 是否出现过小数点
        boolean pointSeen = false;
        // 是否出现过指数标志e
        boolean eSeen = false;
        // e后是否出现过数字
        boolean numberAfterE = false;
 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
                // 如果是小数点
            } else if (c == '.') {
                if (pointSeen || eSeen)
                    return false;
                pointSeen = true;
                // 如果是e，必须没有出现过且出现过数字
            } else if (c == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberAfterE = false;
                // 如果出现正负号，必须是首位，或者前一位是e
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else
                return false;
        }
        return numberSeen && numberAfterE;
    }
	
	
	//（3）正则
	public boolean isNumber(String s) {
        return s.matches("(\\s)*([+-])?(([0-9]*\\.)?([0-9]+)|([0-9]+)(\\.[0-9]*)?)([eE][\\+-]?[0-9]+)?(\\s)*");
    }

