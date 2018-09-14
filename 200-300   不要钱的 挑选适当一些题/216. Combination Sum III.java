import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0)
            return res;
        List<Integer> one =new ArrayList<>();
        dfs(one,n,k,1);
        return res;
    }

    public void dfs(List<Integer> one, int target, int num,int start) {
        if ( num == 0  && target==0) {
                res.add(new ArrayList<>(one));
             return;
        }
        if(num<=0 || target<=0 )
          return;
     for(int i=start;i<=9;i++){
            if(target-i<0)  break;
            one.add(i);
            dfs(one,target-i ,num-1,i+1);
            one.remove(one.size()-1);

     }
    }
    public static void main(String args[]){
        int k =3;
        int n = 9;
        System.out.println(new Solution().combinationSum3(k,n));
    }
}
