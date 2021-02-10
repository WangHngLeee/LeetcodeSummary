//332. Reconstruct Itinerary

https://leetcode.com/problems/reconstruct-itinerary/


// DFS
class Solution {
    List<String> res;
    Map<String, PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for(List<String> t : tickets){
            String start = t.get(0);
            String end = t.get(1);
            map.putIfAbsent(start, new PriorityQueue<>());
            map.get(start).add(end);
        }
        dfs("JFK");
        return res;
    }
    private void dfs(String start){
        PriorityQueue<String> temp = map.get(start);
        while(temp != null && !temp.isEmpty()){
            String next = temp.poll();
            dfs(next);
        }
        res.add(0,start);
    }

}