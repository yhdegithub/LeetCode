import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int n = nums.length;
        //交换 比如3放到位置2
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
                swap(nums, nums[i] - 1, i);
        }
        //找第一个不符合的位置
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    public void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String args[]) {
        int a[] = {3, 4, -1, 1};// 1,2,0      7,8,9,11,12
        System.out.println(new Solution().firstMissingPositive(a));

    }
}