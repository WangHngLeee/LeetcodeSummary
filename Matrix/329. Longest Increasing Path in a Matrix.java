//329. Longest Increasing Path in a Matrix
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

// Classic memo+DFS

class Solution {

    int[][] memo;
    int m, n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return 0;
        int res = Integer.MIN_VALUE;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cur = dfs(matrix, i, j);
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j){
        if(memo[i][j] != 0)return memo[i][j];
        int max = 1;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x <0 || x>= m || y <0 || y>=n || matrix[i][j] >= matrix[x][y])continue;
            max = Math.max(max,dfs(matrix, x, y) + 1);
        }
        memo[i][j] = max;
        return max;
    }
}