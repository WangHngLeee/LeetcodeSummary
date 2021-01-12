class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length == 0 || connections == null)return -1;
        if(connections.length < n-1)return -1;
        int[] parents = new int[n];
        for(int i =0;i<parents.length ;i++){
            parents[i] = i;
        }
        int remain = n;
        for(int[] link : connections){
            int root1 = find(parents,link[0]);
            int root2 = find(parents, link[1]);
            if( root1 != root2){
                remain--;
                parents[root1] = root2;
            }
        }
        return remain -1;
    }
    public int find(int[] parents, int a){
        if(parents[a] == a)return a;
        return parents[a] = find(parents, parents[a]);
    }
}
// union find。记录remains剩下没连接的个数，所以最后最少数量是剩下的个数-。