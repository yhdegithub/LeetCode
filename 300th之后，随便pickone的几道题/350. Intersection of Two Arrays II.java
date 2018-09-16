import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[]{};
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
            if(map.containsKey(nums1[i]))
                map.put(nums1[i],map.get(nums1[i])+1);
            else
                map.put(nums1[i],1);
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) >0){
                list.add(nums2[i]);
                map.put(nums2[i] , map.get(nums2[i])-1);
            }

        }
        int n =list.size();
        int res[] =new int[n];
        for(int i=0;i<n;i++)
            res[i] =list.get(i);
        return res;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int a[] ={1,2,2,1,3};
        int b[] ={2,3};
        new Solution().intersect(a,b);
    }
}