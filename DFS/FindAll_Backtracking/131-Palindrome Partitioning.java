class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> templist = new ArrayList<>();
        if(s == null || s.length() == 0)return res;
        help(res,templist,0,s);
        return res;
    }
    public void help(List<List<String>> res, List<String> templist, int start, String s){
        if(start == s.length())res.add(new ArrayList<>(templist));
        else{
            for(int i = start ;i < s.length() ; i++){
                if(valid(s,start,i)){
                    templist.add(s.substring(start,i+1));
                    help(res,templist,i+1,s);
                    templist.remove(templist.size()-1);
                }
            }
        }
    }
    public boolean valid(String s, int left, int right){
        while( left <= right){
            if(s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}
// 经典dfs+backtracking思路。
