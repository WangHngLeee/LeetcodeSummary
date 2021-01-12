class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int size = graph.length;
        int[] state = new int[size];
        for(int i=0 ;i<size ;i++){
            if(dfs(graph,i,state))res.add(i);
        }
        return res;
    }
    public boolean dfs(int[][] graph, int num, int[] state){
        if(state[num] != 0)return state[num] == 1;
        state[num] = 2;
        for(int n : graph[num]){
            if(!dfs(graph,n,state))return false;
        }
        state[num] = 1;
        return true;
    }
}
// dfs. 目的是找到一个num，它不能跳转到别的数字。方法是找数组里的cycle。
// 每个数有三种state，1-unvisited, 2- safe, 3-unsafe.
// 如果当前的num存在cycle或者num能到达的数里存在cycle，则该数不安全，状态为2. 如果没有cycle，则是安全的。dfs递归做就可以。
