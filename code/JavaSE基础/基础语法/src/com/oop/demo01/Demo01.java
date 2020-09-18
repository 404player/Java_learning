package com.oop.demo01;

import java.io.IOException;

//Demo01类
public class Demo01 {

    //main方法
    public static void main(String[] args) {

    }


    /*
    修饰符  返回值类型  方法名(...){
        //方法体
        return 返回值;
    }
     */
    public  String  sayHello(){
        return "hello,world";
    }

    public int max(int a,int b){
        return a>b ? a:b;
    }

    public void readFile(String file) throws IOException{

    }
}
