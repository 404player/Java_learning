package com.kuang.struct;

public class LableDemo01 {
    public static void main(String[] args) {
        //打印101-150之间所有的质数

        int count = 0;
        //不建议使用
        outer:for (int i=101;i<150;i++){
            for(int j=2;j<i/2;j++){
                if(i % j ==0){
                    continue outer;
                }
            }
            System.out.println(i);
        }
    }
}
