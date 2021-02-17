package AmazonNG;

import java.util.*;
import java.util.stream.Collectors;

// Max uinits
public class FillTruck_OK {
    public static int fillTheTruck(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {

        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0; i<boxes.size(); i++){
            pq.add(new int[]{unitsPerBox.get(i),boxes.get(i)});
        }
        while(truckSize > 0 && !pq.isEmpty()){
            int[] temp = pq.poll();
            int units = temp[0];
            int box = Math.min(truckSize, temp[1]); // 注意 如果有long型要强转int
            res += units * box;
            truckSize -= box;
        }
        return res;
    }








    public static void main(String[] args) {
        List<Integer> boxes = Arrays.asList(3,2,1,5,2,2);
        List<Integer> unitSize = Arrays.asList(3,2,1,7,3,8);
        int res = fillTheTruck(5, boxes, 3, unitSize, 5);
        System.out.println(res);
    }
}
