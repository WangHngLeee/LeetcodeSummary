//320. Generalized Abbreviation
https://leetcode.com/problems/generalized-abbreviation/


public class Solution {
    List<String> ans = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateAbbreviations(String word){
        backtrack(word, 0, 0);
        return ans;
    }

    private void DFS_back(String word, int i, int count){
        int len = sb.length();
        if(i == word.length()){
            if (count != 0) sb.append(k);
            ans.add(sb.toString());
        } else {

            // 继续忽略当前char，count+1
            DFS_back(word, i + 1, count + 1);

            // 不忽略当前char，先将前面忽略掉掉char个数count加到sb，然后将当前char加入sb，继续dfs
            if (count != 0) sb.append(k);
            sb.append(word.charAt(i));
            DFS_back(word, i + 1, 0);
        }
        sb.setLength(len); // 回溯
    }
}