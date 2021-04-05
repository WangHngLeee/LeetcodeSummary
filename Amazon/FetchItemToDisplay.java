package AmazonNG;
import java.util.*;


//We sort the results by the sortColumn and order.
// Then using the pageSize and the pageIndex we can figure out how many results on the previous pages and the index of the first result on the target pageIndex page.

// Time: O(nlogn) , collection.sort() using merge sort inside
// Space: O(N)
public class FetchItemToDisplay {
    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, PairInt> items, int sortOrder, int itemsPerPage, int pageNumber) {
        // Create new arraylist to store all the names of items;
        List<String> res = new ArrayList<>();
        int size = items.size();

        // We need a variable to store the sort order like ascending or decending.
        // I use 1 to mean ascending and -1 to mean descending. This variable will be used in the later lamda sort function.
        int sort_sign = sortOrder == 0 ? 1 : -1;

        // add all the names to the res
        for (String key : items.keySet()) {
            res.add(key);
        }

        // here we need to take different sort order upon different sortparameters.
        // 0 : only sort the products by it's name
        if (sortParameter == 0) {
            Collections.sort((a, b) -> sort_sign * (a.compareTo(b)));
        }

        //1: sort the products by the timestamp, which is the first in the pairint.
        else if (sortParameter == 1) {
            Collections.sort((a, b) -> sort_sign * (items.get(a).first - items.get(b).first));
        }

        //2: sort the products by the relavance, which is the second in the pairint
        else {
            Collections.sort((a, b) -> sort_sign * (items.get(a).second - items.get(b).second));
        }

        // caculate the correct range of pages.
        // it's the index of start in the required page
        int start = itemsPerPage * pageNumber;

        // it's the index of end in the required page, but we need to comparet the res size and the max end index that current page
        // can reach. We need to make sure that the last index won't exceed the range of res.
        int end = Math.min(start + itemsPerPage, res.size());

        // then we just using sublist to get all the right products.
        return res.subList(start, end);
    }
}


//对于 sde 新人有什么建议
//如何衡量 sde 1 的成功/成果
//最喜欢亚麻和自己 team 的哪些地方
//对于亚麻未来发展趋势的预测等等