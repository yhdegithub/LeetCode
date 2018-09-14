//类似于罗马数字和整数之间的转化 ，注意
class Solution {
   public String numberToWords(int num) {
        if(num==0) {
            return "Zero";
        }
        return helper(num);
    }
    public String helper(int num) {
        String[] words = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder res = new StringBuilder();
        
        if(num>=1000000000) {
            res.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        } else if(num>=1000000) {
            res.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        } else if(num>=1000) {
            res.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        } else if(num>=100) {
            res.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        } else if(num>=20) {
            res.append(words[(num-20)/10+20]).append(" ").append(words[num%10]);
        } else {
            res.append(words[num]);
        }
        
        return res.toString().trim();
    }
}