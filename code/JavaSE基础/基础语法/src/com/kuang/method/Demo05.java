package com.kuang.method;

public class Demo05 {
    public static void main(String[] args) {
        Demo05 test = new Demo05();
        test.test();//栈溢出
    }

    public void test(){
        test();
    }
}
