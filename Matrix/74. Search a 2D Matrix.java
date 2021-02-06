//74. Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    // regard the matrix as a single array and using Binary Search
    //
    //1   3  5  7
    //10 11 16 20
    //23 30 34 60

    public boolean searchMatrix_I(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)return true;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right){
            int mid = left + ( right - left ) / 2;
            if(matrix[mid/n][mid%n] == target ) return true;
            else if(matrix[mid/n][mid%n] < target)left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix_II(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)return true;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        while(left < m && right >= 0){
            if(matrix[left][right] == target)return true;
            else if(matrix[left][right] < target)left++;
            else right--;
        }
        return false;
    }
}