package com.collection.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Phaser;

/*
    java.util.iterator迭代器：遍历集合中的元素
    Iterator迭代器，是一个接口。我们无法直接使用，需要使用Iterator接口的实现类，获取实现类的方式比较特殊
    Collection接口中有一个方法，叫iterator()，返回的就是迭代器的实现类对象
 */
public class Iterator {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        //往集合中添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");

        /*
        Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
         */
        java.util.Iterator<String> it = coll.iterator();
        boolean b = it.hasNext();
        System.out.println(b);
        while(it.hasNext()) {
            String s = it.next();
            System.out.print(s + "\t");
        }
            System.out.println("\n"+"----------------------");
            for(java.util.Iterator<String> it2 = coll.iterator();it2.hasNext();){
                String e = it2.next();
                System.out.println(e);
            }
        }

    }

