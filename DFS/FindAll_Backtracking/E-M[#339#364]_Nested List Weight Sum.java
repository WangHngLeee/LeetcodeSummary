//339. Nested List Weight Sum
https://leetcode.com/problems/nested-list-weight-sum/description/

class Solution {
    public int depthSum(List<NestedInteger> n) {
        if(n == null || n.size() == 0)return 0;
        return dfs(n,1);
    }
    public int dfs(List<NestedInteger> n, int level){
        int sum = 0;
        for(NestedInteger num : n){
            if(num.isInteger()){
                sum += level * num.getInteger();
            }else{
                sum += dfs(num.getList(), level + 1);
            }
        }
        return sum;
    }
}


//364. Nested List Weight Sum II
https://leetcode.com/problems/nested-list-weight-sum-ii/description/

// II 和 I 互换了list和Integer的权重顺序，II里需要首先获得整体的深度depth，然后由深往浅遍历。

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)return 0;
        int depth = getDepth(nestedList);
        int res = getSum(nestedList,depth);
        return res;
    }
    public int getSum(List<NestedInteger> list,int depth){
        int sum = 0;
        for(NestedInteger num : list){
            if(num.isInteger()){
                sum+=num.getInteger() * depth;
            }else{
                sum+=getSum(num.getList(), depth-1);
            }
        }
        return sum;
    }
    public int getDepth(List<NestedInteger> nestedList){
        int max = 0;
        for(NestedInteger num : nestedList){
            if(num.isInteger()){
                max = Math.max(max,1);
            }else{
                max = Math.max(getDepth(num.getList())+1,max);
            }
        }
        return max;
    }
}