//22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/description/

// using counter to record open/close parentheses.
// then using DFS find all method to get all possible results.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0)return res;
        help("",n,0,0,res);
        return res;
    }

    public void help(String temp, int n, int open, int close, List<String> res){
        if(open == n && close == n){
            res.add(temp);
            return;
        }
        if(open < n){
            help(temp + "(",n,open+1,close,res);
        }
        if(close < open){
            help(temp + ")",n,open,close+1,res);
        }
    }
}
