class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(k == 0 || n == 0)return res;// corner case

        help(res,list,1,k,n);
        return res;
    }
    public void help(List<List<Integer>> res, List<Integer> list, int start, int k, int n){
        if(list.size() == k && n == 0){
            res.add(new ArrayList<>(list)); // match the requirement, add list to res;
        }
        for(int i = start ;i<=9;i++){
            list.add(i);
            help(res,list,i+1,k,n-i);
            list.remove(list.size()-1);// backtracking
        }
    }
}