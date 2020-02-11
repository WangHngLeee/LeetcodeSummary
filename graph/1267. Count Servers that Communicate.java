class Solution {
    public int countServers(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int total = 0;
        for(int i=0 ;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                if(grid[i][j] == 1){
                    row[i]+=1;
                    col[j]+=1;
                    total++;
                }
            }
        }
        for(int i=0 ;i<m;i++){
            for(int j=0 ;j<n;j++){
                if(grid[i][j] == 1){
                    if(row[i] == 1 && col[j] == 1){
                        total--;
                    }
                }
            }
        }
        return total;
    }
}
// col 和 row用来记录这一行有多少个电脑，如果最后某个位置为电脑并且所在的行和列都只有1个，那么就是没有连接的，要从total里减去。