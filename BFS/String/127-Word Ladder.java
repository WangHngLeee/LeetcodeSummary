class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();queue.add(beginWord);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size ;i++){
                String temp = queue.poll();
                for(int j=0 ;j<temp.length();j++){
                    char[] chs = temp.toCharArray();
                    for(char c = 'a' ;c<= 'z' ;c++){
                        chs[j] = c;
                        String newword = new String(chs);
                        if(set.contains(newword)){
                            if(newword.equals(endWord))return step+1;
                            set.remove(newword);
                            queue.add(newword);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
// 对每个位置进行26次替换，判断set里有无当前newword的备选项，如果有则去掉该备选，加入queue等待bfs。
// 如果直接等于最后的endword返回step+1；