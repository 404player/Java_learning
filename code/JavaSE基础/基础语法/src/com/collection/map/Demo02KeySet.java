package com.collection.map;
/*
    Map集合第一种遍历方式：通过键找值的方式
    实现步骤：
        1. 使用Map集合中的方法keySet()，把Map集合所有的key取出来，存储到一个Set中
        2. 遍历set集合，获取Map集合中的每一个键
        3.通过Map集合中的方法get(key)，获取集合中的每一个value
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02KeySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Set<String> set = map.keySet();
        //使用迭代器遍历set集合
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }

    }
}
