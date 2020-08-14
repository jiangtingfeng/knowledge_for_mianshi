/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.cachePoint;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author: jiangtingfeng
 * @Description:
 * 基于 双向链表 + HashMap 的 LRU 算法实现
 * @Date :Create in 10:31 2020/8/14
 */
public class LRU<K,V> implements Iterable<K> {

    Node head;
    Node tail;
    HashMap<K,Node> map;
    Integer maxSize;

    private class Node {
        Node pre;
        Node next;
        K k;
        V v;
        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    /**
     * 构造函数
     *  初始化 hashMap 的容量大小
     *  初始化 头指针  尾指针  以及他们之间的关系
     * */
    public LRU(int maxSize){
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);
        this.head = new Node(null,null);
        this.tail = new Node(null,null);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * get  《=====》  使用该节点
     * 没有则返回null
     * 有则 先去去除 该key对应的节点  然后再指针头部进行插入
     * */
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        unlink(node);
        appendHead(node);
        return node.v;
    }

    /**
     * put 向链表中添加Node节点
     * */
    public void put(K key,V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }
        Node node = new Node(key, value);
        map.put(key,node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        Node pre = node.pre;
        pre.next = tail;
        tail.pre = pre;

        node.pre = null;
        node.next = null;
        return node;
    }

    /** 将该节点重链表的头进行插入*/
    private void appendHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        next.pre = node;
        node.next = next;
    }

    /** 去除双向链表中的node节点*/
    private void unlink(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Node cur= head.next;
            @Override
            public boolean hasNext() {
                return cur != tail;
            }
            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }
}
