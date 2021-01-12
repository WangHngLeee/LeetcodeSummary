//Hard

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.get(0).size() == 0)return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] moves = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i= 0 ;i<m;i++){
            for(int j=0 ;j<n;j++){
                if(forest.get(i).get(j) > 1){
                    pq.add(new int[]{i,j,forest.get(i).get(j)});
                }
            }
        }
        int sum = 0;
        int[] start = new int[2];
        while(!pq.isEmpty()){
            int[] tree = pq.poll();
            int step = getmin(forest,start,tree,m,n,moves);
            if(step == -1)return -1;
            sum+=step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }
    public int getmin(List<List<Integer>> forest, int[] start, int[] tree, int m, int n, int[][]moves){
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        seen[start[0]][start[1]] = true;
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size ;i++){
                int[] temp = queue.poll();
                if(temp[0] == tree[0] && temp[1] == tree[1])return step;
                for(int[] move : moves){
                    int x = temp[0]+move[0];
                    int y = temp[1]+move[1];
                    if(x>=0 && x< m && y>=0 && y<n && !seen[x][y] && forest.get(x).get(y)!= 0){
                        queue.add(new int[]{x,y});
                        seen[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// 详解请前往leeemask.com搜索题目号即可。