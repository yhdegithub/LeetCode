import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //这道题就是BFS，注意边界条件就好 ，但是难的是ladder ii,只要求掌握下思想就好了，是在难，写不出来
        int step = 1;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++)
            set.add(wordList.get(i));
        if (!set.contains(endWord))
            return 0;
        if (beginWord.equals(endWord))
            return 1;
        Queue<String> queue = new LinkedList<>();  //BFS常用的套路
        queue.add(beginWord);
       while(!queue.isEmpty()){
           int n =queue.size();
           for(int i=0;i<n;i++){
               String cur = queue.poll();
               if(cur.equals(endWord))
                   return step;
               Iterator it = set.iterator();
               while(it.hasNext()){
                   String tmp = (String)(it.next());
                   if(check(tmp,cur)){
                       queue.add(tmp);
                       it.remove();
                   }
               }
           }//for


           step++;
       }
        return 0;
    }

    //检查是否只差一个字母
    public boolean check(String s,String t){
        int cnt = 0;
        for(int i=0;i<s.length();i++)
          if(s.charAt(i)!=t.charAt(i))
              cnt++;
        return cnt==1;
    }
    public static void main(String args[]){
        String beginWord =  "hit";
        String endWord = "cog";
        List<String>wordList = new ArrayList<>();
        wordList.add("hot"); //"hot","dot","dog","lot","log","cog"
        wordList.add("dot"); wordList.add("dog"); wordList.add("lot"); wordList.add("cog");
        System.out.println(new Solution().ladderLength(beginWord,endWord,wordList));
    }
}