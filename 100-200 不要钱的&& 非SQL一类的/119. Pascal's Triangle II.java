import java.util.*;
class Solution {
    List<List<Integer>> res=  new ArrayList<>();
    public List<List<Integer>> generate(int n) {
        if(n==0)  return res;
        for(int i=1;i<=n;i++){
            List<Integer> t = new ArrayList<>(i);
            t.add(0,1);
            if(i==1) {
                res.add(new ArrayList<>(t));
                continue;
            }
            for(int index =1;index<=i-2;index++)
                t.add(res.get(i-2).get(index-1) + res.get(i-2).get(index));
             t.add(1);
            res.add(new ArrayList<>(t));
        }
    return res;
    }
    public static void main(String args[]){
        int n=5;
        System.out.println(new Solution().generate(n));
    }
}