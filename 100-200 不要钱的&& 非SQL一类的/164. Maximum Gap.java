public class Solution {
    //构架一个桶 ， 利用桶排序的思想
    private class Pair {
        int min, max;
        public Pair(int min, int max) {
            this.min = min; this.max = max;
        }
    }
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int min=num[0], max=num[0], N=num.length;
        for (int n: num) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if (max == min) return 0;
        int dist=(((max-min)-1)/(N-1))+1;
        Pair[] buckets = new Pair[N];
        for(int n: num) {
            int bucket = (n-min)/dist;
            Pair p = buckets[bucket];
            if (p == null) {
                buckets[bucket] = new Pair(n, n);
            } else {
                p.min = Math.min(p.min, n);
                p.max = Math.max(p.max, n);
            }
        }
        max = dist;
        int prevBucketMax=buckets[0].max;
        for (int i=1; i<buckets.length; i++) {
            if (buckets[i] == null) continue;
            max = Math.max(max, buckets[i].min-prevBucketMax);
            prevBucketMax = buckets[i].max;
        }
        return max;
    }
}