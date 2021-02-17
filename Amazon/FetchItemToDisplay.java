package AmazonNG;
import java.util.*;
public class FetchItemToDisplay {
    public static List<String> fetchItemsToDisplay_PQ(int sortParameter, int sortOrder, int itemsPerPage, int pageNumber, Map<String, int[]> items) {
        // WRITE YOUR BRILLIANT CODE HERE

        /*
            PQ solution
         */
        int sort = sortOrder == 0 ? 1 : -1;
        PriorityQueue<Map.Entry<String, int[]>> pq;
        if (sortParameter == 0) {
            pq = new PriorityQueue<>((a, b) -> sort * (a.getKey().compareTo(b.getKey())));
        } else if (sortParameter == 1) {
            pq = new PriorityQueue<>((a, b) -> sort * (a.getValue()[0] - b.getValue()[0]));
        } else {
            pq = new PriorityQueue<>((a, b) -> sort * (a.getValue()[1] - b.getValue()[1]));
        }

        for (Map.Entry<String, int[]> entry : items.entrySet()) {
            pq.add(entry);
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<String, int[]> temp = pq.poll();
            res.add(temp.getKey());
        }
        int start = itemsPerPage * pageNumber;
        int end = Math.min((start + itemsPerPage), res.size());
        return res.subList(start, end);
    }


        /*
              List<String> self sort solution
        */

    public static List<String> fetchItemsToDisplay_List(int sortParameter, int sortOrder, int itemsPerPage, int pageNumber, Map<String, int[]> items) {
        int sign = sortOrder == 0 ? 1 : -1;
        List<String> res = new ArrayList<>();
        for(String key : items.keySet()){
            res.add(key);
        }
        if(sortParameter == 0){
            res.sort((a, b) -> sign * (a.compareTo(b)));
        }else if(sortParameter == 1){
            res.sort((a, b) -> sign * (items.get(a)[0] - items.get(b)[0]));
        }else{
            res.sort((a, b) -> sign * (items.get(a)[1] - items.get(b)[1]));
        }
        int start = itemsPerPage * pageNumber;
        int end = Math.min((start + itemsPerPage), res.size());
        return res.subList(start,end);
    }

    /*
        algomaster 标准答案
     */

    public static List<String> fetchItemsToDisplay_Answer(int sortParameter, int sortOrder, int itemsPerPage, int pageNumber, Map<String, int[]> items) {

        ArrayList<String> ordered = new ArrayList<>(items.keySet()); // create a list of item names
        ordered.sort((a, b) -> {
            int res;
            if (sortParameter == 0) { // compare item name alphabetical
                res = a.compareTo(b);
            } else {
                // compare by relevance or price. sortParamter - 1 because subtracting the item name spot
                res = items.get(a)[sortParameter - 1] - items.get(b)[sortParameter - 1];
            }
            return res * (sortOrder == 0 ? 1 : -1); // if reverse order, then * -1
        });
        int startIndex = itemsPerPage * pageNumber;
        return ordered.subList(startIndex, Math.min(startIndex + itemsPerPage, ordered.size()));
    }
}
