/**
 *  方法 1) 用一个map<Integer,list<String>> ,保存每个长度的字符串数组 ， 添加一个长度为n的单词，就加入到map.get(n)之中 ， 查找时候也是根据查找
 *            单词target的长度 ，找到对应list，在list之中查找
 *
 *       2）当然最简单的是trie树
 */
import java.util.*;
class WordDictionary {
    /**
     * Initialize your data structure here.
     */
    class Node {
        int num = 1; //经过此结点的单词数目
        int isEnd = 0;  //以此结尾的单词数目
        char val;       //节点的所存储的关键值
        Node child[] = new Node[26];  //26个分支
    }

    Node root;  //全局变量用 ， 不存值

    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    boolean empty = false;

    public void addWord(String word) {
        if (word == null)
            return;
        if (word.length() == 0) {
            empty = true;
            return;
        }

        Node cur = root;
        for (char c : word.toCharArray()) {
            int pos = c - 'a';
            if (cur.child[pos] == null) {
                cur.child[pos] = new Node();
                cur.child[pos].val = c;
            } else
                cur.child[pos].num++;
            cur = cur.child[pos];
        }
        cur.isEnd++;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
    if(word==null)  return false;
    if(word.length()==0)   return empty;
      return find(word ,0,root);
    }
    //查找,递归
    public boolean find(String word,int start , Node cur ){
        //出口
        if(start>=word.length()){
            if(cur.isEnd!=0)
                return true;
            else
                return false;
        }
        //递归子情况
        char ch = word.charAt(start);
        int pos =ch - 'a';
        if(ch!='.'){
            if(cur.child[pos]==null)
                return false;
            else
                return find(word,start+1,cur.child[pos]);

        }else{         // '.' 可以匹配任意字符
           for(int i=0;i<26;i++){   //广度优先
               if(cur.child[i]==null)  continue;
               if(find(word,start+1,cur.child[i]))
                   return true;
           }

        }

    return false;
    }



}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */