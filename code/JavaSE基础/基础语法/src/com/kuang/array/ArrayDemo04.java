package com.kuang.array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays =  {1,2,3,4};
//
//        for(int array:arrays){
//            System.out.println(array);
//        }
//        printArray(arrays);
        printArray(reverse(arrays));
    }

    //打印数组元素方法
    public static void  printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    //反转数组
    public static  int[] reverse(int[] arrays){
        int[] result = new int[arrays.length];
        for (int i = 0,j = arrays.length-1; i < arrays.length; i++,j--) {
            result[j] = arrays[i];
        }




        return  result;
    }
}
