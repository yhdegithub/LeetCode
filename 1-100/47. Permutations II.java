import java.util.*;
public class Solution {
    //一个简单的回溯法，超时的话注意剪枝就是了
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] num) {
        List<Integer> one = new ArrayList<Integer>();
        if(num==null || num.length==0)
            return all;
        boolean visit[] = new boolean[num.length];
        Arrays.sort(num);
        dfs(num,visit,one);
        return  all;
    }
    public void dfs(int num[],boolean visit[],List<Integer> one){
        if(one.size()==num.length){
            if(!all.contains(one))
                all.add(new ArrayList<Integer>(one));
            return;
        }
        for(int i=0;i<num.length;i++){
            if(visit[i])
                continue;
            one.add(num[i]);
            visit[i] = true;
            dfs(num,visit,one);
            visit[i] = false;
            one.remove(one.size()-1);
            //剪枝,不然会超时
            while( i < num.length-1 && num[i+1] == num[i])
                i++;
        }


    }
}