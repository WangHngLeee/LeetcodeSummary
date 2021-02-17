package AmazonNG;

import java.util.*;

class LRUCache{
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(){};
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;
    int capacity;
    int size;
    int miss;
    public LRUCache(int capacity){
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
        miss = 0;
    }
    public int get(int key){
        if(!map.containsKey(key))return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value){
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            removeNode(map.get(key));
            addToHead(node);
            map.put(key, node);
        }else{
            if(size == capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
            map.put(key,node);
            addToHead(node);
            size++;
            miss++;
        }
    }
    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    public void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    public Node removeTail(){
        Node res = tail.pre;
        removeNode(res);
        return res;
    }
}

public class LRUCacheMiss_DoubleLinkedList {
    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        // WRITE YOUR BRILLIANT CODE HERE
        LRU cache = new LRU(maxCacheSize);
        for (int i = 0; i < num; i++) {
            cache.put(pages.get(i), i);
        }
        return cache.miss;
    }
}


