import java.util.*;
//回溯法
public class Solution {
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<Integer> one = new ArrayList<Integer>();
        int n = a.length;
        if (a == null || n == 0)
            return all;
        Arrays.sort(a);
        int left = target;
        dfs(a, 0 , left, one);
        return all;
    }

    //回溯法
    public void dfs(int a[], int start, int left, List<Integer> one) {
        if (left == 0) {
            if (!all.contains(one))
                all.add(new ArrayList<Integer>(one));
            return;
        }
        if (left < 0)
            return;
        for (int i = start; i < a.length; i++) {
            left = left - a[i];
            one.add(a[i]);
            dfs(a, i, left, one);
            one.remove(one.size() - 1);
            left = left + a[i];
        }
    }
}
