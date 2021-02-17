package AmazonNG;
import java.util.*;
import java.util.stream.Collectors;

public class DiskSpaceAnalysis_MaxMinmum_OK {
    static int res = Integer.MIN_VALUE;
    public static int MaxInMinimal(int numComputer, List<Integer> hardDiskSpace, int segmentLength) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<hardDiskSpace.size(); i++){
            int cur = hardDiskSpace.get(i);
            // 往前匹配，直到找到比当前num小的元素，也就是上一个循环里最小值。

            while(!dq.isEmpty() && cur < hardDiskSpace.get(dq.peekLast())){
                dq.pollLast();
            }
            // 如果上一轮的最小值index 和当前的位置距离超出了规定的segement lengt， pop掉
            if(!dq.isEmpty() && dq.peekFirst() <= (i - segmentLength)){ // 超过了要求的segement length，pop掉first
                dq.removeFirst();
            }

            dq.addLast(i);

            // 当走到当前segement length最后一个的时候才更新max。
            if(!dq.isEmpty() && i >= segmentLength - 1 ){
                res = Math.max(res, hardDiskSpace.get(dq.peekFirst()));// 在min里更新max
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numComputer = Integer.parseInt(scanner.nextLine());
        List<Integer> hardDiskSpace = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int segmentLength = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = MaxInMinimal(numComputer, hardDiskSpace, segmentLength);
        System.out.println(res);
    }
}
