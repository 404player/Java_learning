package com.collection.generic;

import sun.net.www.content.text.Generic;

/*
    测试含有泛型的方法
 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        //调用含有泛型的方法
        gm.method01(10);
        gm.method01("abc");
        gm.method01(8.8);
        gm.method02("静态方法，不建议创建对象使用");

        GenericMethod.method02(123);
    }
}
