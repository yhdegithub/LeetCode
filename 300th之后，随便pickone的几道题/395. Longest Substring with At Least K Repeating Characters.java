/**
*
*一，用HashMap找到每个字母出现的次数；

二，如果每个字母出现的次数都不小于k，那么直接返回s的长度即可，否则，如果一个字母出现次数小于k，那T一定不包含这个字符，那么就可以以出现次数小于k的字母作为分隔符；

三，将分割后的子字符串重复步骤一，二。
*
*/
class Solution {
    public int longestSubstring(String s, int k) {
        //map用于记录每个character出现的次数
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		
		Character seg=null;
		for(int i=0;i<s.length();i++){
			if(map.get(s.charAt(i))<k){
				seg = s.charAt(i);
			}
		}
		
		if(seg==null){return s.length();}
		
		int max_len=0;
		String [] splits = s.split(""+seg);
		for(String str:splits){
			max_len = Math.max(max_len, longestSubstring(str, k));
 
		}
		
		return max_len;

    }
}