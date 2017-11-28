package com.letsdecode.problems.linkedlist;

import java.util.HashMap;

public class LRUCache {
    public class ListNode {
        public int value;
        public int key;
        public ListNode next;
        public ListNode pre;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, ListNode>m = new HashMap();
    public ListNode head;
    public ListNode tail;
    private int capacity = 10; 
    private void addHead(ListNode n) {
        if (head == null) {
            tail = n; 
        } else {
            n.next = head;
            head.pre = n;
        }
        head = n;
    }
    
    public void removeNode(ListNode n) {
        ListNode nextNode = n.next;
        ListNode preNode = n.pre;
        if (nextNode != null) {
            nextNode.pre = preNode;
        } 
        if (preNode != null) {
            preNode.next = nextNode;
        }
        if (head == n) {
            head = nextNode;
        } 
        if (tail == n) {
            tail = preNode;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode n = m.get(key);
        if (n == null) {
            return -1;
        } 
        removeNode(n);
        addHead(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        ListNode n = m.get(key);
        if (n == null) {
            ListNode node = new ListNode(key, value);
            n = node; 
            if (head == null) {
                addHead(node);
            } else if (m.size() <= capacity) {
                if (m.size() == capacity) {
                    removeNode(tail);
                    m.remove(key);
                }
                addHead(node);
            }                 
        } else {
            n.value = value;
        }
        m.put(key, n);        
    }
}
