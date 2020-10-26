package com.collection.generic;

public class GenericMethod {


    public <M> void method01(M m){
        System.out.println(m);
    }

    public static <S> void method02(S s){
        System.out.println(s);
    }
}
