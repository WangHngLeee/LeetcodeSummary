class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int[] pair : prerequisites){
            indegree[pair[0]]++;
        }
        for(int i=0 ;i<indegree.length ;i++){
            if(indegree[i] == 0)queue.add(i);
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            for(int[] pair : prerequisites){
                if(pair[1] == course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        queue.add(pair[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}

// toplogical sort.按照课程顺序增加indegree。然后从indegree0的开始遍历。判断最后课程是否为零。