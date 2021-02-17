package AmazonNG;
import java.util.*;
public class HighestProfit {
    public static int findProfit(int numSuppliers, List<Integer> inventory, int order) {
        // WRITE YOUR BRILLIANT CODE HERE

        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int maxProfit = Integer.MIN_VALUE;
        for(int profit : inventory){
            map.put(profit, map.getOrDefault(profit,0) + 1);
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        while( order > 0 ){
            int count = Math.min(order, map.get(maxProfit));
            res += count * maxProfit;
            order -= count;
            map.put(maxProfit, map.get(maxProfit) - count);
            int nextPrice = maxProfit - 1;
            map.put(nextPrice, map.getOrDefault(nextPrice,0) + count);
            if(map.get(maxProfit) == 0){
                map.remove(maxProfit);
                maxProfit--;
            }
        }
        return res;
    }
}
