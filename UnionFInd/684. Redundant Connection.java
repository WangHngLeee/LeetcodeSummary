class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        for(int i = 0 ;i<edges.length ;i++){
            parents[i] = i;
        }
        for(int[] link : edges){
            int root1 = find(parents,link[0]);
            int root2 = find(parents,link[1]);
            if(root1 == root2){
                return link;
            }
            parents[root1] = root2;
        }
        return new int[]{};
    }
    public int find(int[] parents, int i){
        if(i == parents[i])return i;
        return parents[i] = find(parents,parents[i]);
    }
}
// union find 。 如果找到两个点root一样，则说明之前已经link过，是多余的，直接返回。