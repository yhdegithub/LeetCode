import java.util.*;

//制定一个值 ， 再左右夹逼 ，时间就为N^2了
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  //剪枝
                continue;
            if (nums[i] > 0)           //剪枝
                break;
            int j = i + 1, k = n - 1;  //双指针夹逼靠近 O(n)
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    List<Integer> one = new ArrayList<Integer>();
                    one.add(nums[i]);
                    one.add(nums[j]);
                    one.add(nums[k]);
                    if (!res.contains(one))
                        res.add(new ArrayList<>(one));
                    //剪枝，这个很有意义
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }

}