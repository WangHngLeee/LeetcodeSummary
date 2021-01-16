class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return new int[0][]; // check corner case
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0 ;i<m;i++){
            for(int j=0 ;j<n ;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }else{
                    queue.add(new int[]{i,j});// add 0s position into queue
                }
            }
        }
        int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};// define move array
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size ;i++){
                int[] temp = queue.poll();
                for(int[] move : moves){
                    int x = temp[0] + move[0];
                    int y = temp[1] + move[1];
                    if(x<0 || x>=m ||y<0 || y>=n || matrix[x][y] != -1)continue; // only dfs for -1 position.
                    queue.add(new int[]{x,y});
                    matrix[x][y] = matrix[temp[0]][temp[1]]+1;
                }
            }
        }
        return matrix;
    }
}
//bfs。先把0的坐标加进queue，把不为零的位置值变为-1。
// 从外围往里扫描，如果更新后的位置不为-1，说明没有找到不为零的位置，继续扫描。
// 如果更新后的位置为-1，说明当前位置是0，所以把更新后位置的值变为当前位置+1，依次类推。