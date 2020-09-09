package com.kuang.operator;

public class Demo06 {
    public static void main(String[] args) {
        /*
        A = 0011 1100
        B = 0000 1101

        A&B 与 0000 1100
        A/B 或 0011 1101
        A^B 异或 0011 0001
        ~B  取反 11110010

        2*8 = 16 2*2*2*2
        << >>
        << *2
        >> /2
        优点：位运算效率高
         */
        System.out.println(2<<3);


    }
}
