// DFS + backtracking
class Solution {
    int m,n;

    //79. Word SearchI
    https://leetcode.com/problems/word-search/

    public boolean exist_I(char[][] board, String word) {
        if(board == null || board.length == 0)return false;
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, 0, word))return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, int start, String word){
        if(start == word.length())return true;
        if(i >= 0 && j >= 0 && i < m && j < n && word.charAt(start) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            boolean res = dfs(board, i, j + 1, start + 1 , word) || dfs(board, i,j-1, start+1, word) || dfs(board, i-1, j, start + 1, word) || dfs(board, i+1, j, start + 1, word);
            board[i][j] = temp;
            return res;
        }
        return false;

    }

    //212. Word Search II
    https://leetcode.com/problems/word-search-ii/

    int m,n;
    List<String> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0)return res;
        m = board.length;
        n = board[0].length;
        for(String word : words){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(dfs(board,i,j,0,word)){
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int i, int j, int start, String word){
        if(start == word.length()){
            set.add(word);
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || word.charAt(start) != board[i][j] || set.contains(word))return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board,i+1,j,start+1,word) || dfs(board,i-1,j,start+1,word) ||
                dfs(board,i,j+1,start+1,word) || dfs(board,i,j-1,start+1,word);
        board[i][j] = temp;
        return res;
    }
}




}