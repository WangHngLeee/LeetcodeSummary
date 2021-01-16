class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(int i=0 ;i<n;i++){
            for(int j=0 ;j<n;j++){
                chess[i][j] = '.';
            }
        }
        dfs(chess,0,res);
        return res;
    }
    public void dfs(char[][] chess, int row, List<List<String>> res){
        if(row == chess.length){
            res.add(build(chess));
            return;
        }
        for(int col = 0 ;col < chess.length;col++){
            if(valid(chess,row,col)){
                chess[row][col] = 'Q';
                dfs(chess,row+1,res);
                chess[row][col] = '.';
            }
        }
    }
    public boolean valid(char[][] chess, int row, int col){
        for(int i = 0 ; i<row ; i++){
            if(chess[i][col] == 'Q')return false;
        }
        for(int i = row-1, j = col-1 ; i>=0 && j>=0 ; j--,i--){
            if(chess[i][j] == 'Q')return false;
        }
        for(int i = row-1,j=col+1;i>=0 &&j<chess.length; i--,j++){
            if(chess[i][j] == 'Q')return false;
        }
        return true;
    }
    public List<String> build(char[][] chess){
        List<String> temp = new ArrayList<>();
        for(int i=0 ; i<chess.length ;i++){
            temp.add(new String(chess[i]));
        }
        return temp;
    }
}
// dfs backtracking 检查所有结果里可以放置的情况，加入res，最后返回。
// 检查valid里，检查三个方向。由于我们是根据row从上到下检查，只需要检查0到当前的row之间有无Q，正/斜对角线有无Q，均到当前row为止即可。