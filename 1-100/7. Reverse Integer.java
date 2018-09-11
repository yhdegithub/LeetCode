class Solution {
    public int reverse(int x) {
        int res = 0;
        int i = 0;
        while(x!=0){
            int cur = x%10;
            x = x/10;
            int temp = res;
            res = res*10 + cur;  //就是x是负数其实也一样
            if(res/10 != temp)  //溢出判断
                return 0;
        }
        return res;
    }
}