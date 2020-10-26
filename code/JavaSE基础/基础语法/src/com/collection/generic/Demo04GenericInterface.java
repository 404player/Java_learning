package com.collection.generic;

public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建GenericInterfaceImpl1对象
        GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
        gi1.method("good!");


        //创建GenericInterfaceImpl2对象
        GenericInterfaceImpl2<Double> gi2 = new GenericInterfaceImpl2<Double>();
        gi2.method(0.3);
    }

}
