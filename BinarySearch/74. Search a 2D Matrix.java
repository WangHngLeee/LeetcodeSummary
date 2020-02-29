class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)return false;
        if(matrix[0].length == 0)return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row*col-1;
        while(start + 1< end){
            int mid = start + (end - start)/2;
            if(matrix[mid/col][mid%col] == target)return true;
            else if (matrix[mid/col][mid%col] < target)start = mid;
            else{
                end = mid;
            }
        }
        if(matrix[start/col][start%col] == target)return true;
        else if (matrix[end/col][end%col] == target)return true;
        else return false;
    }
}
//当成一个数组二分查找。注意col和数组index的关系。都用col来比较。