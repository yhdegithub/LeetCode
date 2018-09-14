import java.util.*;
class Solution {
    /**这道题原理就是先排个序  ， 然后依次枚举n ，n-1.....1
     *  假如为n ，有 num[0] >=n;
     *      为n-1 ,有 num[0] < n-1 ,num[1] >=n-1
     *       为n-2,有   num[1]<n-2  ,  num[2]>=n-2;
     *        .....
     *       为 i , 有 num[n-1-i] < i , num[n-i]>=i
     *
     * */
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        int n =citations.length;

        Arrays.sort(citations);
        if(citations[0]>=n)
            return n;
        for(int i=n-1;i>=1;i--){
            if(citations[n-1-i]<=i && citations[n-i]>=i)
                return i;
        }
        return 0;
    }
    public static void main(String args[]){
        System.out.println(new Solution().hIndex(new int[]{10}));
    }
}