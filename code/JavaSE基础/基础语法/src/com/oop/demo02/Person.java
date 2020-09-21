package com.oop.demo02;

public class Person {

    //一个类即使什么都不写，他也会存在一个方法
    //显式的定义构造器
    String name;

    //实例化初始值
    // 1.使用new关键字，必须要有构造器
    // 2.用来初始化值
//    public Person(){
//        this.name = "404player";
//    }


    public  Person(){

    }

    //有参构造:一旦定义了有参构造，无参就必须显示定义
    public Person(String name){
        this.name = name;
    }


    //alt+insert 生成构造器
}
