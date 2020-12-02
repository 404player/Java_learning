package com.collection.map;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String,String > map = new HashMap<>();
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        map.put("d","d");
        System.out.println(map);


        System.out.println("------------------------");
        LinkedHashMap<String,String > link = new LinkedHashMap<>();
        link.put("a","a");
        link.put("c","c");
        link.put("b","b");
        link.put("d","d");
        System.out.println(link);


    }
}
