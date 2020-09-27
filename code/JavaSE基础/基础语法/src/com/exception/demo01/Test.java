package com.exception.demo01;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        int b = 0;
        try {
            new Test().test(a,b);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }


    }

    //假设这个方法中，处理不了这个异常，方法上抛出异常
    public void test(int a,int b) throws ArithmeticException{
        if(b==0){//throw  throws
            throw new ArithmeticException();//主动抛出异常,一般在方法中使用
        }
        System.out.println(a/b);
    }

}
