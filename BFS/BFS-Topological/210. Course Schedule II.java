class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int[] pair : prerequisites){
            indegree[pair[0]]++;
        }
        for(int i = 0 ;i<indegree.length ;i++){
            if(indegree[i] == 0){
                queue.add(i);
                res[index] = i;
                index++;
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int[] pair : prerequisites){
                if(pair[1] == course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        queue.add(pair[0]);
                        res[index] = pair[0];
                        index++;
                    }
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
//和course schedule 一样的思路。只不过这道题要求按顺序输出课程顺序，只需要维护一个res并且更新index，不断加入indegree为0的课程即可。
