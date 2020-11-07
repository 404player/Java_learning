package com.collection.map;

import java.util.HashMap;
import java.util.Map;

/*
    java.util.Map<k,v>
 */
public class Demo01Map {
    public static void main(String[] args) {
        show03();
    }

    /*
        public V put(K key, V value)
        返回值V：
            存储键值对的时候，key不重复，返回值V为null
            存储键值对的时候，key重复，会使用新的value替换map的value，返回被替换的value值
     */


    private  static void show01(){
        //创建Map集合对象，多态
        Map<String,String> map = new HashMap<>();
        String v1 = map.put("lichen","fanbingbing");
        System.out.println("v1:"+v1);

        String v2 = map.put("lichen","fanbingbing");
        System.out.println("v2:"+v2);

        System.out.println(map);

        map.put("lengfeng","longxiaoyun");
        map.put("yangguo","xiaolongnv");
        System.out.println(map);

    }

    /*
        public V put(Object key)
     */


    private static void show02(){
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Integer v1 =  map.remove("赵丽颖");
        //int v1  可以用int类型接收，但是要是键不存在，null无法赋值给int
        System.out.println("v1: "+v1);
        System.out.println(map);

        System.out.println(map.get("杨颖"));
        System.out.println(map.get("迪丽热巴"));



    }

    /*
        public V get(Object Key)

     */

    private static void show03(){

        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        boolean b1 = map.containsKey("赵丽颖");
        boolean b2 = map.containsKey("好东西");
        System.out.println("b2"+b2);
        System.out.println("b1"+b1);


    }
}




