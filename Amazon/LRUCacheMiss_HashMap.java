package AmazonNG;
import java.util.*;

class LRU{
    HashMap<Integer,Integer> map;
    List<Integer> list;
    int capacity;
    int size;
    int miss;

    public LRU(int capacity){
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.capacity = capacity;
        this.size = 0;
        this.miss = 0;
    }
    public void put(int key, int i){
        if(map.containsKey(key)){
            map.put(key, i);
            list.remove(key);
            list.add(key);
        }else{
            if(size == capacity){
                int oldKey = list.get(0);
                list.remove(0);
                map.remove(oldKey);
                size--;
            }
            list.add(key);
            map.put(key, i);
            size++;
            miss++;
        }
    }
}
public class LRUCacheMiss_HashMap{
    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        // WRITE YOUR BRILLIANT CODE HERE
        LRU cache = new LRU(maxCacheSize);
        for (int i = 0; i < num; i++) {
            cache.put(pages.get(i), i);
        }
        return cache.miss;
    }
}
