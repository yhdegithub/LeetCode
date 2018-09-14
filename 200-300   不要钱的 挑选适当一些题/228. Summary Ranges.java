import java.util.*;
class Solution {
    List<String>  res = new ArrayList<>();
    public List<String> summaryRanges(int[] nums) {
        if(nums==null || nums.length==0)
            return res;
        int n =nums.length;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(nums[i]);
        int j=0;
        int pre = nums[0];
        int last = nums[0];
        while(j<n){
            pre = nums[j];
            last = pre;
            while(j+1<n && nums[j+1]==nums[j]+1)
                j++;
            last = nums[j];
            j++;
            if(pre==last)
                res.add(String.valueOf(pre));
            else
                res.add(new String(pre + "->" + last));

        }
        return res;

    }
public static void main(String args[]){
int a[] ={0,1,2,4,5,7};
    System.out.println(new Solution().summaryRanges(a));

}

}