class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0)return -1;
        int left= 0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left,w);
            right+=w;
        }
        while(left < right){
            int mid = left + (right-left)/2;
            int cur = 0;
            int need = 1;
            for(int w : weights){
                if(cur+w > mid){
                    need++;
                    cur = 0;
                }
                cur+=w;
            }
            if(need > D)left = mid + 1;
            else right = mid;
        }
        return left;
    }
}//有趣的一道题。right上限为货物总重，然后二分找在给定天数内搬完所有的最小日均量。
// 首先定义cur来存暂时的总搬运量，如果大于了假定的mid值，则需要多一天，并且重新归零cur值，进行下一次，否则cur一直增加。最后判断需要的天数和D的关系即可。