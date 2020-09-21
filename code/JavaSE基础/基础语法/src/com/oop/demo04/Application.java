package com.oop.demo04;

/*
1.提高程序的安全性，保护数据
2.隐藏代码的实现细节
3.统一接口
4.系统可维护性增加了
 */

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("404player");
        String name = s1.getName();

        System.out.println(name);

        s1.setAge(999);
        System.out.println(s1.getAge());

    }
}
