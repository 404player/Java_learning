package com.kuang.operator;

public class Demo07 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        a+=b;

        System.out.println(a);

        //字符串连接符

        System.out.println(a+b);
        System.out.println(""+a+b);//只要有String类型，后面的会转成String类型进行拼接

        System.out.println(a+b+"");//加在后面就不会拼接
    }
}
