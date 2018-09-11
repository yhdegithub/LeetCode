import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        int n =nums.length;
        String ss[] =new String[n];
        for(int i=0;i<n;i++)
            ss[i] = String.valueOf(nums[i]);
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(ss[i]);
        StringBuilder res =new StringBuilder();
        int j =0;
        while(j<sb.length() && sb.charAt(j)=='0')
            sb.deleteCharAt(j);
        if(sb.length()==0)
            return "0";
        return sb.toString();
    }
}