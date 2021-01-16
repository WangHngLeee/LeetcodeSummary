//57. Insert Interval
https://leetcode.com/problems/insert-interval/

class Solution {
    public int[][] insert(int[][] intvs, int[] newintv) {
        List<int[]> res = new ArrayList<>();
        for(int[] intv : intvs){
            if(newintv[1] < intv[0]){
                res.add(newintv);
                newintv = intv;
            }else if(newintv[0] > intv[1]){
                res.add(intv);
            }else{
                newintv[0] = Math.min(newintv[0], intv[0]);
                newintv[1] = Math.max(newintv[1], intv[1]);
            }
        }
        res.add(newintv);
        return res.toArray(new int[0][]);
    }
}


