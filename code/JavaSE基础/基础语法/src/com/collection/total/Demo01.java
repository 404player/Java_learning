package com.collection.total;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {
    public static void main(String[] args) {
        //创建集合，可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//重写了toString方法


        /*
        boolean返回值一般不用接收
         */
        boolean b1 = coll.add("张三");
        System.out.println(b1);
        System.out.println(coll);
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        /*
        public boolean remove()，集合中存在元素，删除元素，返回true
        集合中不存在元素，删除失败，返回false
         */
        boolean b2 = coll.remove("赵六");
        System.out.println("b2: "+b2);
        boolean b3 = coll.remove("赵四");
        System.out.println("b3: "+b3);

        boolean b4 = coll.contains("李四");
        System.out.println(b4);

        boolean b5 = coll.isEmpty();
        System.out.println(b5);//集合不为空返回false

        int size = coll.size();
        System.out.println("size: "+size);

        //public Object[] toArray
        //集合元素是多种多样的，变为数组要变成Object[]
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //public void clear():清空集合中所有元素，但是不删除集合，集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }
}
