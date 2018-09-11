import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        if (n <= 3) return res;
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i++) {
            if (i >= 1 && num[i] == num[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                int l = j + 1, r = n - 1;
                int left = target - num[i] - num[j];
                while (l < r) {
                    if (num[l] + num[r] == left) {
                        List<Integer> one = new ArrayList<>();
                        one.add(num[i]);
                        one.add(num[j]);
                        one.add(num[l]);
                        one.add(num[r]);
                        if (!res.contains(one))
                            res.add(new ArrayList<>(one));
                        l++;
                        r--;
                        //剪枝
                        while (l < r && num[l] == num[l - 1])
                            l++;
                        while (l < r && num[r] == num[r + 1])
                            r--;
                    } else if (num[l] + num[r] > left) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }

        }
        return res;
    }
}