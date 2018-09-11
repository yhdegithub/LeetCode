import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> one = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(one));
        if (nums == null || nums.length == 0)
            return res;
        int n = nums.length;
        for (int target = 1; target <= n; target++) {
            dfs(nums, target, 0, 0);
        }
        return res;
    }

    public void dfs(int nums[], int target, int start, int cur) {
        if (cur == target) {
            res.add(new ArrayList<>(one));
            return;
        }
        if (start >= nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            one.add(nums[i]);
            dfs(nums, target, i + 1, cur + 1);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3};
        System.out.println(new Solution().subsets(nums));
    }
}