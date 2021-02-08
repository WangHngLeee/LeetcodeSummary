//347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    // PriorityQueue
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if(nums == null || nums.length == 0)return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int key: map.keySet()){
            pq.add(key);
        }
        int idx = 0;
        while(!pq.isEmpty() && k-- > 0) {
            res[idx++]=pq.poll();
        }
        return res;
    }

    // Bucket Sort
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> freqToValues = new HashMap<>();

        for (int value : map.keySet()) {
            Integer freq = map.get(value);
            if (!freqToValues.containsKey(freq)) {
                freqToValues.put(freq, new ArrayList<>());
            }
            freqToValues.get(freq).add(value);
        }

        int[] result = new int[k];
        for (int freq = nums.length, index = 0; freq >= 0 && index < k; freq--) {
            if (freqToValues.containsKey(freq)) {
                List<Integer> values = freqToValues.get(freq);
                for (Integer value : values) {
                    result[index++] = value;
                    if (index == k) {
                        break;
                    }
                }
            }
        }
        return result;
    }