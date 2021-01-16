class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S,res,0);
        return res;
    }
    public boolean dfs(String s, List<Integer> res, int start){
        if(start == s.length() && res.size() > 2)return true;
        for(int i = start ;i<s.length() ;i++){
            if(s.charAt(start)== '0' && i>start)break;
            long num = Long.parseLong(s.substring(start,i+1));
            if(num > Integer.MAX_VALUE)break;
            int size = res.size();
            if(size >= 2 && num>res.get(size-1) + res.get(size-2))break;
            if(size<=1 || num == res.get(size-1) + res.get(size-2)){
                res.add((int)num);
                if(dfs(s,res,i+1)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }
}
// 经典dfs。要求斐波那契数列，所以res的大小至少为2的时候，待加入的num必须为前两个之和。并且0只能作为0单独使用，
// 如果s charat start是0，那必须只能该位置可以用，后面的位置都不能用0。注意隐藏条件，num还不能大于Integer.MAX_VALUE。