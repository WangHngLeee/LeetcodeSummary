class Solution {
    int res = 0;
    public int totalNQueens(int n){
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n*2];
        boolean[] diag2 = new boolean[n*2];
        dfs(0,n,col,diag1,diag2);
        return res;
    }
    public void dfs(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(row == n){
            res++;
            return;
        }
        for(int j=0 ;j<n ;j++){
            if(!col[j] && !diag1[j+row] && !diag2[j - row + n-1]){
                col[j] = diag1[j+row] = diag2[j-row+n-1] = true;
                dfs(row+1,n,col,diag1,diag2);
                col[j] = diag1[j+row] = diag2[j-row+n-1] = false;
            }
        }
    }
}
// 三个方向boolean数组，三个方向都false，即没有Q存在，则可以继续递归，注意dfs前先把该位置变为true。
// 如果有则跳过。最后backtracking回false，没有的情况