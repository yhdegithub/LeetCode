class Solution {
    public int firstUniqChar(String s) {
        int a[] = new int[256];
        if(s==null ||s.length()==0)
            return -1;
        int n =s.length();
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)]++;
        }
        for(int i=0;i<n;i++)
            if(a[s.charAt(i)]==1)
                return i;
        
        return -1;
    }
}