public class RandomizedSet {


    Map<Integer,Integer> map;
    List<Integer> list;
    int size;

    /** Initialize your data structure here. */
    public RandomizedSet() 
    {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        this.size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        if(map.containsKey(val)) return false;
        else
        {
            list.add(size,val);
            map.put(val,size++);
            return true;
        }
    }
    

    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
        if(!map.containsKey(val)) return false;
        else if(size == 0) map.remove(val);
        else
        {
            int tailKey = list.get(size-1);
            map.put(tailKey,map.get(val));
            list.set(map.get(val),tailKey);
            size--;
            map.remove(val);
              
        }
        return true; 
    }
    
    /** Get a random element from the set. */
    public int getRandom() 
    {
        Random rdm = new Random();
        return list.get(rdm.nextInt(size));
    }
}