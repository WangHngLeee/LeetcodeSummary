//48. Rotate Image
https://leetcode.com/problems/rotate-image/

// rotate matrix 一般两种方法 ：
// 1。 顺时针
//     first reverse up to down, then swap the symmetry
//     1 2 3     7 8 9     7 4 1
//     4 5 6  => 4 5 6  => 8 5 2
//     7 8 9     1 2 3     9 6 3

// 2。逆时针
//     first reverse left to right, then swap the symmetry
//     1 2 3     3 2 1     3 6 9
//     4 5 6  => 6 5 4  => 2 5 8
//     7 8 9     9 8 7     1 4 7


class Solution {
    // clockwise
    public void rotate_clockwise(int[][] matrix) {
        int start = 0, end = matrix.length -1;
        while( start < end){
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        for(int i=0; i< matrix.length; i++){
            for(int j=i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // anti-clockwise
    public void rotate_anticlockwise(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int start = 0, end = n-1; start < end; start ++, end--){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }
        for(int i=0; i< matrix.length; i++){
            for(int j=i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

