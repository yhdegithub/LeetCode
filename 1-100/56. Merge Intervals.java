import java.util.*;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        List<Interval> answer = new ArrayList<>();
        if(n<=1)
            return intervals;
        for(int i=0;i<n;i++)
           answer =  insert(answer , intervals.get(i));
        return answer;

    }
    //插入
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge2(intervals);
    }
    public  List<Interval> merge2(List<Interval> intervals){
        Collections.sort(intervals  ,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return o1.start - o2.start;
            }
        });
        int n = intervals.size();
        if(n<=1)
            return intervals;
        int j = 0;
        List<Interval> res  = new ArrayList<>();
        res.add(intervals.get(0));
        for(int i=1;i<n;i++){
            int a = res.get(res.size()-1).start ,b = res.get(res.size()-1).end;
            int  c = intervals.get(i).start ,d = intervals.get(i).end;
            //讨论几种情况
            //包含
            if(d<=b)  continue;
            else if(c<=b && d>=b){
                res.remove(res.size()-1);
                res.add(new Interval(a,d) );
            }else if(c>=b)
                res.add(new Interval(c,d) );

        }
        return res;
    }
    public static void main(String args[]){
        List<Interval> intervals =new ArrayList<>();
        intervals.add(new Interval(1,3));intervals.add(new Interval(2,6));intervals.add(new Interval(8,10));intervals.add(new Interval(15,18));
        Interval newInterval =new Interval(2,4);
        new Solution().merge(intervals);
    }
}