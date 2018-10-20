package com.zsx.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间
 */
public class Q_146 {

    //限制队列的长度
    private int capacity;
    //缓存页的队列
    private List<Page> list = new ArrayList<>();

    public Q_146(int capacity){
        this.capacity = capacity;
    }

    private class Page{
        private int key;
        private int value;

        private Page(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //取出页
    public int get(int key){
        //查找是否存在
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).key == key){
                //存在页，将页放置队尾
                Page p = list.get(i);
                list.remove(i);
                list.add(p);
                return p.value;
            }
        }
        return -1;
    }

    //存入页
    public void put(int key, int value){
        //队列未满
        if (list.size() < this.capacity){
            list.add(getPage(key, value));
        }else {
            boolean flag = true;
            //查找页是否存在
            for (int i = 0; i < list.size(); i++){
                //存在页，将页放置队尾
                if (list.get(i).key == key){
                    Page p = list.get(i);
                    list.remove(i);
                    list.add(p);
                    flag = false;
                }
            }
            //不存在页，移除队首
            if (flag){
                list.remove(0);
                list.add(getPage(key, value));
            }
        }
    }

    private Page getPage(int key, int value){
        return new Page(key, value);
    }
}
