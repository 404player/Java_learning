package com.collection.set;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo01Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //使用add方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        //使用迭代器遍历Set集合
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer next = it.next();
            System.out.println(next);
        }

        //使用增强for遍历set集合
        System.out.println("------------------------");
        for(Integer i : set){
            System.out.println(i);
        }

    }
}
