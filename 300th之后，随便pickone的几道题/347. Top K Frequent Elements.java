import java.util.*;
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return res;
        int n =nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++)
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else{
                map.put(nums[i],1);
            }
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> t: map.entrySet())
            list.add(t);
         Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
             @Override
             public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                 return o2.getValue() - o1.getValue();
             }
         });
         for(int i=0;i<k;i++)
             res.add(list.get(i).getKey());
            return res;
    }
    public static void main(String args[]){
        int a[]={4,1,-1,2,-1,2,3};
        int k =2;
        System.out.print(new Solution().topKFrequent(a,k));
    }
}