/*从后往前找开始递减的第一个值，若无则倒序 ； 如有， 则从此点出发往后找第一个比它大的值，然后交换次序
 */
import java.util.*;
public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;
        if(n<=1)  return;
        int i=n-1;
        for(;i>=1;i--)
            if(num[i-1] < num[i])
                break;
        i--;
        if(i==-1){
            Arrays.sort(num);
            return;
        }

        int j = i+1;
 Arrays.sort(num,i+1,n);
        for(;j<n;j++)
            if(num[j]>num[i]){
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
                break;
            }
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int num[] = {1,1,5};
        s.nextPermutation(num);
    }
}