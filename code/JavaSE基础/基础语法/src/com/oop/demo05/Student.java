package com.oop.demo05;


//学生   is   人
public class Student extends Person {
    //Ctrl + H
    //要么调用父类super()，要么调用子类this()
    //隐藏代码，调用父类的无参构造
    //调用父类的构造器，必须要在子类构造器的第一行
    public Student() {
        System.out.println("Student无参构造执行了");
    }

    private String name = "404player";

    public void print(){
        System.out.println("Student");
    }

    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

    public void test1(){
        print();
        this.print();
        super.print();
    }






}
