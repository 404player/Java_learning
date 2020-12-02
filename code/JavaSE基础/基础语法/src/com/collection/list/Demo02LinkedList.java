package com.collection.list;
/*
    java.util.LinkedList集合： implements List接口
 */



import java.util.LinkedList;

public class Demo02LinkedList {
    public static void main(String[] args) {
        //show01();
        //show02();
        show03();
    }



    private static void show02(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");

        linked.clear();//清空集合中的元素，在获取集合中的元素时会抛出NoSuchElementException异常

        if(!linked.isEmpty()){
            String first = linked.getFirst();
            System.out.println(first);//a
            String last = linked.getLast();
            System.out.println(last);//c
        }

    }

    private static void show01(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);

        //public void addFirst(E e)
        linked.addFirst("www");
        System.out.println(linked);

        //public void push
        linked.push("w3c");
        System.out.println(linked);

        //public void addLast(E e) === public void add(E e)
        linked.addLast("html");
        System.out.println(linked);
    }

    private static void show03(){
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);


        String first =  linked.removeFirst();
        //linked.pop()一样的效果
        System.out.println(first);
        String last =   linked.removeLast();
        System.out.println(last);

        System.out.println(linked);



    }
}


