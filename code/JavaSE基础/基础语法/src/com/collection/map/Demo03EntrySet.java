package com.collection.map;
/*
    Map集合遍历的第二种方法:使用Entry对象遍历
   实现步骤：
   1. 使用entrySet()把Map集合中多个Entry对象取出来，存储到一个Set集合中
   2. 遍历Set集合，获取每一个Entry对象
   3. 使用Entry对象中的方法getKey()和getValue()获取键与值
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo03EntrySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        //使用迭代器遍历Set
        Iterator<Map.Entry<String,Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            String key  = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);

        }

        System.out.println("------------------------------------------");

        for(Map.Entry<String,Integer> entry:set){
            String key =   entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
    }
}
