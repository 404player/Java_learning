package com.kuang.scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入多个数字，并求其总和与平均数，没输入一个数字用回车确认，通过输入非数字来总结输入并输出执行结果
        Scanner scanner = new Scanner(System.in);

        double sum = 0;//和

        int m = 0;//输入的数字个数

        while(scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m+"个数和为"+sum);
        System.out.println(m+"个数平均值为"+(sum/m));


        scanner.close();

    }
}
