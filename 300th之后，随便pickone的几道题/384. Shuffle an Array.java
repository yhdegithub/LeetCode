class Solution {
  int pre[] =null;
    int cur[] =null;
    public Solution(int[] nums) {
        this.pre = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return pre;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = pre.length;
        cur =new int[n];
        for(int i=0;i<n;i++)
            cur[i] =pre[i];
        Random r = new Random();
        for(int i=0;i<n;i++){
            int pos = r.nextInt(i+1) %n;
            int t = cur[pos];
           cur[pos] = cur[i];
            cur[i] =t;
        }
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */