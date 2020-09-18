package com.kuang.array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        //打印所有数组元素

        for(int i =0; i<array.length;i++){
            System.out.println(array[i]);
        }

        System.out.println("===================");
        //计算所有元素的和
        int sum = 0;
        for (int i=0 ; i<array.length; i++){
            sum+=array[i];
        }
        System.out.println("sum="+sum);
        System.out.println("====================");

        //查找最大元素
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }

        }
        System.out.println("max="+max);
    }
}
