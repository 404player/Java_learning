package com.kuang.method;
//容易造成栈溢出，能不用尽量不用
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public  static  int f(int n){
        if(n==1 || n==0){
            return 1;
        }else{
            return n*f(n-1);
        }
    }
}

