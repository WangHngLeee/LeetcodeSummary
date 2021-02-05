
//378. Kth Smallest Element in a Sorted Matrix
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {

//    class pq top k solution
     public int kthSmallest_PQ(int[][] matrix, int k) {
         if(matrix == null || matrix.length == 0)return 0;
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
         int m = matrix.length;
         int n = matrix[0].length;
         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 pq.offer(matrix[i][j]);
                 if(pq.size() > k){
                     pq.poll();
                 }
             }
         }
         return pq.peek();
     }

// using binary search
    public int kthSmallest_BinarySearch(int[][] matrix, int k) {
        if(matrix == null || matrix[0].length == 0)return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m-1][n-1];
        while(min < max){
            int mid = min + (max - min)/2;
            int count = 0, j = n-1;
            for(int i=0; i<m; i++){
                while(j>=0 && matrix[i][j] > mid)j--;
                count+=j+1;
            }
            if(count < k)min = mid+1;
            else max = mid;
        }
        return min;
    }
}
