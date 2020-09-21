package com.oop.demo05;

//在Java中，所有的类，都默认直接或间接继承Oject类
public class Application {
    //静态方法和非静态的方法区别很大
        //静态方法：只和左边有关
        //非静态：才能选择重写
    public static void main(String[] args) {

        //方法的调用只和左边，定义的数据类型有关
        A a = new A();
        a.test();

        //父类的引用指向子类
        B b = new A();//子类重写了父类的方法，只和非静态有关
        b.test();

    }
}
