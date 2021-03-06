//130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/

class Solution {
    int m,n;
    public void solve(char[][] board) {
        if(board == null || board.length == 0)return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    private void helper(char[][] board, int r, int c) {
        if (r >= 0 && c >= 0 && r <= board.length - 1 && c <= board[0].length - 1 && board[r][c] == 'O'){
            board[r][c] = '1';
            helper(board, r + 1, c);
            helper(board, r - 1, c);
            helper(board, r, c + 1);
            helper(board, r, c - 1);

        }
    }
}