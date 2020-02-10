class Solution {
    public int openLock(String[] deadends, String target){
        Set<String> deads = new HashSet<>();
        for(String dead : deadends){
            deads.add(dead);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size ;i++){
                String temp = queue.poll();
                if(deads.contains(temp))continue;
                if(temp.equals(target))return step;
                for(int j=0 ;j<4;j++){
                    char c = temp.charAt(j);
                    String s1 = temp.substring(0,j) + (c == '9' ? 0 : c-'0'+1) + temp.substring(j+1);
                    String s2 = temp.substring(0,j) + ( c == '0' ? 9 : c-'0'-1)+temp.substring(j+1);
                    if(!deads.contains(s1) && !seen.contains(s1)){
                        queue.add(s1);
                        seen.add(s1);
                    }
                    if(!deads.contains(s2) && !seen.contains(s2)){
                        queue.add(s2);
                        seen.add(s2);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// deads存死锁情况。seen保证每个情况遍历一遍。
// 然后bfs，对每一位数字顺时针和逆时针转一次，转完后对string各自判断deads和seen。没问题的加入queue继续bfs。