package com.oop.demo02;


//学生类
public class Student {
    //属性：字段
    String name;//null
    int age;//0


    //方法
    public void study(){
        System.out.println(this.name+"在学习");
    }
}


/*
 public static void main(String[] args) {

        //类：抽象的，需要实例化为对象
        //类实例化之后会返回一个具体的对象
        //student对象就是一个Student类的具体实例

        Student xiaoming = new Student();
        Student xiaohong = new Student();

        xiaoming.name = "xiaoming";
        xiaoming.age = 3;
        System.out.println(xiaoming.name);

        System.out.println(xiaohong.name);
        System.out.println(xiaohong.age);
    }
 */