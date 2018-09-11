import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        if(n==1)  return n;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i],i);
        int max =1;
        while(!map.isEmpty()){
            int count = 1;
            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            int start = (int) it.next().getKey();
            it.remove();
            int tmp = start;
            while(map.containsKey(++start)){
               map.remove(start);
                count++;
            }
          while(map.containsKey(--tmp)){
                map.remove(tmp);
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String args[]){
        int a[] ={ 100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(a));
    }
}