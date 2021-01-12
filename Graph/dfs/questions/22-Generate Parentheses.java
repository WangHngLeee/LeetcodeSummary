class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0)return res;
        help("",res,0,0,n);
        return res;
    }
    public void help(String cur, List<String> res, int open, int close ,int n){
        if(open == n & close == n)res.add(cur);
        if(open < n){
            help(cur + "(", res, open + 1, close, n);
        }
        if(close < open){
            help(cur+")",res,open,close+1,n);
        }
    }
}
// dfs 递归加左/右括号。当开/闭括号都为n个时，当前一种可能已经全部找到，加入res。