import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<Integer>());
        if(nums==null || nums.length==0)
            return res;
        //回溯法
        Arrays.sort(nums);
        int n = nums.length;
        for(int target=1;target<=n;target++){
            List<Integer> one =new ArrayList<>();
            dfs(one,0,target,nums);
        }
        return res;
    }
    public void dfs(List<Integer>one ,int start ,int target,int nums[]){
        if(target==one.size()){
            if(!res.contains(one))
                res.add(new ArrayList<>(one));
            return;
        }
        if(one.size()>target||start>=nums.length)
            return;
        for(int i=start;i<nums.length;i++){
            one.add(nums[i]);
            dfs(one,i+1,target,nums);
            one.remove(one.size()-1);
        }



    }
    public static void main(String args[]){
        int nums[]= {2,1,2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }
}