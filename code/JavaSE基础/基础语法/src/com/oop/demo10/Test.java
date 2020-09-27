package com.oop.demo10;

public class Test {
    public static void main(String[] args) {
        //没有名字初始化类，不用将实例保持到变量中

        new Apple().eat();

        new UserSevice(){
            @Override
            public void hello() {

            }
        };
    }
}


class Apple{
    public  void eat(){
        System.out.println("1");
    }
}

interface UserSevice{
    void hello();
}
