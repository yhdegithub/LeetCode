import java.util.*;
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0 || n<k)
            return res;
        List<Integer> one = new ArrayList<>();
        dfs(n,k,1,one);
        return res;
    }
    //回溯法
    public void dfs(int n,int k,int start,List<Integer>one){
        if(one.size()==k){
            res.add(new ArrayList<>(one));
            return;
        }
        if(one.size()>k || start>n)
            return;
        for(int i=start;i<=n;i++){
            one.add(i);
            dfs(n,k,i+1,one);
            one.remove(one.size()-1);
        }


    }
    public static void main(String args[]){

        int n =4;
        int k =2;

        System.out.println( new Solution().combine(n,k));



    }

}