class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)return false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0 ;i<m;i++){
            for(int j=0 ;j<n;j++){
                if(dfs(board,word,i,j,0))return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word, int i, int j, int start){
        if(start == word.length())return true;
        if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j] != word.charAt(start))return false;
        board[i][j] = '@';
        boolean res = dfs(board,word,i+1,j,start+1)||
                dfs(board,word,i,j+1,start+1)||
                dfs(board,word,i-1,j,start+1)||
                dfs(board,word,i,j-1,start+1);
        board[i][j] = word.charAt(start);
        return res;
    }
}
// dfs找所有的可能，如果存在则直接返回true。
// dfs里先判断当前start和board[i][j]是否相同。如果相同则backtracking去找所有的可能性。返回最终的所有结果里的可能性。