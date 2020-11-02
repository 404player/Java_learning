package com.collection.set;

import java.util.HashSet;

/*
    HashSet存储自定义类型元素

    set集合保证元素唯一：
        存储的元素(String,Integer,....Student,Person...),必须重写hashCode和equal方法

    要求：
        同名同年龄的人，视为同一个人，只能存储一次
 */
public class Demo03HashSetSavePerson {
    public static void main(String[] args) {
        //创建HashSet集合存储Person
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("小美女",18);
        Person p2 = new Person("小美女",18);
        Person p3 = new Person("小美女",19);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1==p2);//flase
        System.out.println(p1.equals(p2));//flase 没有重写比较的是两个对象的地址值
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }

}
