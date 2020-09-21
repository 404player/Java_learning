package com.oop.demo02;


//一个项目应该只存在一个main方法
public class Application {
    public static void main(String[] args) {

        //new 实例化对象
        Person person = new Person("geekboy");

        System.out.println(person.name);


    }
}
