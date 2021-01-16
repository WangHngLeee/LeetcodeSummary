class Solution {
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0)return 0;
        int m = A.length;
        int n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        boolean find = false;
        int steps=0;
        int[][] moves = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0 ;i<m ;i++){
            if(find)break;
            for(int j=0 ; j<n ;j++){
                if(A[i][j] == 1){
                    dfs(A,seen,queue,i,j,moves);
                    find = true;
                    break;
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size ;i++){
                int[] temp = queue.poll();
                for(int[] move : moves){
                    int x = temp[0] + move[0];
                    int y = temp[1] + move[1];
                    if(x>=0 && x<m && y>=0 && y<n && !seen[x][y] ){
                        if(A[x][y] == 1)return steps;
                        queue.add(new int[]{x,y});
                        seen[x][y] = true;

                    }
                }
            }
            steps++;

        }
        return -1;

    }
    public void dfs(int[][] A, boolean[][] seen, Queue<int[]> queue, int i, int j,int[][] moves){
        if(i<0 || j<0 || i>=A.length || j>=A[0].length || seen[i][j] || A[i][j]== 0)return;
        seen[i][j] = true;
        queue.add(new int[]{i,j});
        for(int[] move : moves){
            dfs(A,seen,queue,i+move[0],j+move[1],moves);
        }
    }
}
// 详解请前往leeemask.com搜索题目号即可。