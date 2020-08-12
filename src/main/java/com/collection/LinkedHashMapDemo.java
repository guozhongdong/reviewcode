package com.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/11
 * 使用linkedHashMap 实现一个 LRU缓存
 *
 * 缓存的核心，是去掉不经常使用的key，保留热key
 *
 */
public class LinkedHashMapDemo<K,V> extends LinkedHashMap<K,V>{

    private int num;

    public LinkedHashMapDemo(int size){

        super(size,1,true);
        this.num = size;

    }
    /*
    * 添加元素
    * */
    public void insert(K k,V v){
        super.put(k,v);
    }

    public void clearEle(){
        super.clear();
    }

    public int sizes(){
        return super.size();
    }
    /**
     * 访问元素
     * */
    public V pop(K k){
        return super.get(k);
    }


    /**
     * 超过容量就删除旧的元素
     * */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        //System.out.println(super.size());
        return super.size() > num;
    }

    public static void main(String[] args) {
        LinkedHashMapDemo linkedHashMapDemo = new LinkedHashMapDemo(3);
        linkedHashMapDemo.insert("haha","123");
        linkedHashMapDemo.insert("haha1","124");
        linkedHashMapDemo.insert("haha2","125");
        linkedHashMapDemo.insert("haha3","126");
        System.out.println(linkedHashMapDemo.num);
        System.out.println(linkedHashMapDemo.pop("haha1"));
        System.out.println(linkedHashMapDemo.sizes());
        System.out.println(linkedHashMapDemo.pop("haha3"));
        System.out.println(linkedHashMapDemo.sizes());
        System.out.println(linkedHashMapDemo.pop("haha"));

    }
}
