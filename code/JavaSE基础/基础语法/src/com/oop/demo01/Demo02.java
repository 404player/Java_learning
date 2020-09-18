package com.oop.demo01;

public class Demo02 {
    public static void main(String[] args) {

        //静态方法 static
//        Student.say();

        //非静态方法
        //实例化这个类 new
        //对象类型   对象名 = 对象值
        Student student = new Student();
        student.say();
    }


    // 有static的方法和类一起加载
    public static void   a(){

    }

    //类实例化后 才存在
    public void b(){
        a();
    }
}
