package com.collection.map;

import java.util.HashMap;
import java.util.Hashtable;

/*
    Hashtable和Vector集合一样，在jdk1.2版本之后被更先进的集合（HashMap,ArrayList)取代了
    Hashtable的子类Properties依然活跃在历史舞台
    Properties集合是唯一一个和IO流相结合的集合
 */
public class Demo06Hashtable {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"a");
        map.put("b",null);
        map.put(null,null);
        System.out.println(map);//可以存储null

        Hashtable<String,String > table = new Hashtable<>();
        table.put(null,"a");
        System.out.println(table);//NullPointerException异常

    }
}
