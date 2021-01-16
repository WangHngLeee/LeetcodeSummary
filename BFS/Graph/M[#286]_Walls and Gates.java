//286. Walls and Gates
https://leetcode.com/problems/walls-and-gates/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0)return;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0)queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int[] dir : dirs){
                int x = dir[0] + temp[0];
                int y = dir[1] + temp[1];
                if(x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE)continue;
                rooms[x][y] = rooms[temp[0]][temp[1]] + 1;
                queue.add(new int[]{x,y});
            }
        }
    }
}