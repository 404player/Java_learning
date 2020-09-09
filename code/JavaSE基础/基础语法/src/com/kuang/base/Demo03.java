package com.kuang.base;

public class Demo03 {
    //属性：变量

    //实例变量： 从属于对象,如果不进行初始化，这个类型的默认值 0 0.0 u0000 false
    //除了基本类型其余都是null
    String name;
    int age;

    //类变量 static
    static double salary = 2500;

    //main方法
    public static void main(String[] args) {

        //局部变量：必须声明和初始话值
        int i = 10;

        Demo03 demo03 = new Demo03();
        System.out.println(demo03.age);
        System.out.println(demo03.name);
        System.out.println(salary);

        //类变量 static
    }

    //其他方法
    public void add() {

    }
}
