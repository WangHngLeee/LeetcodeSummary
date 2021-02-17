package AmazonNG;
import java.util.*;
public class DebtRecords_SmallestNegativeBalance_OK {

    public static List<String> debtRecords(List<List<String>> debts) {
        Map<String, Integer> map = new HashMap<>();

        // 注意 input 数据结构，如果是定义好的class 要用 debt.lender 和 debt.borrower， debt.amount

        for(List<String> debt : debts){
            String borrower = debt.get(0);
            String lender = debt.get(1);
            int amount = Integer.parseInt(debt.get(2));

            map.put(lender, map.getOrDefault(lender, 0) + amount);
            map.put(borrower, map.getOrDefault(borrower, 0) - amount);
        }

        int min = Integer.MAX_VALUE;
        for(int val : map.values()){
            min = Math.min(min, val);
        }
        List<String> res = new ArrayList<>();
        if(min >= 0){
            res.add("Nobody has a negative balance");
            return res;
        }
        for(String key: map.keySet()){
            if(map.get(key) == min){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}
