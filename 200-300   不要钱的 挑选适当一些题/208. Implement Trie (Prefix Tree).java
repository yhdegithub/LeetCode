import java.util.*;

class Trie {
    /** Initialize your data structure here. */
    //定义结点
     class Node{
         int num = 1;   //有几个单词路过此结点
         char val ;  //结点值
        Node child[] = new Node[26];  //26个分支
        int isEnd = 0;              //以此结尾的单词个数
    }
    Node root;  //根节点  ，不存储val，相当于链表的dummy结点
    public Trie() {
       root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if(word==null || word.length()==0)
          return ;
      int n =word.length();
      Node cur = root;
      for(int i=0;i<n;i++){
         int pos = word.charAt(i) -'a';
         if(cur.child[pos]==null){   //定义新的结点了
             cur.child[pos] = new Node();
             cur.child[pos].val = word.charAt(i);
         }else                   //经过此节点的单词数目 ++
             cur.child[pos].num++;
         cur = cur.child[pos];
      }
      cur.isEnd++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         if(word==null || word.length()==0)
             return false;
         int n =word.length();
         Node cur = root;
         for(int i=0;i<n;i++){
             int pos = word.charAt(i) -'a';
             if(cur.child[pos]==null)
                 return false;
             else
                 cur = cur.child[pos];
         }
         return cur.isEnd!=0;
    }
    //某个单词出现次数
    public int find(String word) {
        if(word==null || word.length()==0)
            return 0;
        int n =word.length();
        Node cur = root;
        for(int i=0;i<n;i++){
            int pos = word.charAt(i) -'a';
            if(cur.child[pos]==null)
                return 0;
            else
                cur = cur.child[pos];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
           int cnt = getPrefix(prefix);
           return cnt!=0;
    }
    public int getPrefix(String prefix){
        if(prefix==null || prefix.length()==0)
            return 0;
        int m =prefix.length();
        Node cur = root;
        for(int i=0;i<m;i++){
            int pos = prefix.charAt(i) -'a';
            if(cur.child[pos]==null)
                return 0;
            cur = cur.child[pos];
        }
        return cur.num;
    }
    //测试
    public static void main(String args[]) {
        String word[] = {"acm", "ac","bac","banana", "band", "bac", "accer", "absolute", "bee","acm", "acmer"};
        String prefix[] = {"ban", "ba","bananaf", "ac", "acm", "b", "a"};
        String target[] = {"ban", "band", "acme","ac", "acm", "bace"};
        Trie t = new Trie();
        System.out.println("---------建立字典树----------\n");
        for(int i=0;i<word.length;i++)
            t.insert(word[i]);
        System.out.println("-----单词存在情况-----\n");
      for(int i=0;i<target.length;i++)
          System.out.println(" 单词 "+ target[i] + "  出现了吗？ " + t.search(target[i]) + "  出现次数  " + t.find(target[i]));
        System.out.println("\n-------是否有此前缀--------\n");
        for(int i=0;i<prefix.length;i++)
            System.out.println(" 前缀 " + prefix[i] +  "出现没？ " + (t.getPrefix(prefix[i])!=0) +  "  有几个前缀  " + t.getPrefix(prefix[i]));
    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */