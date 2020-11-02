package com.collection.hashCode;

import java.util.Set;

public class Demo01HashCode {

    public static void main(String[] args) {
        //Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(h1);//460141958

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2);//1163157884

        /*
        toString方法:
          return getClass().getName()+"@"+Integer.toHexString(hashCode());
        */

        System.out.println(p1);//com.collection.hashCode.Person@1b6d3586
        System.out.println(p2);//com.collection.hashCode.Person@4554617c

        System.out.println(p1==p2);//flase  重写方法以后，也是flase

        /*
            String类的哈希值
                String类重写Object类的hashCode方法

         */

        String s1 = new String("abc");
        String s2 = new String ("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354
        System.out.println("abc".hashCode());

        System.out.println(s1.hashCode()==s2.hashCode());//true

        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());//刚好相等

    }
}
