package com.collection.collections;

import java.util.ArrayList;
import java.util.Collections;


//使用前提：被排序的集合里存储的元素，必须实现Comparable,重写接口中的方法compareTo定义排序的规则

//Comparable接口的排序规则：
//this-参数： 升序
//参数-this: 降序
public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);//[1, 3, 2]

        Collections.sort(list01);//默认是升序
        System.out.println(list01);//[1, 2, 3]

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("A");
        list02.add("D");
        list02.add("C");
        System.out.println(list02);

        Collections.sort(list02);
        System.out.println(list02);


        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("张三",18));
        list03.add(new Person("李四",20));
        list03.add(new Person("王五",15));
        System.out.println(list03);

        Collections.sort(list03);
        System.out.println(list03);

    }
}
