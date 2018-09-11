class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] num) {
         if(num==null || num.length==0)
            return res;
        int n =num.length;
        boolean visit[] = new boolean[n];
        ArrayList<Integer> one = new ArrayList<Integer>();
        dfs(one,num,visit);
        return res;
    }
    //
    public void dfs(ArrayList<Integer> one,int num[],boolean visit[]){
        if(one.size()==num.length){
            res.add(new ArrayList<Integer>(one));
            return ;
        }
        for(int i =0;i<num.length;i++)
        {
            if(visit[i])
                continue;
            visit[i] = true;
            one.add(num[i]);
            dfs(one,num,visit);
            one.remove(one.size()-1);
            visit[i] = false;
        }

    }
    }
