package com.collection.list;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//操作索引的时候一定要注意索引越界异常
//IndexOutOfBoundsException 索引越界异常
//ArrayIndexOutBoundsException 数组索引越界异常

public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合对象，多态
        List<String> list = new ArrayList<>();
        //使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        //打印集合
        System.out.println(list);//打印[a, b, c, a] 说明重写了toString方法

        //public void add
        list.add(3,"ithema");
        System.out.println(list);

        //public void remove
        String removeE= list.remove(2);
        System.out.println("被移除的元素"+removeE);
        System.out.println(list);

        //public void set
        String setE = list.set(3,"A");
        System.out.println("被替换的元素"+setE);
        System.out.println(list);

        //list集合遍历有三种方式
        //使用普通的for循环
        for (int i = 0; i < list.size(); i++) {
            //public E get(int index)
            String s =  list.get(i);
            System.out.println(s);

        }

        System.out.println("-------------------------");
        //使用迭代器来遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }


        System.out.println("-------------------");
        //使用增强for循环
        for(String s : list){
            System.out.println(s);
        }

    }
}
