import java.util.*;
//O(1)时间的get,意味着用map;put和get都要记录访问时间 ，所以用一个双端队列 ， 新的就再首部 ， 最旧的在尾巴
class LRUCache {
   HashMap<Integer,Integer>map ;
   Deque<Integer> queue ;
   int capacity;
   public LRUCache(int capacity) {
     this.capacity = capacity;
     map = new HashMap<>(capacity);
     queue = new LinkedList<>();
    }
    // Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    public int get(int key) {
       if(!map.containsKey(key))
           return -1;
       queue.remove(key);
       queue.offerFirst(key);
       return map.get(key);
    }
/****
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * */
    public void put(int key, int value) {
          if(map.containsKey(key)){
              map.put(key,value);
              queue.remove(key);
              queue.offerFirst(key);
          }else{
              if(queue.size()<capacity){
                  map.put(key,value);
                  queue.offerFirst(key);
              }else{
                  map.remove(queue.peekLast());
                  queue.pollLast();
                  map.put(key,value);
                  queue.offerFirst(key);
              }
          }
    }

    public static void main(String args[]){
        LRUCache cache = new LRUCache(2);
       cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */