//218. The Skyline Problem
https://leetcode.com/problems/the-skyline-problem/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        // height list to store all buildings' heights

        for(int[] h : buildings){
            height.add(new int[]{h[0],-h[2]}); // start of a building, height stored as negtive
            height.add(new int[]{h[1],h[2]}); // end of a building, height stored as positive
        }
        Collections.sort(height,(a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // sort the height list

        // a pq that stores all the encountered buildings' heights in descending order
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a)); // max heap;
        queue.offer(0);

        int prev = 0;
        for(int[] h : height){
            if(h[1]<0){
                queue.add(-h[1]);// h[1] < 0, that means it meets a new building, so add it to pq
            }else{
                queue.remove(h[1]);// h[1] >=0, that means it has reached the end of the building, so remove it from pq
            }
            // the current max height in all encountered buildings
            int cur = queue.peek();

            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if(cur != prev){
                res.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return res;
    }
}
one, that means a critical point is met, add to result list