class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> templist= new ArrayList<>();
        if(n == 0 || k==0)return res;
        dfs(res,templist,1,n,k);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> templist, int start, int n , int k){
        if( k == 0)res.add(new ArrayList<>(templist));
        for(int i = start ; i<=n ;i++){
            templist.add(i);
            dfs(res,templist,i+1,n,k-1);
            templist.remove(templist.size()-1);
        }
    }
}
// dfs+search tree