package com.collection.generic;

import java.security.CodeSigner;

public class Demo02GenericClass {

    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass gc = new GenericClass();
        gc.setName(123);

        //创建GenericClass对象，泛型使用Integer类型
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(123);

        int name = gc2.getName();
        System.out.println(name);

        //创建GenericClass对象，泛型使用Integer类型
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("aha");

        String name1 =  gc3.getName();
        System.out.println(name1);

    }
}
