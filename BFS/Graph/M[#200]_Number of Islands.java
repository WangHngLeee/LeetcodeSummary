//200. Number of Islands
https://leetcode.com/problems/number-of-islands/

// BFS
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        m= grid.length;
        n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    queue.add(new int[]{i,j});
                    seen[i][j] = true;
                    bfs(queue,seen,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(Queue<int[]> queue, boolean[][] seen, char[][] grid){
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int[] dir : dirs){
                int x = temp[0] + dir[0];
                int y = temp[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1' && !seen[x][y]){
                    seen[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}