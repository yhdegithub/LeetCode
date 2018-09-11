//写不下去。参考下思路 ，先用差距只有1的字符串构造一个树 ，在对树使用回溯法找到路径
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
		if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return res;
		Set<String> dic = new HashSet<>(wordList);
		if (!dic.contains(endWord)) return res;
		
		Map<String, List<String>> edges = new HashMap<>();
		
		Set<String> froms = new HashSet<>(), tos = new HashSet<>();
		froms.add(beginWord);
		dic.remove(beginWord);
		tos.add(endWord);
		dic.remove(endWord);
		bfs(froms, tos, dic, edges, false);
		buildRes(beginWord, endWord, edges, new ArrayList<String>(), res);
		return res;
    }
	
	private void bfs(Set<String> froms, Set<String> tos, Set<String> dic, Map<String, List<String>> edges, boolean isReversed) {
		if (froms.size() == 0 || tos.size() == 0) return;
		if (froms.size() > tos.size()) {
			bfs(tos, froms, dic, edges, !isReversed);
            return;
		}
		Set<String> nexts = new HashSet<>();
		boolean met = false;
		for (String from : froms) {
			char[] chs = from.toCharArray();
			for (int i = 0; i < chs.length; ++i) {
				char origin = chs[i];
				for (char c = 'a'; c <= 'z'; ++c) {
					chs[i] = c;
					String next = new String(chs);
					if (tos.contains(next)) {
						met = true;						
					}
					
					if (tos.contains(next) || dic.contains(next)) {
						String left = isReversed ? next : from;
						String right = isReversed ? from : next;
						edges.putIfAbsent(left, new ArrayList<String>());
						edges.get(left).add(right);
						nexts.add(next);
					}
				}
				chs[i] = origin;
			}
		}
        dic.removeAll(nexts);
		if (!met) {
			bfs(nexts, tos, dic, edges, isReversed);
		}
	}
	
	private void buildRes(String beginWord, String endWord, Map<String, List<String>> edges, List<String> cur, List<List<String>> res) {
		cur.add(beginWord);
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<String>(cur));
		}
		List<String> neibs = edges.get(beginWord);
        if (neibs != null && neibs.size() > 0) {
			for (String neib : neibs) {
				buildRes(neib, endWord, edges, cur, res);
			}
		}
		cur.remove(cur.size() - 1);
	}
}