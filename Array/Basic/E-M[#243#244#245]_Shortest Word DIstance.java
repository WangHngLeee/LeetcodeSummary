// Easy-243. Shortest Word Distance
// https://leetcode.com/problems/shortest-word-distance/

// 找到word1和word2对应的index，然后取最小的差值。
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1))p1 = i;
            if(words[i].equals(word2))p2 = i;

            if(p1 != -1 && p2 != -1){
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}


//Medium-OOD-244. Shortest Word Distance II

// https://leetcode.com/problems/shortest-word-distance-ii/

// 用map将所有word1和word2出现的坐标存下，然后针对各自的坐标集合扫描，找出最短的distance。
class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(!map.containsKey(words[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(words[i], temp);
            }else{
                map.get(words[i]).add(i);
            }
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i=0, j=0; i<l1.size() && j < l2.size();){
            int idx1 = l1.get(i);
            int idx2 = l2.get(j);
            if(idx1 < idx2){
                res = Math.min(res, idx2 - idx1);
                i++;
            }
            else{
                res = Math.min(res, idx1 - idx2);
                j++;
            }
        }
        return res;
    }
}


//Medium - 245. Shortest Word Distance III
// https://leetcode.com/problems/shortest-word-distance-iii/description/

// modified from sortest word distance I
// change two if to if and else if
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0)return 0;
        int p1 = -1;
        int p2 = -1;
        boolean same = word1.equals(word2);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                if(same)p2 = p1;
                p1 = i;
            }
            else if(words[i].equals(word2))p2 = i;
            if(p1 != -1 && p2 != -1){
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}

