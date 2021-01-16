//56. Merge Intervals
https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals == null || intervals.length == 0)return new int[0][];
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] intv : intervals){
            if(end >= intv[0]){
                end = Math.max(end, intv[1]);
            }else{
                res.add(new int[]{start,end});
                start = intv[0];
                end = intv[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
