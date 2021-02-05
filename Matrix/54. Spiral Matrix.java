//54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/

// 4 directions. remember the boundary conditions.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new  ArrayList<>();
        if(matrix == null || matrix.length == 0)return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = m - 1;
        while(res.size() < m * n){
            for(int i= left; i<= right && res.size() < m * n; i++){
                res.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= down-1 && res.size() < m * n; i++){
                res.add(matrix[i][right]);
            }
            for(int i = right; i>=left && res.size() < m * n; i--){
                res.add(matrix[down][i]);
            }
            for(int i = down - 1; i>=top + 1 && res.size() < m * n; i--){
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }
    public int[][] sprialOrderII(int[][] matrix){
        int[][] res = new int[n][n];
        int cur = 1;
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        while( cur <= n*n ){
            int i = top;
            int j = colbegin;
            for(j = colbegin; j<= right;j++){
                res[top][j] = cur;
                cur++;
            }
            top++;

            for(i = top; i<=down;i++){
                res[i][right] = cur;
                cur++;
            }
            right--;

            for(j= right;j>=colbegin;j--){
                res[down][j] = cur;
                cur++;
            }
            down--;

            for(i = down;i>=top;i--){
                res[i][colbegin]=cur;
                cur++;
            }
            colbegin++;

        }
        return res;
    }
}