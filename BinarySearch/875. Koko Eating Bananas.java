class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles == null || piles.length == 0)return -1;
        int start = 1;
        int end = getmax(piles);
        while(start + 1 < end){
            int mid = start + ( end - start)/2;
            if(caneatall(piles,H,mid))end = mid;
            else{
                start = mid;
            }
        }
        if(caneatall(piles,H,start))return start;
        else return end;
    }
    public boolean caneatall(int[] piles, int H, int start){
        int count = 0;
        for(int pile : piles){
            count+=pile/start;
            if(pile%start!=0)count++;
        }
        return count<= H;
    }
    public int getmax(int[]piles){
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            if(pile > max){
                max = pile;
            }
        }
        return max;
    }
}
// 二分发找per hour的消耗量。
// 先找到piles里最大值作为消耗速率，判断当前rate能否在给定小时内消耗完所有piles。
// 如果可以则将rate降低1，如此循环找到最小值。