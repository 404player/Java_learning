package com.kuang.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] a = {1,4,6,3,7,4,8};
        int[] sort = sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] sort(int[] array){
        //临时变量
        int temp =0;

        //外层循环，判断我们这个要走几次
        for(int i=0; i<array.length-1; i++){

            boolean flag = false;//通过flag标志位减少没有意义的比较


            //内层循环，比较判断两个数，如果第一个数，比第二个大，则交换位置
            for(int j=0; j<array.length-1-i; j++){
                if(array[j+1] < array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(flag==false){
                break;
            }

        }
        return array;
    }
}
