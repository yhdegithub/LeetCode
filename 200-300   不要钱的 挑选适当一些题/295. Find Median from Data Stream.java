import java.util.*;
/***
 *  用一般的数组保存，每次添加一个元素并且维护原来的有序结构O(n) ， 很可能会超时,我们改用堆时间能降到O(lg N) , 取中位数时间O(1)
 *  这道题我们什么一个小堆和大堆。 第1,3,5,7..个数字加入小堆中 ， 第2,4,6..加入大堆中
 *  为了保证小堆small的最小数字（堆顶）a 都要大于大堆big的最大元素（堆顶）b ，那么
 *   （1）在加入小堆的数字时候，第1,3,5,7...个数字，i） k>= b直接加入小堆 , ii)否则 big删除的b，加入small , 把k加入big
 *    (2)在加入大堆的数字时候 ，第2,4,6,8...个数字 ，i）k<a 直接加入大堆 ， ii）否则 ，small删除的a，加入big ， 把k加入small;
 *
 *
 *
 * */
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    int count = 0; //一共计入了几个数字
    public MedianFinder() {
       small = new PriorityQueue<>();
       big = new PriorityQueue<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2-o1;
           }
       });
    }
    public void addNum(int num) {
      count++;
      if((count&1)==1){              //加入第1,3,5,7,9.。。。
          if(big.isEmpty() || num>big.peek())
              small.add(num);
          else{
              small.add(big.poll());
              big.offer(num);
          }
      }else{            //加入第2,4,6,8.。。。
           if(small.isEmpty() || num <small.peek())
                big.offer(num);
           else{
               big.offer(small.poll());
               small.offer(num);

           }


      }
    }

    public double findMedian() {
          if((count&1)==1)  //奇数个
              return  small.peek();
          else
              return  (small.peek() + big.peek() ) /2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */