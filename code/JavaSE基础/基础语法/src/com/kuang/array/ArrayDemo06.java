package com.kuang.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,9090,31231,543,21,3,23};

        System.out.println(a);

        System.out.println(Arrays.toString(a));
        Arrays.sort(a);//升序排序
        System.out.println(Arrays.toString(a));

        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
        //填充数组
    }
}
