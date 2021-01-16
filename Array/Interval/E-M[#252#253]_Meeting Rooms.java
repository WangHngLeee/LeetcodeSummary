//252. Meeting Rooms
https://leetcode.com/problems/meeting-rooms/


class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return true;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1])return false;
        }
        return true;
    }
}



// 253. Meeting Rooms II
https://leetcode.com/problems/meeting-rooms-ii/description/

//Method 1
// 将start和end分别提出sort，然后各自loop
class Solution {
    public int minMeetingRooms(int[][] in) {
        if(in == null || in.length == 0)return 0;
        int[] start = new int[in.length];
        int[] end = new int[in.length];
        int rooms = 0;
        for(int i=0; i<in.length; i++){
            start[i] = in[i][0];
            end[i] = in[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIdx = 0;
        for(int i=0; i<start.length; i++){
            if(start[i] >= end[endIdx]){
                endIdx++;
            }else if(start[i] < end[endIdx]){
                rooms++;
            }
        }
        return rooms;
    }
}

//Method 2
// 额外数组记录每个时间点active的个数，start点+1，end点-1。
class Solution {
    public int minMeetingRooms(int[][] in) {
        int maxtime = -1;
        for(int i=0; i<in.length; i++){
            maxtime = Math.max(maxtime, Math.max(in[i][0], in[i][1]));
        }
        int[] slot = new int[maxtime+1];
        Arrays.sort(in, (a,b) -> a[0] - b[0]);
        for(int i=0; i<in.length; i++){
            slot[in[i][0]] +=1;
            slot[in[i][1]] -=1;
        }
        int max = 0;
        int sum = 0;
        for(int i=0; i<slot.length; i++){
            sum += slot[i];
            if(sum > max)max = sum;
        }
        return max;
    }
}

// Method3 --- Method2 用TreeMap实现
//利用了treemap自动按照key排序优点，省去了自建new array并从0往后扫描。

class Solution {
    public int minMeetingRooms(int[][] in) {
        Arrays.sort(in, (a,b) -> a[0] - b[0]);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<in.length; i++){
            int start = in[i][0];
            int end = in[i][1];
            map.put(start, map.getOrDefault(start,0)+1);
            map.put(end, map.getOrDefault(end,0)-1);
        }
        int max = 0;
        int sum = 0;
        for(int key : map.keySet()){
            sum += map.get(key);
            if(sum > max)max = sum;
        }
        return max;
    }
}