import java.util.*;
public class Solution {
    List<List<Integer>> all = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<Integer> one = new ArrayList<Integer>();
        if (num == null || num.length == 0)
            return all;
        int n = num.length;
        Arrays.sort(num);
        dfs(num, 0, target, one);
        return all;
    }

    public void dfs(int num[], int start, int target, List<Integer> one) {
        if (target == 0) {
            if (!all.contains(one))
                all.add(new ArrayList<>(one));
            return;
        }
        if(target<0)
            return ;
        for(int i = start;i<num.length ;i++){
            target -= num[i];
            one.add(num[i]);
            dfs(num,i+1, target,one);
            target += num[i];
            one.remove(one.size()-1);

        }

    }
}