package com.kuang.base;

public class Demo02 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出问题
        //JDK7新特性，数字之间可以用下划线分割
        int money = 10_0000_0000;
        System.out.println(money);
        int year = 20;
        long total = money*year;
        System.out.println(total); //long没有用，还是会出现溢出问题，计算的两个数都是int,所以计算结果都是int,后才转换成long

        long total2 = money*((long)year);
        System.out.println(total2);
    }
}